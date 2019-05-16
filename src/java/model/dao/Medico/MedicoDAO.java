package model.dao.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.dao.ConexaoComBanco;
import model.vo.Medico.MedicoVO;

public class MedicoDAO {

    private static ArrayList<MedicoVO> listaMedicos = new ArrayList<MedicoVO>();
    MedicoVO med = new MedicoVO();

    public int inserir(MedicoVO medicoVO) {
        int novoId = -1;

        String query = "INSERT INTO medico (nomeMedico, crm, celMensagemMedico, celularMedico, emailMedico, cpfMedico, cnpjMedico)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

        try {
            prepStmt.setString(1, medicoVO.getNomeMedico());
            prepStmt.setString(2, medicoVO.getCrm());
            prepStmt.setString(3, medicoVO.getCelMensagemMedico());
            prepStmt.setString(4, medicoVO.getCelularMedico());
            prepStmt.setString(5, medicoVO.getEmailMedico());
            prepStmt.setString(6, medicoVO.getCpfMedico());
            prepStmt.setString(7, medicoVO.getCnpjMedico());

            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Cadastro de M�dico! Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return novoId;
    }

    public boolean excluir(String cpfMedico) {
        boolean sucessoDelete = false;

        String query = "DELETE from medico where cpfMedico = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {
            prepStmt.setString(1, cpfMedico);
            int codigoRetorno = prepStmt.executeUpdate();
            if (codigoRetorno == 1) {
                sucessoDelete = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Exclus�o do M�dico! Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoDelete;
    }

    public MedicoVO pesquisarMedicoVOPorCpf(String cpfMedico) {

        String query = "SELECT *from medico " + " where cpfMedico = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        MedicoVO medico = null;
        ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();

        try {
            prepStmt.setString(1, cpfMedico);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                medico = new MedicoVO();

                medico.setCodigoMedico(result.getInt(1));
                medico.setNomeMedico(result.getString(2));
                medico.setCrm(result.getString(3));
                medico.setCelMensagemMedico(result.getString(4));
                medico.setCelularMedico(result.getString(5));
                medico.setEmailMedico(result.getString(6));
                medico.setCpfMedico(result.getString(7));
                medico.setCnpjMedico(result.getString(8));

                medicos.add(medico);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closeStatement((Connection) prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return medico;
    }

    public boolean atualizarMedicoVO(MedicoVO medicoVO) {
        boolean sucessoAtualizar = false;

        String query = "UPDATE medico SET nomeMedico=?, crm=?, celularMedico=?, celMensagemMedico=?, emailMedico=?, cpfMedico=?, cnpjMedico=?"
                + " where cpfMedico = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {
            prepStmt.setString(1, medicoVO.getNomeMedico());
            prepStmt.setString(2, medicoVO.getCrm());
            prepStmt.setString(3, medicoVO.getCelMensagemMedico());
            prepStmt.setString(4, medicoVO.getCelularMedico());
            prepStmt.setString(5, medicoVO.getEmailMedico());
            prepStmt.setString(6, medicoVO.getCpfMedico());
            prepStmt.setString(7, medicoVO.getCnpjMedico());
            prepStmt.setString(8, medicoVO.getCpfMedico());

            int codigoRetorno = prepStmt.executeUpdate();

            if (codigoRetorno == 1) {
                sucessoAtualizar = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar Query de Atualiza��o do M�dico!Causa: \n: " + ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoAtualizar;
    }

    public ArrayList<MedicoVO> listarTodosOsMedicos() {

        ArrayList<MedicoVO> listaMedicos = new ArrayList<MedicoVO>();
        String query = "select * from medico";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                MedicoVO medico = new MedicoVO();

                medico.setCodigoMedico(result.getInt(1));
                medico.setNomeMedico(result.getString(2));
                medico.setCrm(result.getString(3));
                medico.setCelMensagemMedico(result.getString(4));
                medico.setCelularMedico(result.getString(5));
                medico.setEmailMedico(result.getString(6));
                medico.setCpfMedico(result.getString(7));
                medico.setCnpjMedico(result.getString(8));

                listaMedicos.add(medico);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaMedicos;
    }

    public ArrayList<MedicoVO> exibirMedicoPorNome(String nomeMedico) {

        String query = "SELECT *from medico " + " where nomeMedico = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        MedicoVO medico = null;
        ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();

        try {
            prepStmt.setString(1, '%' + nomeMedico + '%');
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                medico = new MedicoVO();

                medico.setCodigoMedico(result.getInt(1));
                medico.setNomeMedico(result.getString(2));
                medico.setCrm(result.getString(3));
                medico.setCelMensagemMedico(result.getString(4));
                medico.setCelularMedico(result.getString(5));
                medico.setEmailMedico(result.getString(6));
                medico.setCpfMedico(result.getString(7));
                medico.setCnpjMedico(result.getString(8));

                medicos.add(medico);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closeStatement((Connection) prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return medicos;
    }

    public MedicoVO consultarPorId(int id) {
        String query = "SELECT *from medico " + " where codigoMedico = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        MedicoVO medico = null;
        ArrayList<MedicoVO> medicos = new ArrayList<MedicoVO>();

        try {
            prepStmt.setInt(1, id);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                medico = new MedicoVO();

                medico.setCodigoMedico(result.getInt(1));
                medico.setNomeMedico(result.getString(2));
                medico.setCrm(result.getString(3));
                medico.setCelMensagemMedico(result.getString(4));
                medico.setCelularMedico(result.getString(5));
                medico.setEmailMedico(result.getString(6));
                medico.setCpfMedico(result.getString(7));
                medico.setCnpjMedico(result.getString(8));

                medicos.add(medico);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closeStatement((Connection) prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return medico;
    }
}
