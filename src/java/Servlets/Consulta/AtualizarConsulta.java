
package Servlets.Consulta;

import controller.Consulta.ConsultaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Consulta.ConsultaVO;
import model.vo.Convenio.ConvenioVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Paciente.PacienteVO;

public class AtualizarConsulta extends HttpServlet {
 ConsultaVO consultaVO;
    ConsultaController consultaController;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        ConvenioVO convenioVO = new ConvenioVO();
        PacienteVO pacienteVO = new PacienteVO();

        String nomeMedico = request.getParameter("nomemedico");
        String nomeEspecialidade = request.getParameter("nomeespecialidade");
        String nomeConvenio = request.getParameter("nomeconvenio");
        String nomepaciente = request.getParameter("nomepaciente");
        int codigoConsulta = new Integer(request.getParameter("codigoconsulta"));
        int codigoConvenio = new Integer(request.getParameter("codigoconvenio"));
        int codigoPaciente = new Integer(request.getParameter("codigopaciente"));
        int codigoEspecializacao = new Integer(request.getParameter("codigoespecializacao"));
        especializacaoVO.setCodigoEspecializacao(codigoEspecializacao);
        convenioVO.setCodigoConvenio(codigoConvenio);
        pacienteVO.setCodigoPaciente(codigoPaciente);

        String dataConsulta = request.getParameter("dataconsulta");
        consultaVO = new ConsultaVO();
        consultaVO.setCodigoConsulta(codigoConsulta);
        consultaVO.setAtencaoEspecial(request.getParameter("atencaoEspecial"));
        consultaVO.setConvenioVO(convenioVO);
        consultaVO.setDataConsulta(dataConsulta);
        consultaVO.setEspecializacaoVO(especializacaoVO);
        consultaVO.setHorarioConsulta(request.getParameter("horarioconsulta"));
        consultaVO.setPacienteVO(pacienteVO);

        consultaController = new ConsultaController();

        boolean atualizada = consultaController.atualizarConsultaVO(consultaVO, codigoConsulta);
        Boolean resultadoDaAtualizacao = false;

        if (atualizada) {
   
            request.setAttribute("nomepaciente", nomepaciente);
            request.setAttribute("horarioconsulta", consultaVO.getHorarioConsulta());
            request.setAttribute("dataconsulta", dataConsulta);
            request.setAttribute("nomemedico", nomeMedico);
            request.setAttribute("nomeespecialidade", nomeEspecialidade);
            request.setAttribute("nomeconvenio", nomeConvenio);
            request.setAttribute("atençãoEspecial", consultaVO.getAtencaoEspecial());

            resultadoDaAtualizacao = true;

            request.setAttribute("consultaatualizada", resultadoDaAtualizacao);
            request.getRequestDispatcher("Consulta/ResultadoDaAtualizacao.jsp").forward(request, response);

        } else {
            request.setAttribute("consultaatualizada", resultadoDaAtualizacao);
            request.getRequestDispatcher("Consulta/ResultadoDaAtualizacao.jsp").forward(request, response);
        }

    }

}