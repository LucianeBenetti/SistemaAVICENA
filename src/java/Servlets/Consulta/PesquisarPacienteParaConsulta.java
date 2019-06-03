package Servlets.Consulta;

import controller.Paciente.PacienteController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vo.Paciente.PacienteVO;

public class PesquisarPacienteParaConsulta extends HttpServlet {

    PacienteVO pacienteVO = new PacienteVO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        pacienteVO.setCpfPaciente(request.getParameter("cpfpaciente"));
        PacienteController pacientecontroller = new PacienteController();
        Boolean resultadoDaPesquisaPorCpf = false;
        pacienteVO = pacientecontroller.pesquisarPacienteVOPorCpf(pacienteVO.getCpfPaciente());

        if (pacienteVO != null) {
            resultadoDaPesquisaPorCpf = true;
            request.setAttribute("codigopaciente", pacienteVO.getCodigoPaciente());
            request.setAttribute("nomepaciente", pacienteVO.getNomePaciente());
            request.setAttribute("pacientevoretornado", resultadoDaPesquisaPorCpf);
            request.getRequestDispatcher("Consulta/CadastrarConsulta.jsp").forward(request, response);

        } else {
            System.out.println("O paciente não foi encontrado!");
            request.setAttribute("pacientevoretornado", resultadoDaPesquisaPorCpf);
            request.getRequestDispatcher("Consulta/CadastrarConsulta.jsp").forward(request, response);
        }

    }

}
