package servlets.especializacao;

import controller.especializacao.EspecializacaoController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.especialidade.EspecialidadeVO;
import model.vo.especializacao.EspecializacaoVO;
import model.vo.medico.MedicoVO;

public class AtualizarEspecializacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object usuarioValidado = request.getSession().getAttribute("perfil");

        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        MedicoVO medicoVO = new MedicoVO();
        EspecialidadeVO especialidadeVO = new EspecialidadeVO();
        int codigoMedico = new Integer(request.getParameter("codigomedico"));
        int codigoEspecialidade = new Integer(request.getParameter("codigoespecialidade"));
        int codigoEspecialização = new Integer(request.getParameter("codigoespecializacao"));
        int anoEspecializacao = new Integer(request.getParameter("anoespecializacao"));
        medicoVO.setCodigoMedico(codigoMedico);
        especialidadeVO.setCodigoEspecialidade(codigoEspecialidade);

        especializacaoVO.setCodigoEspecializacao(codigoEspecialização);
        especializacaoVO.setMedicoVO(medicoVO);
        especializacaoVO.setEspecialidadeVO(especialidadeVO);
        especializacaoVO.setAnoEspecializacao(anoEspecializacao);
        System.out.println("especialidadeVO: " + especialidadeVO);

        EspecializacaoController especializacaocontroller = new EspecializacaoController();
        //     especializacaocontroller.atualizarEspecializacaoVO(especializacaoVO, especializacaoVO.getCodigoEspecializacao());
        Boolean resultadoDaAtualizacao = false;

        if (especializacaocontroller.atualizarEspecializacaoVO(especializacaoVO, especializacaoVO.getCodigoEspecializacao()) != null) {
            resultadoDaAtualizacao = true;
            request.setAttribute("resultadotransacao", resultadoDaAtualizacao);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
            } else if (usuarioValidado.equals("medico")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialMedico.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("resultadotransacao", resultadoDaAtualizacao);
            if (usuarioValidado.equals("admin")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
            } else if (usuarioValidado.equals("medico")) {
                request.getRequestDispatcher("WEB-INF/PaginaInicialMedico.jsp").forward(request, response);
            }
        }

    }
}
