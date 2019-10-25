package servlets.especializacao;

import controller.especializacao.EspecializacaoController;
import controller.medico.MedicoController;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.especializacao.EspecializacaoVO;
import model.vo.medico.MedicoVO;

public class PesquisarParaExcluirEspecializacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object usuarioValidado = request.getSession().getAttribute("perfil");
        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        List<EspecializacaoVO> especializacoesBuscadas = null;
        MedicoVO medicoVO = new MedicoVO();
        List<MedicoVO> listaMedicos = null;
        Boolean resultadoDaPesquisaPorNome = false;

        medicoVO.setNomeMedico(request.getParameter("medicoSelecionado"));
        MedicoController medicoController = new MedicoController();
        listaMedicos = medicoController.listarTodosOsMedicosVO();

        for (int i = 0; i < listaMedicos.size(); i++) {
            if (medicoVO.getNomeMedico().equals(listaMedicos.get(i).getNomeMedico())) {
                medicoVO.setCodigoMedico(listaMedicos.get(i).getCodigoMedico());
                especializacaoVO.setMedicoVO(medicoVO);
            }
        }
        EspecializacaoController especializacaocontroller = new EspecializacaoController();
        especializacoesBuscadas = especializacaocontroller.pesquisarEspecializacaoPorIdDoMedico(especializacaoVO.getMedicoVO().getCodigoMedico());

        if (especializacoesBuscadas.size() > 0) {

            request.setAttribute("especializacoesBuscadas", especializacoesBuscadas);

            resultadoDaPesquisaPorNome = true;
            request.setAttribute("especializacaovoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("especializacao/ExcluirEspecializacaoPorMedico.jsp").forward(request, response);

        } else {

            request.setAttribute("resultadotransacao", resultadoDaPesquisaPorNome);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
            }
        }

    }
}
