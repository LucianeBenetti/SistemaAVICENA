package servlets.especialidade;

import controller.especialidade.EspecialidadeController;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.especialidade.EspecialidadeVO;

public class PesquisarEspecialidade extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object usuarioValidado = request.getSession().getAttribute("perfil");

        EspecialidadeVO especialidadeVO = new EspecialidadeVO();
        especialidadeVO.setNomeEspecialidade(request.getParameter("nomeespecialidade"));
        EspecialidadeController especialidadecontroller = new EspecialidadeController();
        List<EspecialidadeVO> especialidadesBuscadas = especialidadecontroller.exibirEspecialidadePorNome(especialidadeVO.getNomeEspecialidade());
        Boolean resultadoDaPesquisaPorNome = false;

        if (especialidadesBuscadas.size() > 0) {

            resultadoDaPesquisaPorNome = true;
            request.setAttribute("especialidadesBuscadas", especialidadesBuscadas);
            request.setAttribute("especialidadevoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("especialidade/AtualizarEspecialidade.jsp").forward(request, response);

        } else {

            request.setAttribute("resultadotransacao", resultadoDaPesquisaPorNome);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
            } else if (usuarioValidado.equals("atendente")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
            }
        }
    }
}
