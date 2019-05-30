package Servlets.Especialidade;

import controller.Especialidade.EspecialidadeController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Especialidade.EspecialidadeVO;

public class CrudEspecialidade extends HttpServlet {

    EspecialidadeVO especialidadeVO;
    EspecialidadeController especialidadeController;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("cadastrar");
        String var2 = request.getParameter("excluir");

        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);
        System.out.println("O array é: " + variavel);

        EspecialidadeVO especialidadeVO = null;

        for (int i = 0; i < variavel.size(); i++) {
            String var = variavel.get(i);

            if (var != null) {
                switch (var) {
                    case "cadastrar":

                        System.out.println("A variável é: " + variavel.get(i));
                        especialidadeVO = new EspecialidadeVO();
                        especialidadeVO.setNomeEspecialidade(request.getParameter("nomeespecialidade"));
                        especialidadeVO.setInstituicao(request.getParameter("instituicaoespecialidade"));

                        especialidadeController = new EspecialidadeController();

                        int novoId = especialidadeController.cadastrarEspecialidadeVO(especialidadeVO);
                        Boolean resultadoDoCadastro = false;

                        if ((novoId > 0) && (especialidadeVO.getNomeEspecialidade() != null) && (especialidadeVO.getInstituicao() != null)) {

                            request.setAttribute("idespecialidade", novoId);
                            request.setAttribute("nomeespecialidade", especialidadeVO.getNomeEspecialidade());
                            request.setAttribute("instituicaoespecialidade", especialidadeVO.getInstituicao());

                            resultadoDoCadastro = true;

                            request.setAttribute("especialidadecadastrada", resultadoDoCadastro);
                            request.getRequestDispatcher("Especialidade/MostrarEspecialidadeCadastrada.jsp").forward(request, response);

                        } else {
                            request.setAttribute("especialidadecadastrada", resultadoDoCadastro);
                            request.getRequestDispatcher("Especialidade/MostrarEspecialidadeCadastrada.jsp").forward(request, response);
                        }

                        break;

                    case "excluir":

                        especialidadeVO = new EspecialidadeVO();
                        especialidadeVO.setCodigoEspecialidade(Integer.parseInt(request.getParameter("codigoespecialidade")));
                        Boolean resultadoDaExclusao = false;
                        especialidadeController = new EspecialidadeController();
                        if (especialidadeController.excluirEspecialidadePorId(especialidadeVO.getCodigoEspecialidade())) {
                                                  
                            request.setAttribute("codigoespecialidade", especialidadeVO.getCodigoEspecialidade());
                            request.getRequestDispatcher("Especialidade/MostrarEspecialidadeExcluida.jsp").forward(request, response);
                        } else {
                            request.setAttribute("nomeespecialidade", resultadoDaExclusao);
                            request.getRequestDispatcher("Especialidade/MostrarEspecialidadeExcluida.jsp").forward(request, response);
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
