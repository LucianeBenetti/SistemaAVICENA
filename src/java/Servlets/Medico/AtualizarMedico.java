package Servlets.Medico;

import controller.Medico.MedicoController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Medico.MedicoVO;

public class AtualizarMedico extends HttpServlet {

    MedicoVO medicoVO = new MedicoVO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
            request.setAttribute("atualizacao", resultadoDaAtualizacao);
            request.getRequestDispatcher("Medico/ResultadoDaAtualizacao.jsp").forward(request, response);
        } else {
            request.setAttribute("atualizacao", resultadoDaAtualizacao);
        }
        request.getRequestDispatcher("Medico/ResultadoDaAtualizacao.jsp").forward(request, response);

    }
}
