package model.vo.Usuario;

public class UsuarioVO {
    
    private int codigoUsuario;
    private String login;
    private String senha;

    public UsuarioVO() {
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UsuarioVO{" + "codigoUsuario:" + codigoUsuario + ", login:" + login + ", senha:" + senha + '}';
    }

    
    
}
