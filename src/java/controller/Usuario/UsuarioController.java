package controller.Usuario;

import model.bo.Usuario.UsuarioBO;
import model.vo.Usuario.UsuarioVO;

public class UsuarioController {

    UsuarioBO usuarioBO = new UsuarioBO();

    public int cadastrarUsuarioVO(UsuarioVO usuarioVO) {

        return usuarioBO.cadastrarUsuarioVO(usuarioVO);
    }

    public UsuarioVO pesquisarUsuarioVO(UsuarioVO usuarioVO) {
        UsuarioVO usuario = usuarioBO.pesquisarUsuarioVO(usuarioVO);
        return usuario;
    }

}
