package model.vo.Usuario;

public class UsuarioVO {
    
    private int codigoUsuario;
    private String login;
    private String senha;
    private String perfil;

    public UsuarioVO() {
    }

    public UsuarioVO(int codigoUsuario, String login, String senha, String perfil) {
        this.codigoUsuario = codigoUsuario;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "UsuarioVO{" + "codigoUsuario=" + codigoUsuario + ", login=" + login + ", senha=" + senha + ", perfil=" + perfil + '}';
    }
    
}
