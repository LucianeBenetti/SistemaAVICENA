package servlets.medico;

import controller.medico.MedicoController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.medico.MedicoVO;

public class AtualizarMedico extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object usuarioValidado = request.getSession().getAttribute("perfil");

        MedicoVO medicoVO = new MedicoVO();
        medicoVO.setNomeMedico(request.getParameter("nomemedico"));
        medicoVO.setCrm(request.getParameter("crm"));
        medicoVO.setCelMensagemMedico(request.getParameter("celularwhats"));
        medicoVO.setCelularMedico(request.getParameter("celularmedico"));
        medicoVO.setEmailMedico(request.getParameter("email"));
        medicoVO.setCpfMedico(request.getParameter("cpfmedico"));
        medicoVO.setCnpjMedico(request.getParameter("cnpjmedico"));

        MedicoController medicocontroller = new MedicoController();
        boolean atualizado = medicocontroller.atualizarMedicoVO(medicoVO);
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
