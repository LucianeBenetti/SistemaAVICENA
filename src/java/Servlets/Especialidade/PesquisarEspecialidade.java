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

public class PesquisarEspecialidade extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EspecialidadeVO especialidadeVO = new EspecialidadeVO();
        especialidadeVO.setNomeEspecialidade(request.getParameter("nomeespecialidade"));
        EspecialidadeController especialidadecontroller = new EspecialidadeController();
        List<EspecialidadeVO> especialidadesBuscadas = especialidadecontroller.exibirEspecialidadePorNome(especialidadeVO.getNomeEspecialidade());
        Boolean resultadoDaPesquisaPorNome = false;

        System.out.println("Servlets.Especialidade: " + especialidadesBuscadas);

        if (especialidadesBuscadas.size() > 0) {

            resultadoDaPesquisaPorNome = true;
            request.setAttribute("especialidadesBuscadas", especialidadesBuscadas);
            request.setAttribute("especialidadevoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("Especialidade/AtualizarEspecialidade.jsp").forward(request, response);

        } else {
            System.out.println("O especialidade não foi encontrada!");
            request.setAttribute("especialidadevoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("Especialidade/AtualizarEspecialidade.jsp").forward(request, response);
        }

        System.out.println("Resultado: " + resultadoDaPesquisaPorNome);
    }
}
