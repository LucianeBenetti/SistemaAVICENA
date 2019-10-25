package model.dao.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.dao.ConexaoComBanco;
import model.vo.usuario.UsuarioVO;

public class UsuarioDAO {

    UsuarioVO usuarioVO;

    public int inserir(UsuarioVO usuarioVO) {
        int novoId = 0;

        String sql = "INSERT INTO usuario (login, senha, perfil) VALUES (?,?,?)";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

        try {
            prepStmt.setString(1, usuarioVO.getLogin());
            prepStmt.setString(2, usuarioVO.getSenha());
            prepStmt.setString(3, usuarioVO.getPerfil());

            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Cadastro de Usuário! Causa: \n: " + e.getMessage());

        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return novoId;

    }

    public UsuarioVO pesquisarUsuarioVO(UsuarioVO usuarioVO) {
        String query = "select * from usuario where login = ? and senha = ? and perfil = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        UsuarioVO usuario = null;

        try {
            prepStmt.setString(1, usuarioVO.getLogin());
            prepStmt.setString(2, usuarioVO.getSenha());
            prepStmt.setString(3, usuarioVO.getPerfil());
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                usuario = new UsuarioVO();
                usuario.setCodigoUsuario(result.getInt("codigoUsuario"));
                usuario.setLogin(result.getString("login"));
                usuario.setSenha(result.getString("senha"));
                usuario.setPerfil(result.getString("perfil"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a Query de Consulta de Usuário!Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closeStatement(conn);
            ConexaoComBanco.closeConnection(conn);
        }
        return usuario;
    }
}
