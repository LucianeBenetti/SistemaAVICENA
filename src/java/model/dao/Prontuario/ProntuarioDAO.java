package model.dao.Prontuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.dao.ConexaoComBanco;
import model.dao.Consulta.ConsultaDAO;
import model.vo.Consulta.ConsultaVO;
import model.vo.Prontuario.ProntuarioVO;

public class ProntuarioDAO {

    ProntuarioVO prontuario = new ProntuarioVO();
    ConsultaDAO consultaDAO = new ConsultaDAO();

    public int inserir(ProntuarioVO prontuario) {
        int novoId = -1;

        String query = " INSERT INTO prontuario (codigoConsulta, medicamento, exame, registro) "
                + " VALUES (?, ?, ?,?) ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

        try {

            prepStmt.setInt(1, prontuario.getConsulta().getCodigoConsulta());
            prepStmt.setString(2, prontuario.getMedicamento());
            prepStmt.setString(3, prontuario.getExame());
            prepStmt.setString(4, prontuario.getRegistro());

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

    public boolean delete(int codigoProntuario) {
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
            System.out.println("Erro ao executar Query de Exclus�o do Prontu�rio! Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoDelete;
    }

    public ProntuarioVO consultarProntuarioPorId(int id) {

        String query = " SELECT *from prontuario " + " where codigoProntuario = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setInt(1, id);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {

                prontuario.setCodigoProntuario(result.getInt(1));
                ConsultaVO consulta = consultaDAO.consultarPorId(result.getInt(2));
                prontuario.setConsulta(consulta);
                prontuario.setMedicamento(result.getString(3));
                prontuario.setExame(result.getString(4));
                prontuario.setRegistro(result.getString(5));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closeStatement((Connection) prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return prontuario;
    }

    public boolean atualizar(ProntuarioVO prontuario, int codigoProntuario) {
        boolean sucessoAtualizar = false;

        String query = " UPDATE prontuario SET codigoConsulta=?, medicamento=?, exame=?, registro=? "
                + " where codigoProntuario = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {

            prepStmt.setInt(1, prontuario.getConsulta().getCodigoConsulta());
            prepStmt.setString(2, prontuario.getMedicamento());
            prepStmt.setString(3, prontuario.getExame());
            prepStmt.setString(4, prontuario.getRegistro());
            prepStmt.setInt(5, prontuario.getCodigoProntuario());

            int codigoRetorno = prepStmt.executeUpdate();

            if (codigoRetorno == 1) {
                sucessoAtualizar = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar Query de Atualiza��o do Prontu�rio!Causa: \n: " + ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoAtualizar;
    }

    public ArrayList<ProntuarioVO> listarTodos() {

        ArrayList<ProntuarioVO> listaProntuarios = new ArrayList<ProntuarioVO>();
        String query = " select * from prontuario ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                ProntuarioVO prontuario = new ProntuarioVO();

                prontuario.setCodigoProntuario(result.getInt(1));
                ConsultaVO consulta = consultaDAO.consultarPorId(result.getInt(2));
                prontuario.setConsulta(consulta);
                prontuario.setMedicamento(result.getString(3));
                prontuario.setExame(result.getString(4));
                prontuario.setRegistro(result.getString(5));

                listaProntuarios.add(prontuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProntuarios;
    }

    public ArrayList<ProntuarioVO> listarProntuariosDoPaciente(int idPaciente) {

        ArrayList<ProntuarioVO> listaProntuarios = new ArrayList<ProntuarioVO>();

        String query = " SELECT prt.* from prontuario prt, consulta con, paciente pac "
                + " WHERE prt.codigoConsulta = con.codigoConsulta "
                + "     AND pac.codigoPaciente = con.codigoPaciente "
                + "     AND pac.codigoPaciente = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setInt(1, idPaciente);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                ProntuarioVO prontuario = new ProntuarioVO();

                prontuario.setCodigoProntuario(result.getInt(1));
                ConsultaVO consulta = consultaDAO.consultarPorId(result.getInt(2));
                prontuario.setConsulta(consulta);
                prontuario.setMedicamento(result.getString(3));
                prontuario.setExame(result.getString(4));
                prontuario.setRegistro(result.getString(5));

                listaProntuarios.add(prontuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProntuarios;
    }

}
