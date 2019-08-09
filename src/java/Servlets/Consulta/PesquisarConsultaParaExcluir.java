package Servlets.Consulta;

import controller.Convenio.ConvenioController;
import controller.Consulta.ConsultaController;
import controller.Paciente.PacienteController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Convenio.ConvenioVO;
import model.vo.Consulta.ConsultaVO;

public class PesquisarConsultaParaExcluir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ConsultaVO consultaVO = new ConsultaVO();
        List<ConsultaVO> listaConsultas = null;
        Boolean resultadoDaPesquisaDeConsultas = false;

        ConsultaController consultaController = new ConsultaController();
        listaConsultas = consultaController.listarTodasAsConsultasVO();

        if (listaConsultas.size() > 0) {
            request.setAttribute("listaConsultas", listaConsultas);
            resultadoDaPesquisaDeConsultas = true;
            request.setAttribute("consultavoretornada", resultadoDaPesquisaDeConsultas);

        } else {
            System.out.println("O consulta não foi encontrada!");
            request.setAttribute("consultavoretornada", resultadoDaPesquisaDeConsultas);
        }
        request.getRequestDispatcher("Consulta/ExcluirConsulta.jsp").forward(request, response);
    }

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
