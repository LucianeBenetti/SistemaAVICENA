package Servlets.Prontuario;

import controller.Prontuario.ProntuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Paciente.PacienteVO;
import model.vo.Prontuario.ProntuarioVO;

public class CadastrarProntuario extends HttpServlet {

    ProntuarioVO prontuarioVO;
    ProntuarioController prontuarioController;
    List<ProntuarioVO> listaProntuarios = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        System.out.println("Servlets.Prontuario " + listaProntuarios);

        Boolean resultadoDoCadastro = false;

        if (listaProntuarios.size() == 0) {
            prontuarioController.cadastrarProntuarioVO(prontuarioVO);
        } else {
            prontuarioController.atualizarProntuarioVO(prontuarioVO, prontuarioVO.getCodigoProntuario());
          //  request.setAttribute("prontuariocadastrado", resultadoDoCadastro);
           // request.getRequestDispatcher("Prontuario/MostrarProntuarioCadastrado.jsp").forward(request, response);
        }
        request.setAttribute("codigoPaciente", codigoPaciente);
        request.setAttribute("nomepaciente", nomepaciente);
        request.setAttribute("medicamentos", prontuarioVO.getMedicamento());
        request.setAttribute("exames", prontuarioVO.getExame());
        request.setAttribute("procedimento", prontuarioVO.getProcedimento());
        request.setAttribute("registro", prontuarioVO.getRegistro());
        resultadoDoCadastro = true;
        request.setAttribute("prontuariocadastrado", resultadoDoCadastro);
        request.getRequestDispatcher("Prontuario/MostrarProntuarioCadastrado.jsp").forward(request, response);
    }

}
