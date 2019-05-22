/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Especializacao;

import controller.Especializacao.EspecializacaoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Especializacao.EspecializacaoVO;

/**
 *
 * @author 80130917
 */
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
        System.out.println("O array é: " + variavel);

        EspecializacaoVO especializacaoVO = null;

        for (int i = 0; i < variavel.size(); i++) {
            String var = variavel.get(i);

            if (var != null) {
                switch (var) {
                    case "cadastrar":

                        System.out.println("A variável é: " + variavel.get(i));
                        especializacaoVO = new EspecializacaoVO();
                        especializacaoVO.getEspecialidadeVO().setCodigoEspecialidade(Integer.parseInt(request.getParameter("idespecialidade")));
                        especializacaoVO.getMedicoVO().setCodigoMedico(Integer.parseInt(request.getParameter("idmedico")));
                        especializacaoVO.setAnoEspecializacao(request.getParameter("anoespecializacao"));

                        System.out.println(especializacaoVO);

                        especializacaoController = new EspecializacaoController();

                        int novoId = especializacaoController.cadastrarEspecializacaoVO(especializacaoVO);
                        Boolean resultadoDoCadastro = false;

                        if ((novoId > 0) && (especializacaoVO.getEspecialidadeVO().getCodigoEspecialidade() != 0) && (especializacaoVO.getMedicoVO().getCodigoMedico() != 0)) {

                            request.setAttribute("idespecializacao", novoId);
                            request.setAttribute("nomespecialidade", especializacaoVO.getEspecialidadeVO().getNomeEspecialidade());
                            request.setAttribute("instituicaoespecialidade", especializacaoVO.getEspecialidadeVO().getInstituicao());
                            request.setAttribute("nomemedico", especializacaoVO.getMedicoVO().getNomeMedico());
                            request.setAttribute("anoespecializacao", especializacaoVO.getAnoEspecializacao());

                            resultadoDoCadastro = true;

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

                        especializacaoController = new EspecializacaoController();
                        if (especializacaoController.excluirEspecializacaoPorId(especializacaoVO.getCodigoEspecializacao())) {

                            request.setAttribute("nomespecialidade", especializacaoVO.getEspecialidadeVO().getNomeEspecialidade());
                            request.setAttribute("instituicaoespecialidade", especializacaoVO.getEspecialidadeVO().getInstituicao());
                            request.setAttribute("nommedico", especializacaoVO.getMedicoVO().getNomeMedico());
                            request.setAttribute("instituicaoespecializacao", especializacaoVO.getEspecialidadeVO().getInstituicao());
                            request.getRequestDispatcher("Especializacao/MostrarEspecializacaoExcluida.jsp").forward(request, response);
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
