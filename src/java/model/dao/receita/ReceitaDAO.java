package model.dao.receita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.dao.ConexaoComBanco;
import model.dao.consulta.ConsultaDAO;
import model.vo.consulta.ConsultaVO;
import model.vo.receita.ReceitaVO;

public class ReceitaDAO {

    private ConsultaDAO consultaDAO = new ConsultaDAO();

    public ArrayList<ReceitaVO> buscarReceitasConsultaPaciente(int codigoConsulta) {

        ArrayList<ReceitaVO> listaReceitas = new ArrayList<ReceitaVO>();
        String query = " SELECT * from receita where codigoConsulta = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setInt(1, codigoConsulta);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                ReceitaVO receitaVO = new ReceitaVO();
                receitaVO.setCodigoReceita(result.getInt(1));
                ConsultaVO consultaVO = consultaDAO.consultarPorId(codigoConsulta);
                receitaVO.setConsultaVO(consultaVO);
                receitaVO.setMedicamento(result.getString(3));
                receitaVO.setExame(result.getString(4));
                receitaVO.setObservacao(result.getString(5));
                listaReceitas.add(receitaVO);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return listaReceitas;
    }

    public int cadastrarReceitaVO(ReceitaVO receitaVO) {

        int novoId = -1;

        String query = " INSERT INTO receita (codigoConsulta, medicamento, exame, observacao) "
                + " VALUES (?, ?, ?, ?) ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

        try {

            prepStmt.setInt(1, receitaVO.getConsultaVO().getCodigoConsulta());
            prepStmt.setString(2, receitaVO.getMedicamento());
            prepStmt.setString(3, receitaVO.getExame());
            prepStmt.setString(4, receitaVO.getObservacao());

            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Cadastro de Receita! Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return novoId;
    }

    public boolean atualizarReceitaVO(ReceitaVO receitaVO, int codigoReceita) {
        boolean sucessoAtualizar = false;

        String query = " UPDATE receita SET codigoConsulta=?, medicamento=?, exame=?, observacao=? "
                + " where codigoReceita = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {

            prepStmt.setInt(1, receitaVO.getConsultaVO().getCodigoConsulta());
            prepStmt.setString(2, receitaVO.getMedicamento());
            prepStmt.setString(3, receitaVO.getExame());
            prepStmt.setString(4, receitaVO.getObservacao());
            prepStmt.setInt(5, receitaVO.getCodigoReceita());

            int codigoRetorno = prepStmt.executeUpdate();

            if (codigoRetorno == 1) {
                sucessoAtualizar = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar Query de Atualização do Receita! Causa: \n: " + ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoAtualizar;
    }

}
