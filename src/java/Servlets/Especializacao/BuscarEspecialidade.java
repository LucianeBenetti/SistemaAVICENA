package Servlets.Especializacao;

import controller.Especialidade.EspecialidadeController;
import controller.Medico.MedicoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Medico.MedicoVO;

public class BuscarEspecialidade extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String buscarEspecialidades = request.getParameter("buscarEspecialidades");

        EspecialidadeController especialidadeController = new EspecialidadeController();
        ArrayList<EspecialidadeVO> listaEspecialidadesVO = new ArrayList<EspecialidadeVO>();

        listaEspecialidadesVO = especialidadeController.listarTodasAsEspecialidadesVO();

        if (listaEspecialidadesVO != null) {
            request.setAttribute("listaEspecialidadesVO", listaEspecialidadesVO);
        }

        MedicoController medicoController = new MedicoController();
        ArrayList<MedicoVO> listaMedicosVO = new ArrayList<MedicoVO>();

        listaMedicosVO = medicoController.listarTodosOsMedicosVO();

        if (listaMedicosVO != null) {
            request.setAttribute("listaMedicosVO", listaMedicosVO);
        }

        request.getRequestDispatcher("Especializacao/PesquisarEspecializacaoParaCadastrar.jsp").forward(request, response);

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
