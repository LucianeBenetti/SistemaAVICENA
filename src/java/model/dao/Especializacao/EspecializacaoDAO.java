package model.dao.Especializacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.dao.ConexaoComBanco;
import model.dao.Especialidade.EspecialidadeDAO;
import model.dao.Medico.MedicoDAO;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class EspecializacaoDAO {

    private EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
    private MedicoDAO medicoDAO = new MedicoDAO();

    public int inserirEspecializacao(EspecializacaoVO especializacao) {

        int novoId = 0;

        String sql = "INSERT INTO especializacao (codigoEspecialidade, codigoMedico, anoEspecializacao)"
                + " VALUES (?,?,?)";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

        try {

            prepStmt.setInt(1, especializacao.getEspecialidadeVO().getCodigoEspecialidade());
            prepStmt.setInt(2, especializacao.getMedicoVO().getCodigoMedico());
            prepStmt.setString(3, especializacao.getAnoEspecializacao());

            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar o Cadastro do Especializac�o! Causa: \n: " + e.getMessage());

        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return novoId;

    }

    public boolean delete(int codigoEspecializacao) {
        boolean sucessoDelete = false;

        String query = "DELETE from especializacao where codigoEspecializacao = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {
            prepStmt.setInt(1, codigoEspecializacao);
            int codigoRetorno = prepStmt.executeUpdate();
            if (codigoRetorno == 1) {
                sucessoDelete = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Exclus�o do Especializac�o! Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoDelete;
    }

    public EspecializacaoVO atualizarEspecializacao(EspecializacaoVO especializacao, int codigoEspecializacao) {

        boolean sucessoAtualizar = false;

        String query = "UPDATE especializacao SET codigoEspecialidade=?, codigoMedico=?, anoEspecializacao=? "
                + " where codigoEspecializacao = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {

            prepStmt.setInt(1, especializacao.getEspecialidadeVO().getCodigoEspecialidade());
            prepStmt.setInt(2, especializacao.getMedicoVO().getCodigoMedico());
            prepStmt.setString(3, especializacao.getAnoEspecializacao());
            prepStmt.setInt(4, especializacao.getCodigoEspecializacao());

            int codigoRetorno = prepStmt.executeUpdate();

            if (codigoRetorno == 1) {
                sucessoAtualizar = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar Query de Atualiza��o do Especializac�o!Causa: \n: " + ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return especializacao;
    }

    public ArrayList<EspecializacaoVO> listarEspecializacoesDoMedicoPorEspecialidade(int codigoEspecialidade, int codigoMedico) {
        ArrayList<EspecializacaoVO> listaEspecializacao = new ArrayList<EspecializacaoVO>();

        String query = " SELECT codigoEspecializacao, e.codigoEspecialidade, med.codigoMedico, anoEspecializacao from especializacao esp"
                + " inner join especialidade e on (esp.codigoEspecialidade = e.codigoEspecialidade) "
                + " inner join medico med on (esp.codigoMedico = med.codigoMedico) "
                + " where e.codigoEspecialidade = ? "
                + " and med.codigoMedico = ? "
                + " order by esp.codigoEspecializacao ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setInt(1, codigoEspecialidade);
            prepStmt.setInt(2, codigoMedico);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                EspecializacaoVO especializacao = new EspecializacaoVO();
                especializacao.setCodigoEspecializacao(result.getInt(1));

                EspecialidadeVO especialidadeVO = especialidadeDAO.consultarPorId(result.getInt(2));
                especializacao.setEspecialidadeVO(especialidadeVO);
                MedicoVO medicoVO = medicoDAO.consultarPorId(result.getInt(3));
                especializacao.setMedicoVO(medicoVO);
                especializacao.setAnoEspecializacao(result.getString(4));

                listaEspecializacao.add(especializacao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEspecializacao;
    }

    public ArrayList<EspecializacaoVO> listarTodasEspecializacoes() {
        String query = "SELECT * from especializacao";
        ArrayList<EspecializacaoVO> listaEspecializacao = new ArrayList<EspecializacaoVO>();

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                EspecializacaoVO especializacao = new EspecializacaoVO();
                especializacao.setCodigoEspecializacao(result.getInt(1));

                EspecialidadeVO especialidadeVO = especialidadeDAO.consultarPorId(result.getInt(2));
                especializacao.setEspecialidadeVO(especialidadeVO);
                MedicoVO medicoVO = medicoDAO.consultarPorId(result.getInt(3));
                especializacao.setMedicoVO(medicoVO);
                especializacao.setAnoEspecializacao(result.getString(4));

                listaEspecializacao.add(especializacao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEspecializacao;
    }

    public boolean existeEspecializacao(EspecializacaoVO especializacao) {

        ArrayList<EspecializacaoVO> listaEspecializacao = new ArrayList<EspecializacaoVO>();

        String query = " SELECT count(esp.codigoEspecializacao) from especializacao esp "
                + " inner join especialidade e on (esp.codigoEspecialidade = e.codigoEspecialidade) "
                + " inner join medico med on (esp.codigoMedico = med.codigoMedico) "
                + " where e.codigoEspecialidade = ? "
                + " and med.codigoMedico = ? "
                + " and esp.anoEspecializacao = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        boolean existe = false;
        try {
            prepStmt.setInt(1, especializacao.getEspecialidadeVO().getCodigoEspecialidade());
            prepStmt.setInt(2, especializacao.getMedicoVO().getCodigoMedico());
            prepStmt.setString(3, especializacao.getAnoEspecializacao());
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                existe = (result.getInt(1) > 0);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }

    public ArrayList<EspecializacaoVO> existeEspecializacaoPorNome(String nomeMedico, String nomeEspecialidade) {

        ArrayList<EspecializacaoVO> listaEspecializacao = new ArrayList<EspecializacaoVO>();

        String query = "SELECT esp.codigoEspecializacao, e.codigoEspecialidade, med.codigoMedico, esp.anoEspecializacao from especializacao esp"
                + " inner join especialidade e on (esp.codigoEspecialidade = e.codigoEspecialidade)"
                + " inner join medico med on (esp.codigoMedico = med.codigoMedico)"
                + " where med.codigoMedico = ?"
                + " and e.codigoEspecialidade = ?"
                + " order by esp.codigoEspecialidade";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        ArrayList<EspecializacaoVO> especializacoes = new ArrayList<EspecializacaoVO>();
        try {
            prepStmt.setString(1, '%' + nomeMedico + '%');
            prepStmt.setString(2, '%' + nomeEspecialidade + '%');

            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {

                EspecializacaoVO especializacao = new EspecializacaoVO();
                especializacao.setCodigoEspecializacao(result.getInt(1));
                EspecialidadeVO especialidadeVO = especialidadeDAO.consultarPorId(result.getInt(2));
                especializacao.setEspecialidadeVO(especialidadeVO);
                MedicoVO medicoVO = medicoDAO.consultarPorId(result.getInt(3));
                especializacao.setMedicoVO(medicoVO);
                especializacao.setAnoEspecializacao(result.getString(4));
                especializacoes.add(especializacao);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closeStatement((Connection) prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return especializacoes;
    }

    public EspecializacaoVO consultarPorId(int id) {

        String query = "SELECT * FROM especializacao WHERE codigoEspecializacao = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        EspecializacaoVO especializacao = null;
        try {
            prepStmt.setInt(1, id);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                especializacao = new EspecializacaoVO();

                especializacao.setCodigoEspecializacao(result.getInt(1));
                EspecialidadeVO especialidadeVO = especialidadeDAO.consultarPorId(result.getInt(2));
                especializacao.setEspecialidadeVO(especialidadeVO);
                MedicoVO medicoVO = medicoDAO.consultarPorId(result.getInt(3));
                especializacao.setMedicoVO(medicoVO);
                especializacao.setAnoEspecializacao(result.getString(4));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closeStatement((Connection) prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return especializacao;
    }
}
