package Servlets.Especializacao;

import controller.Especializacao.EspecializacaoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Especializacao.EspecializacaoVO;

public class PesquisarParaExcluirEspecializacao extends HttpServlet {

    EspecializacaoVO especializacaoVO = new EspecializacaoVO();
    List<EspecializacaoVO> especializacoesBuscadas = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        especializacaoVO.getMedicoVO().setNomeMedico(request.getParameter("nomemedico"));
        EspecializacaoController especializacaocontroller = new EspecializacaoController();
        Boolean resultadoDaPesquisaPorNome = false;
        especializacoesBuscadas = especializacaocontroller.pesquisarEspecializacaoPorIdDoMedico(especializacaoVO.getMedicoVO().getCodigoMedico());

        System.out.println(especializacaoVO);
        if (especializacoesBuscadas != null) {

            System.out.println(especializacoesBuscadas);
            request.setAttribute("especializacoesBuscadas", especializacoesBuscadas);

            resultadoDaPesquisaPorNome = true;
            request.setAttribute("especializacaovoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("Especializacao/PesquisarEspecializacaoPorNome.jsp").forward(request, response);

        } else {
            System.out.println("O especializacao não foi encontrada!");
            request.setAttribute("especializacaovoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("Especializacao/PesquisarEspecializacaoPorNome.jsp").forward(request, response);
        }
    }
}
