/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.Especializacao;

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
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class MostrarEspecializacaoPesquisada extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        List<EspecializacaoVO> especializacoesBuscadas = null;
        MedicoVO medicoVO = new MedicoVO();
        List<MedicoVO> listaMedicos = null;
        Boolean resultadoDaPesquisaPorNome = false;

        medicoVO.setNomeMedico(request.getParameter("medicoSelecionado"));
        MedicoController medicoController = new MedicoController();
        listaMedicos = medicoController.listarTodosOsMedicosVO();

        for (int i = 0; i < listaMedicos.size(); i++) {
            if (medicoVO.getNomeMedico().equals(listaMedicos.get(i).getNomeMedico())) {
                medicoVO.setCodigoMedico(listaMedicos.get(i).getCodigoMedico());
                especializacaoVO.setMedicoVO(medicoVO);
            }
        }
        EspecializacaoController especializacaocontroller = new EspecializacaoController();
        especializacoesBuscadas = especializacaocontroller.pesquisarEspecializacaoPorIdDoMedico(especializacaoVO.getMedicoVO().getCodigoMedico());

        if (especializacoesBuscadas != null) {

            System.out.println("buscada: " + especializacoesBuscadas);
            request.setAttribute("especializacoesBuscadas", especializacoesBuscadas);

            resultadoDaPesquisaPorNome = true;
            request.setAttribute("especializacaovoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("Especializacao/PesquisarEspecializacaoPorMedico.jsp").forward(request, response);

        } else {
            System.out.println("O especializacao não foi encontrada!");
            request.setAttribute("especializacaovoretornada", resultadoDaPesquisaPorNome);
            request.getRequestDispatcher("Especializacao/PesquisarEspecializacaoPorMedico.jsp").forward(request, response);
        }
        request.getRequestDispatcher("Especializacao/PesquisarEspecializacaoPorMedico.jsp").forward(request, response);

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
