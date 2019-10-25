package servlets.paciente;

import controller.paciente.PacienteController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.paciente.PacienteVO;

public class PesquisarPacientePorCpf extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PacienteVO pacienteVO = new PacienteVO();
        Object usuarioValidado = request.getSession().getAttribute("perfil");

        pacienteVO.setCpfPaciente(request.getParameter("cpfpaciente"));
        PacienteController pacientecontroller = new PacienteController();
        Boolean resultadoDaPesquisaPorCpf = false;
        pacienteVO = pacientecontroller.pesquisarPacienteVOPorCpf(pacienteVO.getCpfPaciente());

        if (pacienteVO != null) {

            request.setAttribute("codigopaciente", pacienteVO.getCodigoPaciente());
            request.setAttribute("nomepaciente", pacienteVO.getNomePaciente());
            request.setAttribute("celmenpaciente", pacienteVO.getCelMensagemPaciente());
            request.setAttribute("foneresidencial", pacienteVO.getFoneResidencial());
            request.setAttribute("fonecomercial", pacienteVO.getFoneComercial());
            request.setAttribute("emailpaciente", pacienteVO.getEmailPaciente());
            request.setAttribute("cpfpaciente", pacienteVO.getCpfPaciente());
            request.setAttribute("cnpjpaciente", pacienteVO.getCnpjPaciente());
            request.setAttribute("logradouro", pacienteVO.getLogradouro());
            request.setAttribute("numlogradouro", pacienteVO.getNumLogradouro());
            request.setAttribute("complemento", pacienteVO.getComplemento());
            request.setAttribute("bairro", pacienteVO.getBairro());
            request.setAttribute("cidade", pacienteVO.getCidade());
            request.setAttribute("uf", pacienteVO.getUf());
            request.setAttribute("cep", pacienteVO.getCep());

            resultadoDaPesquisaPorCpf = true;

            request.setAttribute("pacientevoretornado", resultadoDaPesquisaPorCpf);
            request.getRequestDispatcher("paciente/ResultadoDaPesquisaPorCpf.jsp").forward(request, response);

        } else {
            request.setAttribute("resultadotransacao", resultadoDaPesquisaPorCpf);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
            } else if (usuarioValidado.equals("atendente")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
            }
        }

    }

}
