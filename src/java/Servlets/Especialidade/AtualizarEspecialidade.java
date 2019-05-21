package Servlets.Especialidade;

import controller.Especialidade.EspecialidadeController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Especialidade.EspecialidadeVO;

public class AtualizarEspecialidade extends HttpServlet {
EspecialidadeVO especialidadeVO = new EspecialidadeVO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        especialidadeVO.setNomeEspecialidade(request.getParameter("nomeespecialidade"));
        especialidadeVO.setInstituicao(request.getParameter("instituicaoespecialidade"));
  
        EspecialidadeController especialidadecontroller = new EspecialidadeController();
        boolean atualizado = especialidadecontroller.atualizarEspecialidadeVO(especialidadeVO);
        Boolean resultadoDaAtualizacao = false;

        if (atualizado) {
            resultadoDaAtualizacao = true;
            request.setAttribute("atualizacao", resultadoDaAtualizacao);
            request.getRequestDispatcher("Especialidade/ResultadoDaAtualizacao.jsp").forward(request, response);
        } else {
            request.setAttribute("atualizacao", resultadoDaAtualizacao);
        }
        request.getRequestDispatcher("Especialidade/ResultadoDaAtualizacao.jsp").forward(request, response);

    }
}
