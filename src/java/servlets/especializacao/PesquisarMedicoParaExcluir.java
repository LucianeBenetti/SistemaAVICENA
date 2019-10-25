package servlets.especializacao;

import controller.medico.MedicoController;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.medico.MedicoVO;

public class PesquisarMedicoParaExcluir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Object usuarioValidado = request.getSession().getAttribute("perfil");

        MedicoController medicoController = new MedicoController();
        ArrayList<MedicoVO> listaMedicosVO = new ArrayList<MedicoVO>();
        Boolean resultadoDoCadastro = false;
        listaMedicosVO = medicoController.listarTodosOsMedicosVO();

        if (listaMedicosVO != null) {

            request.setAttribute("listaMedicosVO", listaMedicosVO);
            request.getRequestDispatcher("especializacao/PesquisarEspecializacaoParaExcluir.jsp").forward(request, response);

        } else {
            request.setAttribute("resultadotransacao", resultadoDoCadastro);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
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
