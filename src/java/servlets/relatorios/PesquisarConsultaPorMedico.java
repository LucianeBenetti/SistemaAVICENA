package servlets.relatorios;

import controller.consulta.ConsultaController;
import controller.medico.MedicoController;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vo.consulta.ConsultaVO;
import model.vo.medico.MedicoVO;

public class PesquisarConsultaPorMedico extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object usuarioValidado = request.getSession().getAttribute("perfil");
        MedicoVO medicoVO = new MedicoVO();
        medicoVO.setNomeMedico(request.getParameter("medicoselecionado"));
        MedicoController medicoController = new MedicoController();
        List<MedicoVO> listaMedicos = medicoController.listarTodosOsMedicosVO();
        Boolean resultadoDaPesquisaDeConsultas = false;
        List<ConsultaVO> listaConsultas = null;
        int codigoMedico = 0;
        ConsultaController consultaController = new ConsultaController();

        for (int i = 0; i < listaMedicos.size(); i++) {
            if (medicoVO.getNomeMedico().equals(listaMedicos.get(i).getNomeMedico())) {
                medicoVO.setCodigoMedico(listaMedicos.get(i).getCodigoMedico());
            }

        }
        if (medicoVO != null) {

            codigoMedico = medicoVO.getCodigoMedico();

            listaConsultas = consultaController.listarTodasAsConsultasVO();
        }
        if (listaConsultas != null) {
            for (int i = 0; i < listaConsultas.size(); i++) {
                int codigoMedicoConsulta = listaConsultas.get(i).getEspecializacaoVO().getMedicoVO().getCodigoMedico();
                listaConsultas = consultaController.listarConsultasVOPorMedico(codigoMedico);
                if (codigoMedico == listaConsultas.get(i).getEspecializacaoVO().getMedicoVO().getCodigoMedico()) {

                    HttpSession session = request.getSession();
                    session.setAttribute("listadeconsultas", listaConsultas);
                    session.setAttribute("medicovo", medicoVO);
                    request.setAttribute("listadeconsultas", listaConsultas);
                    request.getRequestDispatcher("relatorios/RelatorioDeConsultaPorMedico.jsp").forward(request, response);

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
