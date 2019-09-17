package Servlets.Prontuario;

import controller.Consulta.ConsultaController;
import controller.Paciente.PacienteController;
import controller.Prontuario.ProntuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vo.Consulta.ConsultaVO;
import model.vo.Paciente.PacienteVO;
import model.vo.Prontuario.ProntuarioVO;

public class PesquisarDadosParaCadastrarProntuario extends HttpServlet {

    PacienteVO pacienteVO = new PacienteVO();
    ProntuarioVO prontuarioVO = new ProntuarioVO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        pacienteVO.setCpfPaciente(request.getParameter("cpfpaciente"));
        PacienteController pacientecontroller = new PacienteController();
        Boolean resultadoDaPesquisaPorCpf = false;
        pacienteVO = pacientecontroller.pesquisarPacienteVOPorCpf(pacienteVO.getCpfPaciente());
        Boolean resultadoDaPesquisaDeConsultas = false;
        Boolean resultadoDaPesquisaDeProntuarios = false;
        List<ProntuarioVO> listaProntuarios = null;
        List<ConsultaVO> listaConsultas = null;

        if (pacienteVO != null) {

            int codigoPaciente = pacienteVO.getCodigoPaciente();

            ProntuarioController prontuarioController = new ProntuarioController();
            listaProntuarios = prontuarioController.listarProntuarioPorPaciente(codigoPaciente);
            ConsultaVO consultaVO = new ConsultaVO();
            consultaVO.setPacienteVO(pacienteVO);
            ConsultaController consultaController = new ConsultaController();
            listaConsultas = consultaController.listarConsultasVOPorID(pacienteVO.getCodigoPaciente());

            resultadoDaPesquisaDeProntuarios = true;
            resultadoDaPesquisaDeConsultas = true;
            resultadoDaPesquisaPorCpf = true;
            HttpSession session = request.getSession();
            session.setAttribute("listaconsultas", listaConsultas);
            session.setAttribute("codigopaciente", pacienteVO.getCodigoPaciente());
            session.setAttribute("nomepaciente", pacienteVO.getNomePaciente());

            request.setAttribute("listaconsultas", listaConsultas);
            request.setAttribute("consultavoretornada", resultadoDaPesquisaDeConsultas);
            request.setAttribute("codigopaciente", pacienteVO.getCodigoPaciente());
            request.setAttribute("nomepaciente", pacienteVO.getNomePaciente());
            request.setAttribute("pacientevoretornado", resultadoDaPesquisaPorCpf);
            request.setAttribute("pacientevoretornado", resultadoDaPesquisaDeProntuarios);
            request.setAttribute("listaProntuarios", listaProntuarios);
        } else {
            System.out.println("O consulta não foi encontrada!");
            request.setAttribute("pacientevoretornado", resultadoDaPesquisaDeProntuarios);
            request.setAttribute("consultavoretornada", resultadoDaPesquisaDeConsultas);
        }

        request.getRequestDispatcher("Prontuario/CadastrarProntuario.jsp").forward(request, response);

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
