package Servlets.Especializacao;

import controller.Especializacao.EspecializacaoController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class AtualizarEspecializacao extends HttpServlet {

    EspecializacaoVO especializacaoVO = new EspecializacaoVO();
    MedicoVO medicoVO = new MedicoVO();
    EspecialidadeVO especialidadeVO = new EspecialidadeVO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codigoMedico = new Integer(request.getParameter("codigomedico"));
        int codigoEspecialidade = new Integer(request.getParameter("codigoespecialidade"));
        int codigoEspecialização = new Integer(request.getParameter("codigoespecializacao"));
        medicoVO.setCodigoMedico(codigoMedico);
        especialidadeVO.setCodigoEspecialidade(codigoEspecialidade);

        especializacaoVO.setCodigoEspecializacao(codigoEspecialização);
        especializacaoVO.setMedicoVO(medicoVO);
        especializacaoVO.setEspecialidadeVO(especialidadeVO);
        especializacaoVO.setAnoEspecializacao(request.getParameter("anoespecializacao"));
        System.out.println("especialidadeVO: " + especialidadeVO);

        EspecializacaoController especializacaocontroller = new EspecializacaoController();
        //     especializacaocontroller.atualizarEspecializacaoVO(especializacaoVO, especializacaoVO.getCodigoEspecializacao());
        Boolean resultadoDaAtualizacao = false;

        if (especializacaocontroller.atualizarEspecializacaoVO(especializacaoVO, especializacaoVO.getCodigoEspecializacao()) != null) {
            resultadoDaAtualizacao = true;
            request.setAttribute("resultado", resultadoDaAtualizacao);
            request.getRequestDispatcher("Especializacao/ResultadoDaTransacao.jsp").forward(request, response);
        } else {
            request.setAttribute("resultado", resultadoDaAtualizacao);
        }

        request.getRequestDispatcher("Especializacao/ResultadoDaTransacao.jsp").forward(request, response);

    }
}
