package controller.usuario;

import model.bo.usuario.UsuarioBO;
import model.vo.usuario.UsuarioVO;

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
