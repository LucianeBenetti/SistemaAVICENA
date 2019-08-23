
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
  ProntuarioVO prontuarioVO;
    ProntuarioController prontuarioController;

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("excluirprontuario");

        prontuarioVO = new ProntuarioVO();
        prontuarioVO.setCodigoProntuario(Integer.parseInt(request.getParameter("codigoprontuario")));
        Boolean resultadoDaExclusao = false;
        prontuarioController = new ProntuarioController();
        if (prontuarioController.excluirProntuarioPorId(prontuarioVO.getCodigoProntuario())) {

            resultadoDaExclusao = true;
            request.setAttribute("codigoprontuario", prontuarioVO.getCodigoProntuario());
             request.setAttribute("resultadodaexclusao", resultadoDaExclusao);
            request.getRequestDispatcher("Prontuario/MostrarProntuarioExcluido.jsp").forward(request, response);
        } else {
            request.setAttribute("nomeprontuario", resultadoDaExclusao);
            request.getRequestDispatcher("Prontuario/MostrarProntuarioExcluido.jsp").forward(request, response);
        }
    }

@Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
