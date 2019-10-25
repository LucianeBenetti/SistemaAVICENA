package model.dao.prontuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.dao.ConexaoComBanco;
import model.dao.paciente.PacienteDAO;
import model.vo.paciente.PacienteVO;
import model.vo.prontuario.ProntuarioVO;

public class ProntuarioDAO {

    ProntuarioVO prontuario = new ProntuarioVO();
    PacienteDAO pacienteDAO = new PacienteDAO();

    public int cadastrarProntuario(ProntuarioVO prontuario) {
        int novoId = -1;

        String query = " INSERT INTO prontuario (codigoPaciente, medicamento, exame, procedimento, registro) "
                + " VALUES (?, ?, ?, ?, ?) ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

        try {

            prepStmt.setInt(1, prontuario.getPacienteVO().getCodigoPaciente());
            prepStmt.setString(2, prontuario.getMedicamento());
            prepStmt.setString(3, prontuario.getExame());
            prepStmt.setString(4, prontuario.getProcedimento());
            prepStmt.setString(5, prontuario.getRegistro());

            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Cadastro de Prontu�rio! Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return novoId;
    }

    public boolean excluirProntuarioPorId(int codigoProntuario) {
        boolean sucessoDelete = false;

        String query = " DELETE from prontuario where codigoProntuario = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {
            prepStmt.setInt(1, codigoProntuario);
            int codigoRetorno = prepStmt.executeUpdate();
            if (codigoRetorno == 1) {
                sucessoDelete = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Exclusão do Prontuário! Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoDelete;
    }

    public List<ProntuarioVO> consultarProntuarioVOPorId(int codigoPaciente) {

        ArrayList<ProntuarioVO> listaProntuarios = new ArrayList<ProntuarioVO>();
        String query = " SELECT *from prontuario " + " where codigoPaciente = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setInt(1, codigoPaciente);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {

                ProntuarioVO prontuarioVO = new ProntuarioVO();

                prontuarioVO.setCodigoProntuario(result.getInt(1));
                PacienteVO paciente = pacienteDAO.consultarPorId(result.getInt(2));
                prontuarioVO.setPacienteVO(paciente);
                prontuarioVO.setMedicamento(result.getString(3));
                prontuarioVO.setExame(result.getString(4));
                prontuarioVO.setProcedimento(result.getString(5));
                prontuarioVO.setRegistro(result.getString(6));
                listaProntuarios.add(prontuarioVO);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return listaProntuarios;
    }

    public boolean atualizarProntuarioVO(ProntuarioVO prontuarioVO, int codigoProntuario) {
        boolean sucessoAtualizar = false;

        String query = " UPDATE prontuario SET codigoPaciente=?, medicamento=?, exame=?, procedimento=?, registro=? "
                + " where codigoProntuario = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {

            prepStmt.setInt(1, prontuarioVO.getPacienteVO().getCodigoPaciente());
            prepStmt.setString(2, prontuarioVO.getMedicamento());
            prepStmt.setString(3, prontuarioVO.getExame());
            prepStmt.setString(4, prontuarioVO.getProcedimento());
            prepStmt.setString(5, prontuarioVO.getRegistro());
            prepStmt.setInt(6, prontuarioVO.getCodigoProntuario());

            int codigoRetorno = prepStmt.executeUpdate();

            if (codigoRetorno == 1) {
                sucessoAtualizar = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar Query de Atualização do Prontuário!Causa: \n: " + ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoAtualizar;
    }

    public ArrayList<ProntuarioVO> listarTodosOsProntuariosVO() {

        ArrayList<ProntuarioVO> listaProntuarios = new ArrayList<ProntuarioVO>();
        String query = " select * from prontuario ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                ProntuarioVO prontuario = new ProntuarioVO();

                prontuario.setCodigoProntuario(result.getInt(1));
                PacienteVO paciente = pacienteDAO.consultarPorId(result.getInt(2));
                prontuario.setPacienteVO(paciente);
                prontuario.setMedicamento(result.getString(3));
                prontuario.setExame(result.getString(4));
                prontuario.setProcedimento(result.getString(5));
                prontuario.setRegistro(result.getString(6));

                listaProntuarios.add(prontuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProntuarios;
    }

}
