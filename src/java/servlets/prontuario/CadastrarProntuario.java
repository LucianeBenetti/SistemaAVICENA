package servlets.prontuario;

import controller.prontuario.ProntuarioController;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.paciente.PacienteVO;
import model.vo.prontuario.ProntuarioVO;

public class CadastrarProntuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProntuarioVO prontuarioVO;
        ProntuarioController prontuarioController;
        List<ProntuarioVO> listaProntuarios = null;
        Object usuarioValidado = request.getSession().getAttribute("perfil");
        PacienteVO pacienteVO = new PacienteVO();
        String nomepaciente = request.getParameter("nomepaciente");
        int codigoPaciente = new Integer(request.getParameter("codigopaciente"));
        pacienteVO.setCodigoPaciente(codigoPaciente);

        prontuarioVO = new ProntuarioVO();
        prontuarioVO.setPacienteVO(pacienteVO);
        prontuarioVO.setMedicamento(request.getParameter("medicamentos"));
        prontuarioVO.setExame(request.getParameter("exames"));
        prontuarioVO.setProcedimento(request.getParameter("procedimento"));
        prontuarioVO.setRegistro(request.getParameter("registro"));

        prontuarioController = new ProntuarioController();
        listaProntuarios = prontuarioController.listarProntuarioPorPaciente(codigoPaciente);

        Boolean resultadoDoCadastro = false;

        if (listaProntuarios.size() == 0) {
            prontuarioController.cadastrarProntuarioVO(prontuarioVO);
        } else {
            int codigoProntuario = new Integer(request.getParameter("codigoprontuario"));
            prontuarioVO.setCodigoProntuario(codigoProntuario);
            prontuarioController.atualizarProntuarioVO(prontuarioVO, prontuarioVO.getCodigoProntuario());
        }
        request.setAttribute("codigoPaciente", codigoPaciente);
        request.setAttribute("nomepaciente", nomepaciente);
        request.setAttribute("medicamentos", prontuarioVO.getMedicamento());
        request.setAttribute("exames", prontuarioVO.getExame());
        request.setAttribute("procedimento", prontuarioVO.getProcedimento());
        request.setAttribute("registro", prontuarioVO.getRegistro());
        resultadoDoCadastro = true;
        request.setAttribute("resultadotransacao", resultadoDoCadastro);
        if (usuarioValidado.equals("admin")) {
            request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
        } else if (usuarioValidado.equals("medico")) {
            request.getRequestDispatcher("WEB-INF/PaginaInicialMedico.jsp").forward(request, response);
        }
    }
}
