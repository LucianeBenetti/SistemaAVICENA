package Servlets.Prontuario;

import controller.Prontuario.ProntuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Prontuario.ProntuarioVO;

public class ExcluirProntuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ProntuarioVO prontuarioVO;
        ProntuarioController prontuarioController;

        String var1 = request.getParameter("excluirprontuario");

        prontuarioVO = new ProntuarioVO();
        prontuarioVO.setCodigoProntuario(Integer.parseInt(request.getParameter("codigoprontuario")));
        Boolean resultadoDaExclusao = false;
        prontuarioController = new ProntuarioController();
        if (prontuarioController.excluirProntuarioPorId(prontuarioVO.getCodigoProntuario())) {

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
