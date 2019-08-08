package Servlets.Consulta;

import controller.Consulta.ConsultaController;
import controller.Especialidade.EspecialidadeController;
import controller.Medico.MedicoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Consulta.ConsultaVO;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class CrudConsulta extends HttpServlet {

    ConsultaVO consultaVO;
    ConsultaController consultaController;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("cadastrar");
        String var2 = request.getParameter("excluir");

        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);
        System.out.println("O array é: " + variavel);
        
        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        MedicoVO medicoVO = new MedicoVO();
        EspecialidadeVO especialidadeVO = new EspecialidadeVO();
        List<EspecialidadeVO> listaEspecialidades = null;
        List<MedicoVO> listaMedicos = null;

        medicoVO.setNomeMedico(request.getParameter("nomemedico"));
        MedicoController medicoController = new MedicoController();
        listaMedicos = medicoController.listarTodosOsMedicosVO();

        for (int i = 0; i < listaMedicos.size(); i++) {
            if (medicoVO.getNomeMedico().equals(listaMedicos.get(i).getNomeMedico())) {
                medicoVO.setCodigoMedico(listaMedicos.get(i).getCodigoMedico());
                especializacaoVO.setMedicoVO(medicoVO);
            }
        }
        especialidadeVO.setNomeEspecialidade(request.getParameter("nomeespecialidade"));
        EspecialidadeController especialidadeController = new EspecialidadeController();
        listaEspecialidades = especialidadeController.listarTodasAsEspecialidadesVO();

        for (int i = 0; i < listaEspecialidades.size(); i++) {
            if (especialidadeVO.getNomeEspecialidade().equals(listaEspecialidades.get(i).getNomeEspecialidade())) {
                especialidadeVO.setCodigoEspecialidade(listaEspecialidades.get(i).getCodigoEspecialidade());
                especialidadeVO.setInstituicao(listaEspecialidades.get(i).getInstituicao());
                especializacaoVO.setEspecialidadeVO(especialidadeVO);
            }
        };

        ConsultaVO consultaVO = null;

        for (int i = 0; i < variavel.size(); i++) {
            String var = variavel.get(i);

            if (var != null) {
                switch (var) {
                    case "cadastrar":

                        System.out.println("A variável é: " + variavel.get(i));
                        consultaVO = new ConsultaVO();
                        consultaVO.setEspecializacaoVO(request.getParameter("codigoConsulta"));
                        consultaVO.setInstituicao(request.getParameter("instituicaoconsulta"));

                        consultaController = new ConsultaController();

                        int novoId = consultaController.cadastrarConsultaVO(consultaVO);
                        Boolean resultadoDoCadastro = false;

                        if ((novoId > 0)) {

                            request.setAttribute("idconsulta", novoId);
                            request.setAttribute("nomepaciente", consultaVO.getNomeConsulta());
                            request.setAttribute("convenio", consultaVO.getInstituicao());

                            resultadoDoCadastro = true;

                            request.setAttribute("consultacadastrada", resultadoDoCadastro);
                            request.getRequestDispatcher("Consulta/MostrarConsultaCadastrada.jsp").forward(request, response);

                        } else {
                            request.setAttribute("consultacadastrada", resultadoDoCadastro);
                            request.getRequestDispatcher("Consulta/MostrarConsultaCadastrada.jsp").forward(request, response);
                        }

                        break;

                    case "excluir":

                        consultaVO = new ConsultaVO();
                        consultaVO.setCodigoConsulta(Integer.parseInt(request.getParameter("codigoconsulta")));
                        Boolean resultadoDaExclusao = false;
                        consultaController = new ConsultaController();
                        if (consultaController.excluirConsultaPorId(consultaVO.getCodigoConsulta())) {

                            resultadoDaExclusao = true;
                            request.setAttribute("codigoconsulta", consultaVO.getCodigoConsulta());
                            request.getRequestDispatcher("Consulta/MostrarConsultaExcluida.jsp").forward(request, response);
                        } else {
                            request.setAttribute("nomeconsulta", resultadoDaExclusao);
                            request.getRequestDispatcher("Consulta/MostrarConsultaExcluida.jsp").forward(request, response);
                        }

                        break;

                    default:
                        request.getRequestDispatcher("crud").forward(request, response);
                        break;

                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
