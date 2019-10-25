package servlets.convenio;

import controller.convenio.ConvenioController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vo.convenio.ConvenioVO;

public class PesquisarConvenioPorCnpj extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object usuarioValidado = request.getSession().getAttribute("perfil");

        ConvenioVO convenioVO = new ConvenioVO();
        convenioVO.setCnpjConvenio(request.getParameter("cnpjconvenio"));
        ConvenioController conveniocontroller = new ConvenioController();
        Boolean resultadoDaPesquisaPorCpf = false;
        convenioVO = conveniocontroller.pesquisarConvenioVOPorCnpj(convenioVO.getCnpjConvenio());

        if (convenioVO != null) {

            request.setAttribute("codigoconvenio", convenioVO.getCodigoConvenio());
            request.setAttribute("nomeconvenio", convenioVO.getNomeConvenio());
            request.setAttribute("cnpjconvenio", convenioVO.getCnpjConvenio());
            request.setAttribute("valor", convenioVO.getValor());

            resultadoDaPesquisaPorCpf = true;
            HttpSession session = request.getSession();
            session.setAttribute("codigoconvenio", convenioVO.getCodigoConvenio());

            request.setAttribute("conveniovoretornado", resultadoDaPesquisaPorCpf);
            request.getRequestDispatcher("convenio/AtualizarConvenio.jsp").forward(request, response);

        } else {
            request.setAttribute("resultadotransacao", resultadoDaPesquisaPorCpf);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
            } else if (usuarioValidado.equals("atendente")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
            }

        }
    }
}