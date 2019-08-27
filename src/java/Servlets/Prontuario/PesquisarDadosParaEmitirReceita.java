package Servlets.Prontuario;

import controller.Prontuario.ReceitaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Consulta.ConsultaVO;
import model.vo.Prontuario.ProntuarioVO;
import model.vo.Prontuario.ReceitaVO;

public class PesquisarDadosParaEmitirReceita extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Object listaConsultas = request.getSession().getAttribute("listaconsultas");
        Object codPaciente = request.getSession().getAttribute("codigopaciente");
        Object paciente = request.getSession().getAttribute("nomepaciente");

        int codigoPaciente = new Integer((int) codPaciente);
        String nomePaciente = new String((String) paciente);
        int codigoConsulta = 0;
        int codigoEspecializacao = 0;
        String nomeMedico = null;
        String especialidade = null;
        String dataConsulta = null;
        String horarioConsulta = null;

        if (listaConsultas != null) {

            List<ReceitaVO> listaReceitas = new ArrayList<ReceitaVO>();
            ArrayList<ConsultaVO> listaConsultasVO = (ArrayList<ConsultaVO>) listaConsultas;

            ReceitaController receitaController = new ReceitaController();
            for (int i = 0; i < listaConsultasVO.size(); i++) {

                codigoConsulta = listaConsultasVO.get(i).getCodigoConsulta();
                listaReceitas = receitaController.buscarReceitasPorConsulta(codigoConsulta);

//                codigoEspecializacao = listaConsultasVO.get(i).getEspecializacaoVO().getCodigoEspecializacao();
//                nomeMedico = listaConsultasVO.get(i).getEspecializacaoVO().getMedicoVO().getNomeMedico();
//                especialidade = listaConsultasVO.get(i).getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade();
//                dataConsulta = listaConsultasVO.get(i).getDataConsulta();
//                horarioConsulta = listaConsultasVO.get(i).getHorarioConsulta();
//
//                request.setAttribute("codigoconsulta", codigoConsulta);
//                request.setAttribute("codigoespecializacao", codigoEspecializacao);
//                request.setAttribute("nomemedico", nomeMedico);
//                request.setAttribute("especialidade", especialidade);
//                request.setAttribute("dataconsulta", dataConsulta);
//                request.setAttribute("horarioconsulta", horarioConsulta);
            }
            }
//        request.setAttribute("nomepaciente", nomePaciente);
//        request.setAttribute("codigoPaciente", codigoPaciente);
            request.getRequestDispatcher("Prontuario/EmitirReceita.jsp").forward(request, response);
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
