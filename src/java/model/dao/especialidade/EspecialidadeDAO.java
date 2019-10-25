package model.dao.especialidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.dao.ConexaoComBanco;
import model.vo.especialidade.EspecialidadeVO;

public class EspecialidadeDAO {

    private static ArrayList<EspecialidadeVO> listaEspecialiades = new ArrayList<EspecialidadeVO>();
    EspecialidadeVO especialidade = new EspecialidadeVO();

    public int inserirEspecialidadeVO(EspecialidadeVO especialidade) {
        int novoId = -1;

        String query = "INSERT INTO especialidade (nomeEspecialidade, instituicao)" + " VALUES (?, ?)";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query, Statement.RETURN_GENERATED_KEYS);

        try {
            prepStmt.setString(1, especialidade.getNomeEspecialidade());
            prepStmt.setString(2, especialidade.getInstituicao());

            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Cadastro de Especialidade! Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return novoId;
    }

    public boolean excluirEspecialidadeVO(int codigoEspecialidade) {
        boolean sucessoDelete = false;

        String query = "DELETE from especialidade where codigoEspecialidade = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {
            prepStmt.setInt(1, codigoEspecialidade);
            int codigoRetorno = prepStmt.executeUpdate();
            if (codigoRetorno == 1) {
                sucessoDelete = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Exclusão do Especialidade! Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoDelete;
    }

    public EspecialidadeVO pesquisarEspecialidadesVO(EspecialidadeVO especialidadePorNome) {

        String query = "SELECT *from especialidade " + " where nomeEspecialidade like ? and instituicao like ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        EspecialidadeVO especialidade = null;
        try {

            prepStmt.setString(1, '%' + especialidadePorNome.getNomeEspecialidade() + '%');
            prepStmt.setString(2, '%' + especialidadePorNome.getInstituicao() + '%');

            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {

                especialidade = new EspecialidadeVO();
                especialidade.setCodigoEspecialidade(result.getInt(1));
                especialidade.setNomeEspecialidade(result.getString(2));
                especialidade.setInstituicao(result.getString(3));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return especialidade;
    }

    public ArrayList<EspecialidadeVO> listarTodasEspecialidades() {

        ArrayList<EspecialidadeVO> listaEspecialidades = new ArrayList<EspecialidadeVO>();

        String query = "select * from especialidade";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                EspecialidadeVO especialidade = new EspecialidadeVO();
                especialidade.setCodigoEspecialidade(result.getInt(1));
                especialidade.setNomeEspecialidade(result.getString(2));
                especialidade.setInstituicao(result.getString(3));

                listaEspecialidades.add(especialidade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEspecialidades;
    }

    public boolean atualizarEspecialidadeVO(EspecialidadeVO especialidade) {

        boolean sucessoAtualizar = false;
        String query = "UPDATE especialidade SET nomeEspecialidade=?, instituicao=? "
                + " where codigoEspecialidade = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {
            prepStmt.setString(1, especialidade.getNomeEspecialidade());
            prepStmt.setString(2, especialidade.getInstituicao());
            prepStmt.setInt(3, especialidade.getCodigoEspecialidade());

            int codigoRetorno = prepStmt.executeUpdate();

            if (codigoRetorno == 1) {
                sucessoAtualizar = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar Query de Atualiza��o do Especialidade! Causa: \n: " + ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoAtualizar;
    }

    public EspecialidadeVO pesquisarEspecialidadeVOPorId(int id) {
        String query = "SELECT * FROM especialidade WHERE codigoEspecialidade = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        EspecialidadeVO especialidade = null;
        try {
            prepStmt.setInt(1, id);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                especialidade = new EspecialidadeVO();
                especialidade.setCodigoEspecialidade(result.getInt(1));
                especialidade.setNomeEspecialidade(result.getString(2));
                especialidade.setInstituicao(result.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return especialidade;
    }

    public ArrayList<EspecialidadeVO> pesquisarEspecialidadeNome(String nomeEspecialidade) {

        String query = "SELECT *from especialidade " + " where nomeEspecialidade like ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        EspecialidadeVO especialidade = null;
        ArrayList<EspecialidadeVO> especialidades = new ArrayList<EspecialidadeVO>();
        try {
            prepStmt.setString(1, '%' + nomeEspecialidade + '%');

            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {

                especialidade = new EspecialidadeVO();
                especialidade.setCodigoEspecialidade(result.getInt(1));
                especialidade.setNomeEspecialidade(result.getString(2));
                especialidade.setInstituicao(result.getString(3));

                especialidades.add(especialidade);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return especialidades;
    }

    public ArrayList<EspecialidadeVO> pesquisarEspecialidadePorId(int codigoEspecialidade) {

        String query = "SELECT *from especialidade " + " where codigoEspecialidade = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        EspecialidadeVO especialidade = null;
        ArrayList<EspecialidadeVO> especialidades = new ArrayList<EspecialidadeVO>();
        try {
            prepStmt.setInt(1, codigoEspecialidade);

            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {

                especialidade = new EspecialidadeVO();
                especialidade.setCodigoEspecialidade(result.getInt(1));
                especialidade.setNomeEspecialidade(result.getString(2));
                especialidade.setInstituicao(result.getString(3));

                especialidades.add(especialidade);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return especialidades;
    }
}
