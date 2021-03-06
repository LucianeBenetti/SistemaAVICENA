package servlets.medico;

import controller.medico.MedicoController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.medico.MedicoVO;

public class PesquisarMedicoPorCpf extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object usuarioValidado = request.getSession().getAttribute("perfil");

        MedicoVO medicoVO = new MedicoVO();
        medicoVO.setCpfMedico(request.getParameter("cpfmedico"));
        MedicoController medicocontroller = new MedicoController();
        Boolean resultadoDaPesquisaPorCpf = false;
        medicoVO = medicocontroller.pesquisarMedicoVOPorCpf(medicoVO.getCpfMedico());

        if (medicoVO != null) {

            request.setAttribute("codigomedico", medicoVO.getCodigoMedico());
            request.setAttribute("nomemedico", medicoVO.getNomeMedico());
            request.setAttribute("crm", medicoVO.getCrm());
            request.setAttribute("celularwhats", medicoVO.getCelMensagemMedico());
            request.setAttribute("celularmedico", medicoVO.getCelularMedico());
            request.setAttribute("email", medicoVO.getEmailMedico());
            request.setAttribute("cpfmedico", medicoVO.getCpfMedico());
            request.setAttribute("cnpjmedico", medicoVO.getCnpjMedico());

            resultadoDaPesquisaPorCpf = true;
            request.setAttribute("medicovoretornado", resultadoDaPesquisaPorCpf);
            request.getRequestDispatcher("medico/AtualizarMedico.jsp").forward(request, response);

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
