package model.dao.Consulta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.dao.ConexaoComBanco;
import model.dao.Convenio.ConvenioDAO;
import model.dao.Especializacao.EspecializacaoDAO;
import model.dao.Paciente.PacienteDAO;
import model.vo.Consulta.ConsultaVO;
import model.vo.Convenio.ConvenioVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Paciente.PacienteVO;

public class ConsultaDAO {

    private EspecializacaoDAO especializacaoDAO = new EspecializacaoDAO();
    private ConvenioDAO convenioDAO = new ConvenioDAO();
    private PacienteDAO pacienteDAO = new PacienteDAO();

    public int cadastrarConsulta(ConsultaVO consulta) {

        int novoId = 0;

        String sql = "INSERT INTO consulta (codigoEspecializacao, codigoPaciente, codigoConvenio, dataConsulta, atencaoEspecial, horarioConsulta)"
                + " VALUES (?,?,?,?,?,?)";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

        try {

            prepStmt.setInt(1, consulta.getEspecializacaoVO().getCodigoEspecializacao());
            prepStmt.setInt(2, consulta.getPacienteVO().getCodigoPaciente());
            prepStmt.setInt(3, consulta.getConvenioVO().getCodigoConvenio());
            prepStmt.setString(4, consulta.getDataConsulta());
            prepStmt.setString(5, consulta.getAtencaoEspecial());
            prepStmt.setString(6, consulta.getHorarioConsulta());
            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar o Cadastro do Consulta! Causa: \n: " + e.getMessage());

        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        System.out.println("cadastrado " + novoId);
        return novoId;

    }

    public ArrayList<ConsultaVO> consultarPorPaciente(int codigoPaciente) {

        ArrayList<ConsultaVO> listaConsultas = new ArrayList<ConsultaVO>();
        String query = "SELECT * from consulta " + " where codigoPaciente = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setInt(1, codigoPaciente);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                ConsultaVO consulta = new ConsultaVO();
                consulta.setCodigoConsulta(result.getInt(1));
                EspecializacaoVO especializacaoVO = especializacaoDAO.consultarEspecializacaoVOPorId(result.getInt(2));
                consulta.setEspecializacaoVO(especializacaoVO);
                PacienteVO pacienteVO = pacienteDAO.consultarPorId(result.getInt(3));
                consulta.setPacienteVO(pacienteVO);
                ConvenioVO convenioVO = convenioDAO.consultarPorId(result.getInt(4));
                consulta.setConvenioVO(convenioVO);
                consulta.setDataConsulta(result.getString(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));
                listaConsultas.add(consulta);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return listaConsultas;
    }

    public boolean excluirConsultaPorId(int codigoConsulta) {
        boolean sucessoDelete = false;

        String query = "DELETE from consulta where codigoConsulta = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {
            prepStmt.setInt(1, codigoConsulta);
            int codigoRetorno = prepStmt.executeUpdate();
            if (codigoRetorno == 1) {
                sucessoDelete = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Exclus�o do Consulta! Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoDelete;
    }

    public boolean atualizarConsulta(ConsultaVO consulta, int codigoConsulta) {
        boolean sucessoAtualizar = false;

        String query = "UPDATE consulta SET codigoEspecializacao=?, codigoPaciente=?, codigoConvenio=?, dataConsulta=?, atencaoEspecial=?, horarioConsulta=?"
                + " where codigoConsulta = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {

            prepStmt.setInt(1, consulta.getEspecializacaoVO().getCodigoEspecializacao());
            prepStmt.setInt(2, consulta.getPacienteVO().getCodigoPaciente());
            prepStmt.setInt(3, consulta.getConvenioVO().getCodigoConvenio());
            prepStmt.setString(4, consulta.getDataConsulta());
            prepStmt.setString(5, consulta.getAtencaoEspecial());
            prepStmt.setString(6, consulta.getHorarioConsulta());
            prepStmt.setInt(7, consulta.getCodigoConsulta());

            int codigoRetorno = prepStmt.executeUpdate();

            if (codigoRetorno == 1) {
                sucessoAtualizar = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar Query de Atualizaçãoo do Consulta!Causa: \n: " + ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }

        return sucessoAtualizar;
    }

    public ArrayList<ConsultaVO> listarTodasAsConsultasVO() {

        ArrayList<ConsultaVO> listaConsultas = new ArrayList<ConsultaVO>();
        String query = "select * from consulta";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                ConsultaVO consulta = new ConsultaVO();

                consulta.setCodigoConsulta(result.getInt(1));
                EspecializacaoVO especializacaoVO = especializacaoDAO.consultarEspecializacaoVOPorId(result.getInt(2));
                consulta.setEspecializacaoVO(especializacaoVO);
                PacienteVO pacienteVO = pacienteDAO.consultarPorId(result.getInt(3));
                consulta.setPacienteVO(pacienteVO);
                ConvenioVO convenioVO = convenioDAO.consultarPorId(result.getInt(4));
                consulta.setConvenioVO(convenioVO);
                consulta.setDataConsulta(result.getString(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));

                listaConsultas.add(consulta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaConsultas;
    }

    public ConsultaVO consultarPorId(int id) {
        ConsultaVO consulta = new ConsultaVO();

        String query = "SELECT * from consulta " + " where codigoConsulta like ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setInt(1, id);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {

                consulta.setCodigoConsulta(result.getInt(1));
                EspecializacaoVO especializacaoVO = especializacaoDAO.consultarEspecializacaoVOPorId(result.getInt(2));
                consulta.setEspecializacaoVO(especializacaoVO);
                PacienteVO pacienteVO = pacienteDAO.consultarPorId(result.getInt(3));
                consulta.setPacienteVO(pacienteVO);
                ConvenioVO convenioVO = convenioDAO.consultarPorId(result.getInt(4));
                consulta.setConvenioVO(convenioVO);
                consulta.setDataConsulta(result.getString(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return consulta;
    }

    public int consultarDataHorario(String dataConsulta, String horarioConsulta) {
        ConsultaVO consulta = new ConsultaVO();

        String query = "SELECT * from consulta " + " where dataConsulta = ? and horarioConsulta = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {

            prepStmt.setString(1, dataConsulta);
            prepStmt.setString(2, horarioConsulta);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {

                consulta.setCodigoConsulta(result.getInt(1));
                EspecializacaoVO especializacaoVO = especializacaoDAO.consultarEspecializacaoVOPorId(result.getInt(2));
                consulta.setEspecializacaoVO(especializacaoVO);
                PacienteVO pacienteVO = pacienteDAO.consultarPorId(result.getInt(3));
                consulta.setPacienteVO(pacienteVO);
                ConvenioVO convenioVO = convenioDAO.consultarPorId(result.getInt(4));
                consulta.setConvenioVO(convenioVO);
                consulta.setDataConsulta(result.getString(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return consulta.getCodigoConsulta();
    }

    public List<ConsultaVO> listarConsultasVOPorConvenio(int codigoConvenio) {

        ArrayList<ConsultaVO> listaConsultas = new ArrayList<ConsultaVO>();
        String query = "SELECT * from consulta " + " where codigoConvenio = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setInt(1, codigoConvenio);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                ConsultaVO consulta = new ConsultaVO();
                consulta.setCodigoConsulta(result.getInt(1));
                EspecializacaoVO especializacaoVO = especializacaoDAO.consultarEspecializacaoVOPorId(result.getInt(2));
                consulta.setEspecializacaoVO(especializacaoVO);
                PacienteVO pacienteVO = pacienteDAO.consultarPorId(result.getInt(3));
                consulta.setPacienteVO(pacienteVO);
                ConvenioVO convenioVO = convenioDAO.consultarPorId(result.getInt(4));
                consulta.setConvenioVO(convenioVO);
                consulta.setDataConsulta(result.getString(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));
                listaConsultas.add(consulta);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        System.out.println("model.dao.Consulta()" + listaConsultas);
        return listaConsultas;
    }

    public List<ConsultaVO> listarConsultasVOPorMedico(int codigoEspecializacao) {
        ArrayList<ConsultaVO> listaConsultas = new ArrayList<ConsultaVO>();
        String query = "SELECT * from consulta " + " where codigoEspecializacao = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setInt(1, codigoEspecializacao);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                ConsultaVO consulta = new ConsultaVO();
                consulta.setCodigoConsulta(result.getInt(1));
                EspecializacaoVO especializacaoVO = especializacaoDAO.consultarEspecializacaoVOPorId(result.getInt(2));
                consulta.setEspecializacaoVO(especializacaoVO);
                PacienteVO pacienteVO = pacienteDAO.consultarPorId(result.getInt(3));
                consulta.setPacienteVO(pacienteVO);
                ConvenioVO convenioVO = convenioDAO.consultarPorId(result.getInt(4));
                consulta.setConvenioVO(convenioVO);
                consulta.setDataConsulta(result.getString(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));
                listaConsultas.add(consulta);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        System.out.println("model.dao.Consulta()" + listaConsultas);
        return listaConsultas;
    }
}


