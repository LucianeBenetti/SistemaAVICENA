
package Servlets.Especialidade;

import controller.Especialidade.EspecialidadeController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Especialidade.EspecialidadeVO;

public class PesquisarParaExcluir extends HttpServlet {
EspecialidadeVO especialidadeVO = new EspecialidadeVO();
    List<EspecialidadeVO> especialidadesBuscadas = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        especialidadeVO.setNomeEspecialidade(request.getParameter("nomeespecialidade"));
        EspecialidadeController especialidadecontroller = new EspecialidadeController();
        Boolean resultadoDaPesquisaPorNome = false;
        especialidadesBuscadas = especialidadecontroller.exibirEspecialidadePorNome(especialidadeVO.getNomeEspecialidade());
             
            System.out.println(especialidadeVO);
        if (especialidadesBuscadas!= null){

            System.out.println(especialidadesBuscadas);
            request.setAttribute("especialidadesBuscadas", especialidadesBuscadas);

            resultadoDaPesquisaPorNome = true;
            request.setAttribute("especialidadevoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("Especialidade/ExcluirEspecialidadePorId.jsp").forward(request, response);

        } else {
            System.out.println("O especialidade não foi encontrada!");
            request.setAttribute("especialidadevoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("Especialidade/ExcluirEspecialidadePorId.jsp").forward(request, response);
        }

    }
}
