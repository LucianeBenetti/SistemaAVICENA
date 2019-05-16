package Servlets.Usuario;

import controller.Paciente.PacienteController;
import controller.Usuario.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Usuario.UsuarioVO;
import sun.misc.BASE64Encoder;

public class Usuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("cadastrar");
        String var2 = request.getParameter("validar");
        String nome = request.getParameter("nome");
        String senha = MD5(request.getParameter("senha"));
        UsuarioController usuarioController;
        UsuarioVO usuarioVO;

//        System.out.println("O nome é: " + nome);
//        System.out.println("a senha é: " + senha);
        ArrayList<String> variaveis = new ArrayList<>();
        variaveis.add(var1);
        variaveis.add(var2);
        //System.out.println("O array é: " + variaveis);       

        for (int i = 0; i < variaveis.size(); i++) {
            String variavelDeControle = variaveis.get(i);

            if (variavelDeControle != null) {
                switch (variavelDeControle) {
                    case "cadastrar":
                        //System.out.println("A variável é: " + variaveis.get(i));
                        usuarioVO = new UsuarioVO();
                        usuarioVO.setLogin(nome);
                        usuarioVO.setSenha(senha);

                        System.out.println(usuarioVO);
                        usuarioController = new UsuarioController();

                        int novoId = usuarioController.cadastrarUsuarioVO(usuarioVO);
                        System.out.println("O novo Id é: " + novoId);

                        if (novoId > 0) {

                            request.setAttribute("codigodousuario", usuarioVO.getCodigoUsuario());
                            request.setAttribute("nome", usuarioVO.getLogin());
                            request.setAttribute("senha", usuarioVO.getSenha());
                            request.getRequestDispatcher("Index.jsp").forward(request, response);
                        } else {
                            Boolean usuariocadastrado = false;
                            request.setAttribute("usuariocadastrado", usuariocadastrado);
                            request.getRequestDispatcher("CadastrarUsuario.jsp").forward(request, response);
                        }
                        break;

                    case "validar":

                        usuarioVO = new UsuarioVO();
                        usuarioVO.setLogin(nome);
                        usuarioVO.setSenha(senha);

                        usuarioController = new UsuarioController();
                        //System.out.println("A variável é: " + variaveis.get(i));
                        UsuarioVO usuarioValidado = usuarioController.pesquisarUsuarioVO(usuarioVO);
                        if (usuarioValidado != null) {
                            request.setAttribute("login", usuarioVO.getLogin());
                            request.setAttribute("senha", usuarioVO.getSenha());
                            request.getRequestDispatcher("WEB-INF/PaginaInicial.jsp").forward(request, response);
                        } else {
                            Boolean validacao = false;
                            request.setAttribute("usuariovalidado", validacao);
                            request.getRequestDispatcher("Index.jsp").forward(request, response);
                        }

                        break;

                    default:
                        request.getRequestDispatcher("Index.jsp").forward(request, response);
                        break;

                }
            }
        }
    }

    private String MD5(String senha) {

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(senha.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(digest.digest());
        } catch (NoSuchAlgorithmException ns) {
            ns.printStackTrace();
        }
        return senha;

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
