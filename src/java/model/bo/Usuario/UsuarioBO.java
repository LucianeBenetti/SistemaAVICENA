
package model.bo.Usuario;

import model.dao.Usuario.UsuarioDAO;
import model.vo.Usuario.UsuarioVO;


public class UsuarioBO {
    
     UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public int cadastrarUsuarioVO(UsuarioVO usuarioVO) {
        UsuarioVO usuario = usuarioDAO.pesquisarUsuarioVO(usuarioVO);
        int novoId = 0;
        
        if(usuario == null){            
           return novoId = usuarioDAO.inserir(usuarioVO);
            
        } else{return novoId; }         
    
        }        

    public UsuarioVO pesquisarUsuarioVO(UsuarioVO usuarioVO) {
        
        UsuarioVO usuario = usuarioDAO.pesquisarUsuarioVO(usuarioVO);
        if(usuario == null){
            return null;
            } else {return usuario;}
     }

       
}
