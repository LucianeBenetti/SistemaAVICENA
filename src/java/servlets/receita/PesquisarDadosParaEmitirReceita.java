package servlets.receita;

import controller.consulta.ConsultaController;
import controller.paciente.PacienteController;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.consulta.ConsultaVO;
import model.vo.paciente.PacienteVO;

public class PesquisarDadosParaEmitirReceita extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PacienteVO pacienteVO = new PacienteVO();
        Object usuarioValidado = request.getSession().getAttribute("perfil");

        pacienteVO.setCpfPaciente(request.getParameter("cpfpaciente"));
        PacienteController pacientecontroller = new PacienteController();
        pacienteVO = pacientecontroller.pesquisarPacienteVOPorCpf(pacienteVO.getCpfPaciente());
        Boolean resultadoDaPesquisaDeConsultas = false;
        List<ConsultaVO> listaConsultas = null;
        int codigoPaciente = 0;
        if (pacienteVO != null) {

            resultadoDaPesquisaDeConsultas = true;
            codigoPaciente = pacienteVO.getCodigoPaciente();
            ConsultaVO consultaVO = new ConsultaVO();
            consultaVO.setPacienteVO(pacienteVO);
            ConsultaController consultaController = new ConsultaController();
            listaConsultas = consultaController.listarConsultasVOPorID(pacienteVO.getCodigoPaciente());

            request.setAttribute("listaconsultas", listaConsultas);
            request.setAttribute("codigoPaciente", codigoPaciente);
            request.getRequestDispatcher("receita/EmitirReceita.jsp").forward(request, response);
        }
        request.setAttribute("resultadotransacao", resultadoDaPesquisaDeConsultas);
        if (usuarioValidado.equals("admin")) {
            request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
        } else if (usuarioValidado.equals("medico")) {
            request.getRequestDispatcher("WEB-INF/PaginaInicialMedico.jsp").forward(request, response);
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
