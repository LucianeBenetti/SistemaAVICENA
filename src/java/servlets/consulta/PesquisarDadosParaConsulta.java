package servlets.consulta;

import controller.convenio.ConvenioController;
import controller.especializacao.EspecializacaoController;
import controller.paciente.PacienteController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.convenio.ConvenioVO;
import model.vo.especializacao.EspecializacaoVO;
import model.vo.paciente.PacienteVO;

public class PesquisarDadosParaConsulta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PacienteVO pacienteVO = new PacienteVO();

        Object usuarioValidado = request.getSession().getAttribute("perfil");

        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        List<EspecializacaoVO> listaEspecializacoes = null;
        Boolean resultadoDaPesquisaPorNome = false;

        EspecializacaoController especializacaoController = new EspecializacaoController();
        listaEspecializacoes = especializacaoController.listarTodasAsEspecializacoesVO();

        if (listaEspecializacoes.size() > 0) {
            request.setAttribute("listaEspecializacoes", listaEspecializacoes);
            resultadoDaPesquisaPorNome = true;
            request.setAttribute("especializacaovoretornada", resultadoDaPesquisaPorNome);

        } else {
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
                request.getRequestDispatcher("consulta/CadastrarConsulta.jsp").forward(request, response);

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
