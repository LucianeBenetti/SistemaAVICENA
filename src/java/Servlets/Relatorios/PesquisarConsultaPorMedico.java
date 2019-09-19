package Servlets.Relatorios;

import controller.Consulta.ConsultaController;
import controller.Convenio.ConvenioController;
import controller.Especializacao.EspecializacaoController;
import controller.Medico.MedicoController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vo.Consulta.ConsultaVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class PesquisarConsultaPorMedico extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object usuarioValidado = request.getSession().getAttribute("perfil");

        ConsultaVO consultaVO = new ConsultaVO();

        MedicoVO medicoVO = new MedicoVO();
        List<MedicoVO> listaMedicos = null;
        medicoVO.setNomeMedico(request.getParameter("medicoselecionado"));
        MedicoController medicoController = new MedicoController();
        listaMedicos = medicoController.listarTodosOsMedicosVO();
        Boolean resultadoDaPesquisaDeConsultas = false;
        for (int i = 0; i < listaMedicos.size(); i++) {
            if (medicoVO.getNomeMedico().equals(listaMedicos.get(i).getNomeMedico())) {
                medicoVO.setCodigoMedico(listaMedicos.get(i).getCodigoMedico());
            }

        }
        if (medicoVO != null) {

            int codigoMedico = medicoVO.getCodigoMedico();

            List<EspecializacaoVO> listaEspecializacoes = null;
            EspecializacaoController especializacaoController = new EspecializacaoController();
            listaEspecializacoes = especializacaoController.pesquisarEspecializacaoPorIdDoMedico(codigoMedico);
            List<ConsultaVO> listaConsultas = null;

            ConsultaController consultaController = new ConsultaController();

            for (int i = 0; i < listaEspecializacoes.size(); i++) {
                int codigoEspecializacao = listaEspecializacoes.get(i).getCodigoEspecializacao();

                listaConsultas = consultaController.listarConsultasVOPorMedico(codigoEspecializacao);
            }

            if (listaConsultas.size() > 0) {

                HttpSession session = request.getSession();
                session.setAttribute("listadeconsultas", listaConsultas);
                session.setAttribute("medicovo", medicoVO);
                request.setAttribute("listadeconsultas", listaConsultas);
                request.getRequestDispatcher("Relatorios/RelatorioDeConsultaPorMedico.jsp").forward(request, response);

            } else {
                request.setAttribute("resultadotransacao", resultadoDaPesquisaDeConsultas);
                if (usuarioValidado.equals("admin")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
                } else if (usuarioValidado.equals("atendente")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
                } else if (usuarioValidado.equals("medico")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialMedico.jsp").forward(request, response);
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
