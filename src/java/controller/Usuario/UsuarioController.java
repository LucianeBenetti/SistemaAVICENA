
package controller.Usuario;

import model.bo.Usuario.UsuarioBO;
import model.vo.Usuario.UsuarioVO;


public class UsuarioController {

    UsuarioBO usuarioBO = new UsuarioBO();

    public int cadastrarUsuarioVO(UsuarioVO usuarioVO) {
        
        return usuarioBO.cadastrarUsuarioVO(usuarioVO);
    }

    public UsuarioVO pesquisarUsuarioVO(UsuarioVO usuarioVO) {
        
//        System.out.println("O nome é: " + usuarioVO.getLogin());
//        System.out.println("a senha é: " + usuarioVO.getSenha());
    
            UsuarioVO usuario = usuarioBO.pesquisarUsuarioVO(usuarioVO);
        return usuario;
    }

}
