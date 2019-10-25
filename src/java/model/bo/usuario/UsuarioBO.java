package model.bo.usuario;

import model.dao.usuario.UsuarioDAO;
import model.vo.usuario.UsuarioVO;

public class UsuarioBO {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    public int cadastrarUsuarioVO(UsuarioVO usuarioVO) {
        UsuarioVO usuario = usuarioDAO.pesquisarUsuarioVO(usuarioVO);
        int novoId = 0;

        if (usuario == null) {
            return novoId = usuarioDAO.inserir(usuarioVO);

        } else {
            return novoId;
        }

    }

    public UsuarioVO pesquisarUsuarioVO(UsuarioVO usuarioVO) {

        UsuarioVO usuario = usuarioDAO.pesquisarUsuarioVO(usuarioVO);
        try {
            if (usuario.getCodigoUsuario() != 0) {
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return usuario;
    }
}
