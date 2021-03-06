package servlets.paciente;

import controller.paciente.PacienteController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.paciente.PacienteVO;

public class AtualizarPaciente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PacienteVO pacienteVO = new PacienteVO();
        Object usuarioValidado = request.getSession().getAttribute("perfil");

        pacienteVO.setNomePaciente(request.getParameter("nomepaciente"));
        pacienteVO.setCelMensagemPaciente(request.getParameter("celularpaciente"));
        pacienteVO.setFoneResidencial(request.getParameter("foneresidencial"));
        pacienteVO.setFoneComercial(request.getParameter("fonecomercial"));
        pacienteVO.setEmailPaciente(request.getParameter("emailpaciente"));
        pacienteVO.setCpfPaciente(request.getParameter("cpfpaciente"));
        pacienteVO.setCnpjPaciente(request.getParameter("cnpjpaciente"));
        pacienteVO.setLogradouro(request.getParameter("logradouro"));
        pacienteVO.setNumLogradouro(request.getParameter("numlogradouro"));
        pacienteVO.setComplemento(request.getParameter("complemento"));
        pacienteVO.setBairro(request.getParameter("bairro"));
        pacienteVO.setCidade(request.getParameter("cidade"));
        pacienteVO.setCep(request.getParameter("uf"));
        pacienteVO.setUf(request.getParameter("cep"));

        PacienteController pacientecontroller = new PacienteController();
        boolean atualizado = pacientecontroller.atualizarPacienteVO(pacienteVO);
        Boolean resultadoDaAtualizacao = false;

        if (atualizado) {
            resultadoDaAtualizacao = true;
            request.setAttribute("resultadotransacao", resultadoDaAtualizacao);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
            } else if (usuarioValidado.equals("atendente")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("resultadotransacao", resultadoDaAtualizacao);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
            } else if (usuarioValidado.equals("atendente")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
            }
        }

    }
}
