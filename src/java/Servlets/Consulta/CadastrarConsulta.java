package Servlets.Consulta;

import controller.Consulta.ConsultaController;
import controller.Especialidade.EspecialidadeController;
import controller.Medico.MedicoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Consulta.ConsultaVO;
import model.vo.Convenio.ConvenioVO;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;
import model.vo.Paciente.PacienteVO;

public class CadastrarConsulta extends HttpServlet {

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
        int codigoConvenio = new Integer(request.getParameter("codigoconvenio"));
        int codigoPaciente = new Integer(request.getParameter("codigopaciente"));
        int codigoEspecialzacao = new Integer(request.getParameter("codigoespecializacao"));
        especializacaoVO.setCodigoEspecializacao(codigoEspecialzacao);
        convenioVO.setCodigoConvenio(codigoConvenio);
        pacienteVO.setCodigoPaciente(codigoPaciente);

        String dataConsulta = request.getParameter("dataconsulta");
        consultaVO = new ConsultaVO();
        consultaVO.setAtencaoEspecial(request.getParameter("atencaoEspecial"));
        consultaVO.setConvenioVO(convenioVO);
        consultaVO.setDataConsulta(dataConsulta);
        consultaVO.setEspecializacaoVO(especializacaoVO);
        consultaVO.setHorarioConsulta(request.getParameter("horaconsulta"));
        consultaVO.setPacienteVO(pacienteVO);

        consultaController = new ConsultaController();

        int novoId = consultaController.cadastrarConsultaVO(consultaVO);
        Boolean resultadoDoCadastro = false;

        if ((novoId > 0)) {

            request.setAttribute("idconsulta", novoId);
            request.setAttribute("nomepaciente", nomepaciente);
            request.setAttribute("horarioconsulta", consultaVO.getHorarioConsulta());
            request.setAttribute("dataconsulta", dataConsulta);
            request.setAttribute("nomemedico", nomeMedico);
            request.setAttribute("nomeespecialidade", nomeEspecialidade);
            request.setAttribute("nomeconvenio", nomeConvenio);
            request.setAttribute("atençãoEspecial", consultaVO.getAtencaoEspecial());

            resultadoDoCadastro = true;

            request.setAttribute("consultacadastrada", resultadoDoCadastro);
            request.getRequestDispatcher("Consulta/MostrarConsultaCadastrada.jsp").forward(request, response);

        } else {
            request.setAttribute("consultacadastrada", resultadoDoCadastro);
            request.getRequestDispatcher("Consulta/MostrarConsultaCadastrada.jsp").forward(request, response);
        }

    }

}
