package Servlets.Especializacao;

import controller.Especializacao.EspecializacaoController;
import controller.Medico.MedicoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class PesquisarParaExcluirEspecializacao extends HttpServlet {

    EspecializacaoVO especializacaoVO = new EspecializacaoVO();
    List<EspecializacaoVO> especializacoesBuscadas = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

            System.out.println("buscada: " + especializacoesBuscadas);
            request.setAttribute("especializacoesBuscadas", especializacoesBuscadas);

            resultadoDaPesquisaPorNome = true;
            request.setAttribute("especializacaovoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("Especializacao/ExcluirEspecializacaoPorMedico.jsp").forward(request, response);

        } else {
            System.out.println("O especializacao não foi encontrada!");
            request.setAttribute("especializacaovoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("Especializacao/ExcluirEspecializacaoPorMedico.jsp").forward(request, response);
        }
        request.getRequestDispatcher("Especializacao/ExcluirEspecializacaoPorMedico.jsp").forward(request, response);

}
}
