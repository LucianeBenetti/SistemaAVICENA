package Servlets.Relatorios;

import Servlets.Consulta.CadastrarConsulta;
import controller.Consulta.ConsultaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vo.Consulta.ConsultaVO;

public class PesquisarConsultaPorData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String dataInicial = request.getParameter("datainicial");
        String dataFinal = request.getParameter("datafinal");

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cInicial = Calendar.getInstance();
        Calendar cFinal = Calendar.getInstance();
        try {
            cInicial.setTime(formatter.parse(dataInicial));
            cFinal.setTime(formatter.parse(dataFinal));
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date dataSQLInicial = new Date(cInicial.getTimeInMillis());
        Date dataSQLFinal = new Date(cFinal.getTimeInMillis());

        List<ConsultaVO> listaConsultas = null;
        Boolean resultadoDaPesquisaDeConsultas = false;

        ConsultaController consultaController = new ConsultaController();
        listaConsultas = consultaController.listarConsultasVOPorData(dataSQLInicial, dataSQLFinal);

        if (listaConsultas.size() > 0) {

            HttpSession session = request.getSession();
            session.setAttribute("listadeconsultas", listaConsultas);
            request.setAttribute("listadeconsultas", listaConsultas);

        } else {
            System.out.println("O consulta não foi encontrada!");
            request.setAttribute("consultavoretornada", resultadoDaPesquisaDeConsultas);
        }
        System.out.println("Servlets.Relatorios.PesquisarConsultaPorData.processRequest()" + listaConsultas.size());
        request.getRequestDispatcher("Relatorios/RelatorioDeFaturamento.jsp").forward(request, response);

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
