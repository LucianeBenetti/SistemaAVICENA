package Servlets.Consulta;

import controller.Consulta.ConsultaController;
import controller.Convenio.ConvenioController;
import controller.Especialidade.EspecialidadeController;
import controller.Medico.MedicoController;
import controller.Paciente.PacienteController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
