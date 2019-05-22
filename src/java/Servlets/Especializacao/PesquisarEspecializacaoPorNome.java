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

public class PesquisarEspecializacaoPorNome extends HttpServlet {

  
    EspecializacaoVO especializacaoVO = new EspecializacaoVO();
    List<EspecializacaoVO> especializacaosBuscadas = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        especializacaoVO.setCodigoEspecializacao(Integer.parseInt(request.getParameter("idespecializacao")));
        EspecializacaoController especializacaocontroller = new EspecializacaoController();
        Boolean resultadoDaPesquisaPorNome = false;
        especializacaosBuscadas = especializacaocontroller.existeEspecializacaoPorNome(especializacaoVO.getMedicoVO().getNomeMedico(), especializacaoVO.getEspecialidadeVO().getNomeEspecialidade());
             
            System.out.println(especializacaoVO);
        if (especializacaosBuscadas!= null){

            System.out.println(especializacaosBuscadas);
            request.setAttribute("especializacaosBuscadas", especializacaosBuscadas);

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
