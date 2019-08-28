package Servlets.Prontuario;

import controller.Prontuario.ReceitaController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Consulta.ConsultaVO;
import model.vo.Paciente.PacienteVO;
import model.vo.Prontuario.ReceitaVO;

public class EmitirReceita extends HttpServlet {

    ReceitaVO receitaVO;
    ReceitaController receitaController;
    java.util.List<ReceitaVO> listaReceitas = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PacienteVO pacienteVO = new PacienteVO();
        ConsultaVO consultaVO = new ConsultaVO();
        String nomepaciente = request.getParameter("nomepaciente");
        int codigoPaciente = new Integer(request.getParameter("codigopaciente"));
        pacienteVO.setCodigoPaciente(codigoPaciente);
        int codigoConsulta = new Integer(request.getParameter("codigoconsulta"));
        consultaVO.setCodigoConsulta(codigoConsulta);

        receitaVO = new ReceitaVO();
        receitaVO.setConsultaVO(consultaVO);
        receitaVO.setMedicamento(request.getParameter("medicamentos"));
        receitaVO.setExame(request.getParameter("exames"));
        receitaVO.setObservacao(request.getParameter("registroobservacao"));

        receitaController = new ReceitaController();
        listaReceitas = receitaController.buscarReceitasPorConsulta(codigoConsulta);

        Boolean resultadoDoCadastro = false;
        receitaController.cadastrarReceitaVO(receitaVO);

        request.setAttribute("codigoPaciente", codigoPaciente);
        request.setAttribute("nomepaciente", nomepaciente);
        request.setAttribute("medicamentos", receitaVO.getMedicamento());
        request.setAttribute("exames", receitaVO.getExame());
        request.setAttribute("registro", receitaVO.getObservacao());
        resultadoDoCadastro = true;
        request.setAttribute("receitacadastrada", resultadoDoCadastro);
        request.getRequestDispatcher("Prontuario/MostrarReceitaCadastrada.jsp").forward(request, response);
    }

}
