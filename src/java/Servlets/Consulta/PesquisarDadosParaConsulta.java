package Servlets.Consulta;

import controller.Convenio.ConvenioController;
import controller.Especialidade.EspecialidadeController;
import controller.Medico.MedicoController;
import controller.Paciente.PacienteController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vo.Convenio.ConvenioVO;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;
import model.vo.Paciente.PacienteVO;

public class PesquisarDadosParaConsulta extends HttpServlet {

    PacienteVO pacienteVO = new PacienteVO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        ArrayList<EspecializacaoVO> listaEspecializacoes = new ArrayList<EspecializacaoVO>();

        MedicoVO medicoVO = new MedicoVO();
        EspecialidadeVO especialidadeVO = new EspecialidadeVO();

        List<EspecialidadeVO> listaEspecialidades = null;
        List<MedicoVO> listaMedicos = null;

        MedicoController medicoController = new MedicoController();
        listaMedicos = medicoController.listarTodosOsMedicosVO();

        for (int i = 0; i < listaMedicos.size(); i++) {
            medicoVO.setCodigoMedico(listaMedicos.get(i).getCodigoMedico());
            especializacaoVO.setMedicoVO(medicoVO);
        }

        EspecialidadeController especialidadeController = new EspecialidadeController();
        listaEspecialidades = especialidadeController.listarTodasAsEspecialidadesVO();

        for (int i = 0; i < listaEspecialidades.size(); i++) {
            especialidadeVO.setCodigoEspecialidade(listaEspecialidades.get(i).getCodigoEspecialidade());
            especialidadeVO.setInstituicao(listaEspecialidades.get(i).getInstituicao());

            especializacaoVO.setEspecialidadeVO(especialidadeVO);

            listaEspecializacoes.add(especializacaoVO);
          

        }

        ConvenioController convenioController = new ConvenioController();
        ArrayList<ConvenioVO> conveniosVO = convenioController.listarTodosOsConveniosVO();

        request.setAttribute("listaMedicosEspecialidadesVO", listaEspecializacoes);
        request.setAttribute("convenios", conveniosVO);
      
        pacienteVO.setCpfPaciente(request.getParameter("cpfpaciente"));
        PacienteController pacientecontroller = new PacienteController();
        Boolean resultadoDaPesquisaPorCpf = false;
        pacienteVO = pacientecontroller.pesquisarPacienteVOPorCpf(pacienteVO.getCpfPaciente());

        if (pacienteVO != null) {
            resultadoDaPesquisaPorCpf = true;
            request.setAttribute("codigopaciente", pacienteVO.getCodigoPaciente());
            request.setAttribute("nomepaciente", pacienteVO.getNomePaciente());
            request.setAttribute("pacientevoretornado", resultadoDaPesquisaPorCpf);
            request.getRequestDispatcher("Consulta/CadastrarConsulta.jsp").forward(request, response);
   
        } else {
            System.out.println("O paciente não foi encontrado!");
            request.setAttribute("pacientevoretornado", resultadoDaPesquisaPorCpf);
            request.getRequestDispatcher("Consulta/CadastrarConsulta.jsp").forward(request, response);
        }

    }

}
