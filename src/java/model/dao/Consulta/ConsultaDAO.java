package model.dao.Consulta;

import Servlets.Consulta.CadastrarConsulta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ConexaoComBanco;
import model.dao.Convenio.ConvenioDAO;
import model.dao.Especializacao.EspecializacaoDAO;
import model.dao.Paciente.PacienteDAO;
import model.vo.Consulta.ConsultaVO;
import model.vo.Convenio.ConvenioVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Paciente.PacienteVO;
import model.vo.Prontuario.ReceitaVO;

public class ConsultaDAO {

    private EspecializacaoDAO especializacaoDAO = new EspecializacaoDAO();
    private ConvenioDAO convenioDAO = new ConvenioDAO();
    private PacienteDAO pacienteDAO = new PacienteDAO();

    public int cadastrarConsulta(ConsultaVO consultaVO) {
        Date data = (Date) consultaVO.getDataConsulta();
        consultaVO.setDataConsulta(data);
        Calendar c = Calendar.getInstance();
        c.setTime(consultaVO.getDataConsulta());
        Date dataSQL = new Date(c.getTimeInMillis());

        int novoId = 0;

        String sql = "INSERT INTO consulta (codigoEspecializacao, codigoPaciente, codigoConvenio, dataConsulta, atencaoEspecial, horarioConsulta, valorConsulta)"
                + " VALUES (?,?,?,?,?,?,?)";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

        try {

            prepStmt.setInt(1, consultaVO.getEspecializacaoVO().getCodigoEspecializacao());
            prepStmt.setInt(2, consultaVO.getPacienteVO().getCodigoPaciente());
            prepStmt.setInt(3, consultaVO.getConvenioVO().getCodigoConvenio());
            prepStmt.setDate(4, dataSQL);
            prepStmt.setString(5, consultaVO.getAtencaoEspecial());
            prepStmt.setString(6, consultaVO.getHorarioConsulta());
            prepStmt.setString(7, consultaVO.getValorConsulta());
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
                consulta.setDataConsulta(result.getDate(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));
                consulta.setValorConsulta(result.getString(8));
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

    public boolean atualizarConsulta(ConsultaVO consultaVO, int codigoConsulta) {
        boolean sucessoAtualizar = false;

        Date data = (Date) consultaVO.getDataConsulta();
        consultaVO.setDataConsulta(data);
        Calendar c = Calendar.getInstance();
        c.setTime(consultaVO.getDataConsulta());
        Date dataSQL = new Date(c.getTimeInMillis());
        String query = "UPDATE consulta SET codigoEspecializacao=?, codigoPaciente=?, codigoConvenio=?, dataConsulta=?, atencaoEspecial=?, horarioConsulta=?, valorConsulta=?"
                + " where codigoConsulta = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {

            prepStmt.setInt(1, consultaVO.getEspecializacaoVO().getCodigoEspecializacao());
            prepStmt.setInt(2, consultaVO.getPacienteVO().getCodigoPaciente());
            prepStmt.setInt(3, consultaVO.getConvenioVO().getCodigoConvenio());
            prepStmt.setDate(4, dataSQL);
            prepStmt.setString(5, consultaVO.getAtencaoEspecial());
            prepStmt.setString(6, consultaVO.getHorarioConsulta());
            prepStmt.setString(7, consultaVO.getValorConsulta());
            prepStmt.setInt(8, consultaVO.getCodigoConsulta());

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
                consulta.setDataConsulta(result.getDate(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));
                consulta.setValorConsulta(result.getString(8));

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
                consulta.setDataConsulta(result.getDate(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));
                consulta.setValorConsulta(result.getString(8));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return consulta;
    }

    public int consultarDataHorario(Date dataConsulta, String horarioConsulta) {
        ConsultaVO consultaVO = new ConsultaVO();

        consultaVO.setDataConsulta(dataConsulta);
        Calendar c = Calendar.getInstance();
        c.setTime(consultaVO.getDataConsulta());
        Date dataSQL = new Date(c.getTimeInMillis());

        String query = "SELECT * from consulta " + " where dataConsulta = ? and horarioConsulta = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {

            prepStmt.setDate(1, dataConsulta);
            prepStmt.setString(2, horarioConsulta);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {

                consultaVO.setCodigoConsulta(result.getInt(1));
                EspecializacaoVO especializacaoVO = especializacaoDAO.consultarEspecializacaoVOPorId(result.getInt(2));
                consultaVO.setEspecializacaoVO(especializacaoVO);
                PacienteVO pacienteVO = pacienteDAO.consultarPorId(result.getInt(3));
                consultaVO.setPacienteVO(pacienteVO);
                ConvenioVO convenioVO = convenioDAO.consultarPorId(result.getInt(4));
                consultaVO.setConvenioVO(convenioVO);
                consultaVO.setDataConsulta(result.getDate(5));
                consultaVO.setAtencaoEspecial(result.getString(6));
                consultaVO.setHorarioConsulta(result.getString(7));
                consultaVO.setValorConsulta(result.getString(8));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return consultaVO.getCodigoConsulta();
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
                consulta.setDataConsulta(result.getDate(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));
                consulta.setValorConsulta(result.getString(8));
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
                consulta.setDataConsulta(result.getDate(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));
                consulta.setValorConsulta(result.getString(8));
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

    public List<ConsultaVO> listarConsultasVOPorData(Date dataInicial, Date dataFinal) {

        ArrayList<ConsultaVO> listaConsultas = new ArrayList<ConsultaVO>();
        String query = "SELECT * from consulta where dataConsulta between ? and ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setDate(1, dataInicial);
            prepStmt.setDate(2, dataFinal);
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
                consulta.setDataConsulta(result.getDate(5));
                consulta.setAtencaoEspecial(result.getString(6));
                consulta.setHorarioConsulta(result.getString(7));
                consulta.setValorConsulta(result.getString(8));
                listaConsultas.add(consulta);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        System.out.println("listadatas " + listaConsultas.size());
        return listaConsultas;
    }

}
