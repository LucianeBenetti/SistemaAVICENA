package Servlets.Relatorios;

import controller.Consulta.ConsultaController;
import controller.Convenio.ConvenioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vo.Consulta.ConsultaVO;
import model.vo.Convenio.ConvenioVO;

public class PesquisarConsultaPorConvenio extends HttpServlet {

    ConvenioVO convenioVO = new ConvenioVO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        convenioVO.setCnpjConvenio(request.getParameter("cnpjconvenio"));
        ConvenioController conveniocontroller = new ConvenioController();
        Boolean resultadoDaPesquisaPorCpf = false;
        convenioVO = conveniocontroller.pesquisarConvenioVOPorCnpj(convenioVO.getCnpjConvenio());

        if (convenioVO != null) {

            int codigoConvenio = convenioVO.getCodigoConvenio();

            List<ConsultaVO> listaConsultas = null;
            Boolean resultadoDaPesquisaDeConsultas = false;

            ConsultaController consultaController = new ConsultaController();
            listaConsultas = consultaController.listarConsultasVOPorConvenio(codigoConvenio);
            System.out.println("Servlets.Relatorios.PesquisarConsultaPorConvenio.processRequest()" + listaConsultas);
            if (listaConsultas.size() > 0) {

                HttpSession session = request.getSession();
                session.setAttribute("listaconsultas", listaConsultas);
                request.setAttribute("listaconsultas", listaConsultas);

            } else {
                System.out.println("O consulta não foi encontrada!");
                request.setAttribute("consultavoretornada", resultadoDaPesquisaDeConsultas);
            }
            request.getRequestDispatcher("Relatorios/RelatorioDeConsultaPorConvenio.jsp").forward(request, response);
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
