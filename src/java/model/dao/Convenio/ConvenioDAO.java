package model.dao.Convenio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.dao.ConexaoComBanco;
import model.vo.Convenio.ConvenioVO;

public class ConvenioDAO {

    public int inserirConvenio(ConvenioVO convenio) {

        int novoId = 0;

        String sql = "INSERT INTO convenio (nomeConvenio, cnpjConvenio, valorConvenio)" + " VALUES (?,?,?)";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

        try {

            prepStmt.setString(1, convenio.getNomeConvenio());
            prepStmt.setString(2, convenio.getCnpjConvenio());
            prepStmt.setDouble(3, convenio.getValor());

            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar o Cadastro do Convenio! Causa: \n: " + e.getMessage());

        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return novoId;

    }

    public ConvenioVO consultarConvenioPorCnpj(String cnpjConvenio) {

        ConvenioVO convenio = null;

        String query = "SELECT *from convenio " + " where cnpjConvenio = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setString(1, cnpjConvenio);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                convenio = new ConvenioVO();
                convenio.setCodigoConvenio(result.getInt(1));
                convenio.setNomeConvenio(result.getString(2));
                convenio.setCnpjConvenio(result.getString(3));
                convenio.setValor(result.getDouble(4));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closeStatement((Connection) prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return convenio;
    }

    public boolean delete(String cnpjConvenio) {
        boolean sucessoDelete = false;

        String query = "DELETE from convenio where cnpjConvenio = ? ";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {
            prepStmt.setString(1, cnpjConvenio);
            int codigoRetorno = prepStmt.executeUpdate();
            if (codigoRetorno == 1) {
                sucessoDelete = true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Exclus�o do Convenio! Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoDelete;
    }

    public boolean atualizar(ConvenioVO convenio, String cnpjConvenio) {
        boolean sucessoAtualizar = false;

        String query = "UPDATE convenio SET nomeConvenio=?, cnpjConvenio=?, valorConvenio=? " + " where cnpjConvenio = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);

        try {

            prepStmt.setString(1, convenio.getNomeConvenio());
            prepStmt.setString(2, convenio.getCnpjConvenio());
            prepStmt.setDouble(3, convenio.getValor());
            prepStmt.setString(4, convenio.getCnpjConvenio());

            int codigoRetorno = prepStmt.executeUpdate();

            if (codigoRetorno == 1) {
                sucessoAtualizar = true;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao executar Query de Atualiza��o do Convenio!Causa: \n: " + ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return sucessoAtualizar;
    }

    public ArrayList<ConvenioVO> listarTodos() {

        ArrayList<ConvenioVO> listaConvenios = new ArrayList<ConvenioVO>();

        String query = "select * from convenio";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                ConvenioVO convenio = new ConvenioVO();

                convenio.setCodigoConvenio(result.getInt(1));
                convenio.setNomeConvenio(result.getString(2));
                convenio.setCnpjConvenio(result.getString(3));
                convenio.setValor(result.getDouble(4));

                listaConvenios.add(convenio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaConvenios;
    }

    public ConvenioVO consultarPorId(int id) {
        ConvenioVO convenio = null;

        String query = "SELECT *from convenio " + " where codigoConvenio = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setInt(1, id);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                convenio = new ConvenioVO();
                convenio.setCodigoConvenio(result.getInt(1));
                convenio.setNomeConvenio(result.getString(2));
                convenio.setCnpjConvenio(result.getString(3));
                convenio.setValor(result.getDouble(4));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closeStatement((Connection) prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return convenio;
    }

}
