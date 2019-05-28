package Servlets.Especializacao;

import controller.Especialidade.EspecialidadeController;
import controller.Especializacao.EspecializacaoController;
import controller.Medico.MedicoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class CrudEspecializacao extends HttpServlet {

    EspecializacaoVO especializacaoVO;
    EspecializacaoController especializacaoController;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("cadastrar");
        String var2 = request.getParameter("excluir");

        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);

        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        ArrayList<EspecializacaoVO> listaEspecializacoes = new ArrayList<EspecializacaoVO>();

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
        }

        for (int i = 0; i < variavel.size(); i++) {
            String var = variavel.get(i);

            if (var != null) {
                switch (var) {
                    case "cadastrar":

                        System.out.println("A variável é: " + variavel.get(i));
                      //  especializacaoVO = new EspecializacaoVO();

                        especializacaoVO.getEspecialidadeVO().getCodigoEspecialidade();
                        especializacaoVO.getMedicoVO().getCodigoMedico();
                        especializacaoVO.setAnoEspecializacao(request.getParameter("anoespecializacao"));

                        System.out.println(especializacaoVO);

                        especializacaoController = new EspecializacaoController();

                        int novoId = especializacaoController.cadastrarEspecializacaoVO(especializacaoVO);
                        Boolean resultadoDoCadastro = false;

                        if ((novoId > 0) && (especializacaoVO.getEspecialidadeVO().getCodigoEspecialidade() != 0) && (especializacaoVO.getMedicoVO().getCodigoMedico() != 0)) {

                            request.setAttribute("codigoespecializacao", novoId);
                            request.setAttribute("nomeespecialidade", especializacaoVO.getEspecialidadeVO().getNomeEspecialidade());
                            request.setAttribute("instituicaoespecialidade", especializacaoVO.getEspecialidadeVO().getInstituicao());
                            request.setAttribute("nomemedico", especializacaoVO.getMedicoVO().getNomeMedico());
                            request.setAttribute("anoespecializacao", especializacaoVO.getAnoEspecializacao());

                            resultadoDoCadastro = true;
                            System.out.print(resultadoDoCadastro);
                            System.out.println("Servlets.Especializacao )" + especializacaoVO);

                            request.setAttribute("especializacaocadastrada", resultadoDoCadastro);
                            request.getRequestDispatcher("Especializacao/MostrarEspecializacaoCadastrada.jsp").forward(request, response);

                        } else {
                            request.setAttribute("especializacaocadastrada", resultadoDoCadastro);
                            request.getRequestDispatcher("Especializacao/MostrarEspecializacaoCadastrada.jsp").forward(request, response);
                        }

                        break;

                    case "excluir":

                        especializacaoVO = new EspecializacaoVO();
                        especializacaoVO.setCodigoEspecializacao(Integer.parseInt(request.getParameter("codigoespecializacao")));
                        Boolean resultadoDaExclusao = false;
                        especializacaoController = new EspecializacaoController();
                        if (especializacaoController.excluirEspecializacaoPorId(especializacaoVO.getCodigoEspecializacao())) {

                            request.setAttribute("nomeespecialidade", especializacaoVO.getEspecialidadeVO().getNomeEspecialidade());
                            request.setAttribute("instituicaoespecialidade", especializacaoVO.getEspecialidadeVO().getInstituicao());
                            request.setAttribute("nomemedico", especializacaoVO.getMedicoVO().getNomeMedico());
                            request.setAttribute("instituicaoespecializacao", especializacaoVO.getEspecialidadeVO().getInstituicao());
                            request.getRequestDispatcher("Especializacao/MostrarEspecializacaoExcluida.jsp").forward(request, response);
                        } else {
                            request.setAttribute("nomeespecialidade", resultadoDaExclusao);
                            request.getRequestDispatcher("Especializacao/MostrarEspecializacaoExcluida.jsp").forward(request, response);
                            request.setAttribute("nomemedico", especializacaoVO.getMedicoVO().getNomeMedico());

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
