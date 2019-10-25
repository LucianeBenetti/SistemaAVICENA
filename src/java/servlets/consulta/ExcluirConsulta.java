package servlets.consulta;

import controller.consulta.ConsultaController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.consulta.ConsultaVO;

public class ExcluirConsulta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ConsultaVO consultaVO;
        ConsultaController consultaController;

        Object usuarioValidado = request.getSession().getAttribute("perfil");
        String var1 = request.getParameter("excluirconsulta");

        consultaVO = new ConsultaVO();
        consultaVO.setCodigoConsulta(Integer.parseInt(request.getParameter("codigoconsulta")));
        Boolean resultadoDaExclusao = false;
        consultaController = new ConsultaController();
        if (consultaController.excluirConsultaPorId(consultaVO.getCodigoConsulta())) {

            resultadoDaExclusao = true;
            request.setAttribute("resultadotransacao", resultadoDaExclusao);
            request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
        } else {
            request.setAttribute("resultadotransacao", resultadoDaExclusao);
            request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
