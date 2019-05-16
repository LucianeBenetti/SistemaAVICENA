package Servlets.Paciente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Paciente.PacienteController;
import java.util.ArrayList;
import model.vo.Paciente.PacienteVO;

/**
 *
 * @author 80119050
 */
public class CrudPaciente extends HttpServlet {

    PacienteVO pacienteVO;
    PacienteController pacienteController;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("cadastrar");
        String var2 = request.getParameter("excluir");
        //String cpf = request.getParameter("cpfpaciente");

        //System.out.println("O cpf é: " + cpf);

        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);
        System.out.println("O array é: " + variavel);

        PacienteVO pacienteVO = null;

        for (int i = 0; i < variavel.size(); i++) {
            String var = variavel.get(i);

            if (var != null) {
                switch (var) {
                    case "cadastrar":

                     //   System.out.println("A variável é: " + variavel.get(i));
                        pacienteVO = new PacienteVO();
                        pacienteVO.setNomePaciente(request.getParameter("nomepaciente"));
                        pacienteVO.setCelMensagemPaciente(request.getParameter("celularpaciente"));
                        pacienteVO.setFoneResidencial(request.getParameter("foneresidencial"));
                        pacienteVO.setFoneComercial(request.getParameter("fonecomercial"));
                        pacienteVO.setEmailPaciente(request.getParameter("email"));
                        pacienteVO.setCpfPaciente(request.getParameter("cpfpaciente"));
                        pacienteVO.setCnpjPaciente(request.getParameter("cnpjpaciente"));
                        pacienteVO.setLogradouro(request.getParameter("logradouro"));
                        pacienteVO.setNumLogradouro(request.getParameter("numlogradouro"));
                        pacienteVO.setComplemento(request.getParameter("complemento"));
                        pacienteVO.setBairro(request.getParameter("bairro"));
                        pacienteVO.setCidade(request.getParameter("cidade"));
                        pacienteVO.setUf(request.getParameter("uf"));
                        pacienteVO.setCep(request.getParameter("cep"));

                        System.out.println(pacienteVO);

                        pacienteController = new PacienteController();

                        int novoId = pacienteController.cadastrarPacienteVO(pacienteVO);

                        if (novoId > 0) {

                            request.setAttribute("idpaciente", novoId);
                            request.setAttribute("nomepaciente", pacienteVO.getNomePaciente());
                            request.setAttribute("celularpaciente", pacienteVO.getCelMensagemPaciente());
                            request.setAttribute("foneresidencial", pacienteVO.getFoneResidencial());
                            request.setAttribute("fonecomercial", pacienteVO.getFoneComercial());
                            request.setAttribute("email", pacienteVO.getEmailPaciente());
                            request.setAttribute("cpfpaciente", pacienteVO.getCpfPaciente());
                            request.setAttribute("cnpjpaciente", pacienteVO.getCnpjPaciente());
                            request.setAttribute("logradouro", pacienteVO.getLogradouro());
                            request.setAttribute("numlogradouro", pacienteVO.getNumLogradouro());
                            request.setAttribute("complemento", pacienteVO.getComplemento());
                            request.setAttribute("bairro", pacienteVO.getBairro());
                            request.setAttribute("cidade", pacienteVO.getCidade());
                            request.setAttribute("uf", pacienteVO.getUf());
                            request.setAttribute("cep", pacienteVO.getCep());

                            request.getRequestDispatcher("Paciente/MostrarPacienteCadastrado.jsp").forward(request, response);
                        }
                        break;

                    case "excluir":
                       
                        pacienteVO = new PacienteVO();
                        pacienteVO.setCpfPaciente(request.getParameter("cpfpaciente"));                        

                        pacienteController = new PacienteController();
                        if (pacienteController.excluirPacientePorCpf(pacienteVO.getCpfPaciente())) {

                            request.setAttribute("cpfpaciente", pacienteVO.getCpfPaciente());
                            request.getRequestDispatcher("Paciente/MostrarPacienteExcluido.jsp").forward(request, response);
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
