package Servlets.Convenio;

import controller.Convenio.ConvenioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Convenio.ConvenioVO;

public class CrudConvenio extends HttpServlet {

    ConvenioVO convenioVO;
    ConvenioController convenioController;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Object usuarioValidado = request.getSession().getAttribute("perfil");

        String var1 = request.getParameter("cadastrar");
        String var2 = request.getParameter("excluir");

        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);
        System.out.println("O array é: " + variavel);

        ConvenioVO convenioVO = null;

        for (int i = 0; i < variavel.size(); i++) {
            String var = variavel.get(i);

            if (var != null) {
                switch (var) {
                    case "cadastrar":

                        System.out.println("A variável é: " + variavel.get(i));
                        convenioVO = new ConvenioVO();
                        convenioVO.setNomeConvenio(request.getParameter("nomeconvenio"));
                        convenioVO.setCnpjConvenio(request.getParameter("cnpjconvenio"));
                        convenioVO.setValor(request.getParameter("valor"));

                        System.out.println(convenioVO);

                        convenioController = new ConvenioController();

                        int novoId = convenioController.cadastrarConvenioVO(convenioVO);
                        Boolean resultadoDoCadastro = false;

                        if (novoId > 0) {

                            request.setAttribute("idconvenio", novoId);
                            request.setAttribute("nomeconvenio", convenioVO.getNomeConvenio());
                            request.setAttribute("cnpjconvenio", convenioVO.getCnpjConvenio());
                            request.setAttribute("valor", convenioVO.getValor());

                            resultadoDoCadastro = true;

                            request.setAttribute("resultadotransacao", resultadoDoCadastro);
                            if (usuarioValidado.equals("admin")) {
                                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
                            } else if (usuarioValidado.equals("atendente")) {
                                request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
                            }
                        } else {
                            request.setAttribute("resultadotransacao", resultadoDoCadastro);
                            if (usuarioValidado.equals("admin")) {
                                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
                            } else if (usuarioValidado.equals("atendente")) {
                                request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
                            }
                        }

                        break;

                    case "excluir":

                        convenioVO = new ConvenioVO();
                        convenioVO.setCnpjConvenio(request.getParameter("cnpjconvenio"));
                        Boolean resultadoDaExclusao = false;
                        convenioController = new ConvenioController();
                        if (convenioController.excluirConvenioPorCnpj(convenioVO.getCnpjConvenio())) {

                            resultadoDaExclusao = true;
                            request.setAttribute("resultadotransacao", resultadoDaExclusao);
                            request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
                        } else {
                            request.setAttribute("resultadotransacao", resultadoDaExclusao);
                            request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
                        }

                        break;

                    default:
                        request.getRequestDispatcher("crud").forward(request, response);
                        break;

                }
            }
        }
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
