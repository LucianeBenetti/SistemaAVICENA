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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object usuarioValidado = request.getSession().getAttribute("perfil");

        EspecialidadeVO especialidadeVO = new EspecialidadeVO();
        especialidadeVO.setCodigoEspecialidade(Integer.parseInt(request.getParameter("codigoespecialidade")));
        especialidadeVO.setNomeEspecialidade(request.getParameter("nomeespecialidade"));
        especialidadeVO.setInstituicao(request.getParameter("instituicaoespecialidade"));

        EspecialidadeController especialidadecontroller = new EspecialidadeController();
        boolean atualizado = especialidadecontroller.atualizarEspecialidadeVO(especialidadeVO);
        Boolean resultadoDoCadastro = false;

        if (atualizado) {
            resultadoDoCadastro = true;

            request.setAttribute("resultadotransacao", resultadoDoCadastro);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
            } else if (usuarioValidado.equals("atendente")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
            } else {
                request.setAttribute("resultadotransacao", resultadoDoCadastro);
                if (usuarioValidado.equals("admin")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
                } else if (usuarioValidado.equals("atendente")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
                }
            }

        }

    }
}
