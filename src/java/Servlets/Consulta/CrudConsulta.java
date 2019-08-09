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

public class CrudConsulta extends HttpServlet {

    ConsultaVO consultaVO;
    ConsultaController consultaController;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("cadastrarconsulta");
        String var2 = request.getParameter("excluir");

        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);
        System.out.println("O array é: " + variavel);
        
        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        MedicoVO medicoVO = new MedicoVO();
        EspecialidadeVO especialidadeVO = new EspecialidadeVO();
        ConvenioVO convenioVO = new ConvenioVO();
        PacienteVO pacienteVO = new PacienteVO();
        List<EspecialidadeVO> listaEspecialidades = null;
        List<MedicoVO> listaMedicos = null;
               
      int codigoMedico = new Integer(request.getParameter("codigomedico"));
      int codigoEspecialidade = new Integer(request.getParameter("codigoespecialidade"));
      int codigoConvenio = new Integer(request.getParameter("codigoconvenio"));
      int codigoPaciente = new Integer(request.getParameter("codigopaciente"));

        medicoVO.setCodigoMedico(codigoMedico);
        MedicoController medicoController = new MedicoController();
        listaMedicos = medicoController.listarTodosOsMedicosVO();

        for (int i = 0; i < listaMedicos.size(); i++) {
                medicoVO.setCodigoMedico(listaMedicos.get(i).getCodigoMedico());
                especializacaoVO.setMedicoVO(medicoVO);
        }
        especialidadeVO.setCodigoEspecialidade(codigoEspecialidade);
        EspecialidadeController especialidadeController = new EspecialidadeController();
        listaEspecialidades = especialidadeController.listarTodasAsEspecialidadesVO();

        for (int i = 0; i < listaEspecialidades.size(); i++) {
                especialidadeVO.setCodigoEspecialidade(listaEspecialidades.get(i).getCodigoEspecialidade());
                especializacaoVO.setEspecialidadeVO(especialidadeVO);
        };  
        
//        Calendar c = Calendar.getInstance();
//	c.setTime(consultaVO.getDataConsulta());
//	Date dataSQL = new Date(c.getTimeInMillis());
                
//        Date dataConsulta = null;;
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//     
//     try {
//         dataConsulta = (Date) format.parse(request.getParameter("dataconsulta"));
//     } catch (ParseException ex) {
//         ex.printStackTrace();
//     }
        
        consultaVO = new ConsultaVO();
        consultaVO.setAtencaoEspecial(request.getParameter("atencaoEspecial"));
        consultaVO.setConvenioVO(convenioVO);
       // consultaVO.setDataConsulta(dataSQL);
        consultaVO.setEspecializacaoVO(especializacaoVO);
        consultaVO.setHorarioConsulta(request.getParameter("horaconsulta"));
        consultaVO.setPacienteVO(pacienteVO);
        
        for (int i = 0; i < variavel.size(); i++) {
            String var = variavel.get(i);

            if (var != null) {
                switch (var) {
                    case "cadastrarconsulta":

                        System.out.println("A variável é: " + variavel.get(i));
                        
                        consultaController = new ConsultaController();

                        int novoId = consultaController.cadastrarConsultaVO(consultaVO);
                        Boolean resultadoDoCadastro = false;

                        if ((novoId > 0)) {

                            request.setAttribute("idconsulta", novoId);
                            request.setAttribute("nomepaciente", consultaVO.getPacienteVO().getNomePaciente());
                            request.setAttribute("horarioConsulta", consultaVO.getHorarioConsulta());
                            request.setAttribute("dataConsulta", consultaVO.getDataConsulta());
                            request.setAttribute("nomeMedico", consultaVO.getEspecializacaoVO().getMedicoVO().getNomeMedico());
                            request.setAttribute("nomeEspecialidade", consultaVO.getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade());
                            request.setAttribute("atençãoEspecial", consultaVO.getAtencaoEspecial());
                          
                            resultadoDoCadastro = true;

                            request.setAttribute("consultacadastrada", resultadoDoCadastro);
                            request.getRequestDispatcher("Consulta/MostrarConsultaCadastrada.jsp").forward(request, response);

                        } else {
                            request.setAttribute("consultacadastrada", resultadoDoCadastro);
                            request.getRequestDispatcher("Consulta/MostrarConsultaCadastrada.jsp").forward(request, response);
                        }

                        break;

//                    case "excluir":
//
//                        consultaVO = new ConsultaVO();
//                        consultaVO.setCodigoConsulta(Integer.parseInt(request.getParameter("codigoconsulta")));
//                        Boolean resultadoDaExclusao = false;
//                        consultaController = new ConsultaController();
//                        if (consultaController.excluirConsultaPorId(consultaVO.getCodigoConsulta())) {
//
//                            resultadoDaExclusao = true;
//                            request.setAttribute("codigoconsulta", consultaVO.getCodigoConsulta());
//                            request.getRequestDispatcher("Consulta/MostrarConsultaExcluida.jsp").forward(request, response);
//                        } else {
//                            request.setAttribute("nomeconsulta", resultadoDaExclusao);
//                            request.getRequestDispatcher("Consulta/MostrarConsultaExcluida.jsp").forward(request, response);
//                        }
//
//                        break;

                    default:
                        request.getRequestDispatcher("crud").forward(request, response);
                        break;
                }
               
            }
        }
    }

       
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
