
package Servlets.Convenio;

import controller.Convenio.ConvenioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Convenio.ConvenioVO;

public class PesquisarConvenioPorCnpj extends HttpServlet {

     ConvenioVO convenioVO = new ConvenioVO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
            request.setAttribute("conveniovoretornado", resultadoDaPesquisaPorCpf);
            request.getRequestDispatcher("Convenio/PesquisarConvenioPorCnpj.jsp").forward(request, response);

        } else {
            System.out.println("O convenio não foi encontrado!");
            request.setAttribute("conveniovoretornado", resultadoDaPesquisaPorCpf);
            request.getRequestDispatcher("Convenio/PesquisarConvenioPorCnpj.jsp").forward(request, response);
        }

    }
}
