package Servlets.Convenio;

import controller.Convenio.ConvenioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Convenio.ConvenioVO;

public class AtualizarConvenio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object usuarioValidado = request.getSession().getAttribute("perfil");
        ConvenioVO convenioVO = new ConvenioVO();

        convenioVO.setNomeConvenio(request.getParameter("nomeconvenio"));
        convenioVO.setCnpjConvenio(request.getParameter("cnpjconvenio"));
        convenioVO.setValor(request.getParameter("valor"));

        ConvenioController conveniocontroller = new ConvenioController();
        boolean atualizado = conveniocontroller.atualizarConvenioVO(convenioVO);
        Boolean resultadoDaAtualizacao = false;

        if (atualizado) {
            resultadoDaAtualizacao = true;
            request.setAttribute("resultadotransacao", resultadoDaAtualizacao);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
            } else if (usuarioValidado.equals("atendente")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("resultadotransacao", resultadoDaAtualizacao);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
            } else if (usuarioValidado.equals("atendente")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
            }
        }
    }
}
