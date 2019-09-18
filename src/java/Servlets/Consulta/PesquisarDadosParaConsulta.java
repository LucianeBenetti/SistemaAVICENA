package Servlets.Consulta;

import controller.Convenio.ConvenioController;
import controller.Especialidade.EspecialidadeController;
import controller.Especializacao.EspecializacaoController;
import controller.Medico.MedicoController;
import controller.Paciente.PacienteController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vo.Convenio.ConvenioVO;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;
import model.vo.Paciente.PacienteVO;

public class PesquisarDadosParaConsulta extends HttpServlet {

    PacienteVO pacienteVO = new PacienteVO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object usuarioValidado = request.getSession().getAttribute("perfil");

        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        List<EspecializacaoVO> listaEspecializacoes = null;
        Boolean resultadoDaPesquisaPorNome = false;

        EspecializacaoController especializacaoController = new EspecializacaoController();
        listaEspecializacoes = especializacaoController.listarTodasAsEspecializacoesVO();

        if (listaEspecializacoes.size() > 0) {
            System.out.println("buscada: " + listaEspecializacoes);
            request.setAttribute("listaEspecializacoes", listaEspecializacoes);
            resultadoDaPesquisaPorNome = true;
            request.setAttribute("especializacaovoretornada", resultadoDaPesquisaPorNome);

        } else {
            System.out.println("A especializacao não foi encontrada!");
            request.setAttribute("especializacaovoretornada", resultadoDaPesquisaPorNome);
        }

        ConvenioController convenioController = new ConvenioController();
        ArrayList<ConvenioVO> conveniosVO = convenioController.listarTodosOsConveniosVO();

        request.setAttribute("convenios", conveniosVO);
        String cpfPaciente = request.getParameter("cpfpaciente");
        Boolean resultadoDaPesquisaPorCpf = false;

        if (cpfPaciente != null) {
            PacienteController pacientecontroller = new PacienteController();
            pacienteVO = pacientecontroller.pesquisarPacienteVOPorCpf(cpfPaciente);

            if (pacienteVO != null) {
                resultadoDaPesquisaPorCpf = true;
                request.setAttribute("codigopaciente", pacienteVO.getCodigoPaciente());
                request.setAttribute("nomepaciente", pacienteVO.getNomePaciente());
                request.setAttribute("pacientevoretornado", resultadoDaPesquisaPorCpf);
                request.getRequestDispatcher("Consulta/CadastrarConsulta.jsp").forward(request, response);

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
}
