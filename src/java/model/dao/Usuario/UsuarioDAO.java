package model.dao.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.dao.ConexaoComBanco;
import model.vo.Usuario.UsuarioVO;

public class UsuarioDAO {

    UsuarioVO usuarioVO;

    public int inserir(UsuarioVO usuarioVO) {
        int novoId = 0;

        String sql = "INSERT INTO usuario (login, senha) VALUES (?,?)";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, sql, Statement.RETURN_GENERATED_KEYS);

        try {
            prepStmt.setString(1, usuarioVO.getLogin());
            prepStmt.setString(2, usuarioVO.getSenha());

            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                novoId = generatedKeys.getInt(1);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar Query de Cadastro de Produto! Causa: \n: " + e.getMessage());

        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return novoId;

    }

    public UsuarioVO pesquisarUsuarioVO(UsuarioVO usuarioVO) {
        String query = "select * from usuario where login = ? and senha = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        UsuarioVO usuario = null;
        
        try {
            prepStmt.setString(1, usuarioVO.getLogin());
            prepStmt.setString(2, usuarioVO.getSenha());
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                usuario = new UsuarioVO();
                usuario.setCodigoUsuario(result.getInt("codigoUsuario"));
                usuario.setLogin(result.getString("login"));
                usuario.setSenha(result.getString("senha"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao executar a Query de Consulta de funcionarios!Causa: \n: " + e.getMessage());
        } finally {
            ConexaoComBanco.closeStatement(conn);
            ConexaoComBanco.closeConnection(conn);
        }
        return usuario;
    }

//    public UsuarioVO validarUsuarioVO(UsuarioVO usuarioVO) {
//
//        System.out.println("O nome é: " + usuarioVO.getLogin());
//        System.out.println("a senha é: " + usuarioVO.getSenha());
//        String query = "SELECT * FROM usuario" + " where login = ? and senha = ?";
//
//        Connection conn = ConexaoComBanco.getConnection();
//        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
//        UsuarioVO usuario = new UsuarioVO();
//        try {
//
//            prepStmt.setString(1, usuarioVO.getLogin());
//            prepStmt.setString(2, usuarioVO.getSenha());
//            ResultSet result = prepStmt.executeQuery();
//
//            while (result.next()) {
//                
//                
//                usuario.setCodigoUsuario(result.getInt("codigoUsuario"));
//                usuario.setLogin(result.getString("login"));
//                usuario.setSenha(result.getString("senha"));
//                System.out.println("O iD é: " + usuario.getCodigoUsuario());
//                System.out.println("O nome é: " + usuario.getLogin());
//                System.out.println("A senha é: " + usuario.getSenha());
//
//            }
//                        System.out.println("O iD é: " + usuarioVO.getCodigoUsuario());
//                        System.out.println("O nome é: " + usuarioVO.getLogin());
//                        System.out.println("A senha é: " + usuarioVO.getSenha());
//
//        } catch (SQLException e) {
//            System.out.println("Erro ao executar a Query de Consulta de funcionarios!Causa: \n: " + e.getMessage());
//        } finally {
//            ConexaoComBanco.closeStatement(conn);
//            ConexaoComBanco.closeConnection(conn);
//        }
//
//        return usuario;
//    }

}
