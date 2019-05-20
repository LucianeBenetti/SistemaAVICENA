package Servlets.Medico;

import controller.Medico.MedicoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Medico.MedicoVO;

public class CrudMedico extends HttpServlet {

    MedicoVO medicoVO;
    MedicoController medicoController;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String var1 = request.getParameter("cadastrar");
        String var2 = request.getParameter("excluir");
        //String cpf = request.getParameter("cpfmedico");

        //System.out.println("O cpf é: " + cpf);
        ArrayList<String> variavel = new ArrayList<String>();
        variavel.add(var1);
        variavel.add(var2);
        System.out.println("O array é: " + variavel);

        MedicoVO medicoVO = null;

        for (int i = 0; i < variavel.size(); i++) {
            String var = variavel.get(i);

            if (var != null) {
                switch (var) {
                    case "cadastrar":

                        System.out.println("A variável é: " + variavel.get(i));
                        medicoVO = new MedicoVO();
                        medicoVO.setNomeMedico(request.getParameter("nomemedico"));
                        medicoVO.setCrm(request.getParameter("crm"));
                        medicoVO.setCelMensagemMedico(request.getParameter("celularwhats"));
                        medicoVO.setCelularMedico(request.getParameter("celularmedico"));
                        medicoVO.setEmailMedico(request.getParameter("email"));
                        medicoVO.setCpfMedico(request.getParameter("cpfmedico"));
                        medicoVO.setCnpjMedico(request.getParameter("cnpjmedico"));

                        System.out.println(medicoVO);

                        medicoController = new MedicoController();

                        int novoId = medicoController.cadastrarMedicoVO(medicoVO);
                        Boolean resultadoDoCadastro = false;
                       
                        if (novoId > 0) {

                            request.setAttribute("idmedico", novoId);
                            request.setAttribute("nomemedico", medicoVO.getNomeMedico());
                            request.setAttribute("crm", medicoVO.getCrm());
                            request.setAttribute("celularwhats", medicoVO.getCelMensagemMedico());
                            request.setAttribute("celularmedico", medicoVO.getCelularMedico());
                            request.setAttribute("email", medicoVO.getEmailMedico());
                            request.setAttribute("cpfmedico", medicoVO.getCpfMedico());
                            request.setAttribute("cnpjmedico", medicoVO.getCnpjMedico());

                            resultadoDoCadastro = true;

                            request.setAttribute("medicocadastrado", resultadoDoCadastro);
                            request.getRequestDispatcher("Medico/MostrarMedicoCadastrado.jsp").forward(request, response);
                       
                        }else {
                            request.setAttribute("medicocadastrado", resultadoDoCadastro);
                            request.getRequestDispatcher("Medico/MostrarMedicoCadastrado.jsp").forward(request, response);
                        }
                        
                        break;

                    case "excluir":

                        medicoVO = new MedicoVO();
                        medicoVO.setCpfMedico(request.getParameter("cpfmedico"));

                        medicoController = new MedicoController();
                        if (medicoController.excluirMedicoPorCpf(medicoVO.getCpfMedico())) {

                            request.setAttribute("cpfmedico", medicoVO.getCpfMedico());
                            request.getRequestDispatcher("Medico/MostrarMedicoExcluido.jsp").forward(request, response);
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
