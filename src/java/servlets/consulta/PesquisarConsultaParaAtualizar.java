package servlets.consulta;

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

public class PesquisarConsultaParaAtualizar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Object usuarioValidado = request.getSession().getAttribute("perfil");

        PacienteVO pacienteVO = new PacienteVO();
        pacienteVO.setCpfPaciente(request.getParameter("cpfpaciente"));
        PacienteController pacientecontroller = new PacienteController();
        Boolean resultadoDaPesquisaPorCpf = false;
        pacienteVO = pacientecontroller.pesquisarPacienteVOPorCpf(pacienteVO.getCpfPaciente());

        if (pacienteVO != null) {

            ConsultaVO consultaVO = new ConsultaVO();
            consultaVO.setPacienteVO(pacienteVO);
            List<ConsultaVO> listaConsultas = null;
            Boolean resultadoDaPesquisaDeConsultas = false;

            ConsultaController consultaController = new ConsultaController();
            listaConsultas = consultaController.listarConsultasVOPorID(pacienteVO.getCodigoPaciente());

            if (listaConsultas.size() > 0) {
                request.setAttribute("listaconsultas", listaConsultas);
                resultadoDaPesquisaDeConsultas = true;
                request.setAttribute("consultavoretornada", resultadoDaPesquisaDeConsultas);
                resultadoDaPesquisaPorCpf = true;
                request.setAttribute("codigopaciente", pacienteVO.getCodigoPaciente());
                request.setAttribute("nomepaciente", pacienteVO.getNomePaciente());
                request.setAttribute("pacientevoretornado", resultadoDaPesquisaPorCpf);
                request.getRequestDispatcher("consulta/AtualizarConsulta.jsp").forward(request, response);
            } else {
                request.setAttribute("resultadotransacao", resultadoDaPesquisaPorCpf);
                if (usuarioValidado.equals("admin")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
                } else if (usuarioValidado.equals("atendente")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
                }
            }

        }else {
                request.setAttribute("resultadotransacao", resultadoDaPesquisaPorCpf);
                if (usuarioValidado.equals("admin")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
                } else if (usuarioValidado.equals("atendente")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
                }}
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
