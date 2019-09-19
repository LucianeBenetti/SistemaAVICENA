package Servlets.Medico;

import controller.Medico.MedicoController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Medico.MedicoVO;

public class PesquisarMedicoPorCpf extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
            request.getRequestDispatcher("Medico/PesquisarMedicoPorCpf.jsp").forward(request, response);

        } else {
            System.out.println("O medico não foi encontrado!");
            request.setAttribute("medicovoretornado", resultadoDaPesquisaPorCpf);
            request.getRequestDispatcher("Medico/PesquisarMedicoPorCpf.jsp").forward(request, response);
        }

    }
}
