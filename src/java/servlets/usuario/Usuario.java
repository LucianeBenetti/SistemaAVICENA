package servlets.usuario;

import controller.usuario.UsuarioController;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.medico.MedicoDAO;
import model.vo.medico.MedicoVO;
import model.vo.usuario.UsuarioVO;
import sun.misc.BASE64Encoder;

public class Usuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("cadastrar");
        String var2 = request.getParameter("validar");
        String var3 = request.getParameter("admin");
        String var4 = request.getParameter("atendente");
        String var5 = request.getParameter("medico");
        String nome = request.getParameter("nome");
        String senha = MD5(request.getParameter("senha"));
        String perfil = request.getParameter("perfil");
        UsuarioController usuarioController;
        UsuarioVO usuarioVO;
        UsuarioVO usuarioValidadoVO;

        HttpSession session;

        ArrayList<String> variaveis = new ArrayList<>();

        variaveis.add(var1);
        variaveis.add(var2);

        for (int i = 0; i < variaveis.size(); i++) {
            String variavelDeControle = variaveis.get(i);

            if (variavelDeControle != null) {
                switch (variavelDeControle) {
                    case "cadastrar":
                        usuarioVO = new UsuarioVO();
                        usuarioVO.setLogin(nome);
                        usuarioVO.setSenha(senha);
                        usuarioVO.setPerfil(perfil);

                        usuarioController = new UsuarioController();

                        int novoId = usuarioController.cadastrarUsuarioVO(usuarioVO);

                        if (novoId > 0) {

                            request.setAttribute("codigodousuario", usuarioVO.getCodigoUsuario());
                            request.setAttribute("nome", usuarioVO.getLogin());
                            request.setAttribute("senha", usuarioVO.getSenha());
                            Boolean usuariocadastrado = true;
                            request.setAttribute("resultadotransacao", usuariocadastrado);
                            request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
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

                        usuarioVO.setPerfil(var3);
                        usuarioValidadoVO = usuarioController.pesquisarUsuarioVO(usuarioVO);

                        if (usuarioValidadoVO != null && usuarioValidadoVO.getPerfil().equals(var3)) {

                            session = request.getSession();
                            session.setAttribute("perfil", usuarioVO.getPerfil());

                            request.setAttribute("login", usuarioVO.getLogin());
                            request.setAttribute("senha", usuarioVO.getSenha());
                            request.setAttribute("perfil", usuarioVO.getPerfil());
                            request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
                        }

                        usuarioVO.setPerfil(var5);
                        usuarioValidadoVO = usuarioController.pesquisarUsuarioVO(usuarioVO);
                        if (usuarioValidadoVO != null && usuarioValidadoVO.getPerfil().equals(var5)) {

                            MedicoDAO medicoDao = new MedicoDAO();
                            List<MedicoVO> medicos = medicoDao.listarTodosOsMedicos();
                            for (int k = 0; k < medicos.size(); k++) {
                                if (usuarioVO.getLogin().equals(medicos.get(k).getEmailMedico())) {
                                    request.setAttribute("codigomedico", medicos.get(k).getCodigoMedico());
                                }
                            }
                            session = request.getSession();
                            session.setAttribute("perfil", usuarioVO.getPerfil());

                            request.setAttribute("login", usuarioVO.getLogin());
                            request.setAttribute("senha", usuarioVO.getSenha());
                            request.setAttribute("perfil", usuarioVO.getPerfil());
                            request.getRequestDispatcher("WEB-INF/PaginaInicialMedico.jsp").forward(request, response);

                        }

                        usuarioVO.setPerfil(var4);
                        usuarioValidadoVO = usuarioController.pesquisarUsuarioVO(usuarioVO);
                        if (usuarioValidadoVO != null && usuarioValidadoVO.getPerfil().equals(var4)) {

                            session = request.getSession();
                            session.setAttribute("perfil", usuarioVO.getPerfil());

                            request.setAttribute("login", usuarioVO.getLogin());
                            request.setAttribute("senha", usuarioVO.getSenha());
                            request.setAttribute("perfil", usuarioVO.getPerfil());
                            request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
                        } else {

                            Boolean usuariovalidado = false;
                            request.setAttribute("usuariovalidado", usuariovalidado);
                            request.getRequestDispatcher("TelaDeLoginAdmin.jsp").forward(request, response);
                        }

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
