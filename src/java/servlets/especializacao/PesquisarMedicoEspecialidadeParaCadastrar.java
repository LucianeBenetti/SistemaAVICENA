package servlets.especializacao;

import controller.especialidade.EspecialidadeController;
import controller.medico.MedicoController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.especialidade.EspecialidadeVO;
import model.vo.especializacao.EspecializacaoVO;
import model.vo.medico.MedicoVO;

public class PesquisarMedicoEspecialidadeParaCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        ArrayList<EspecializacaoVO> listaEspecializacoes = new ArrayList<EspecializacaoVO>();

        MedicoVO medicoVO = new MedicoVO();
        EspecialidadeVO especialidadeVO = new EspecialidadeVO();

        List<EspecialidadeVO> listaEspecialidades = null;
        List<MedicoVO> listaMedicos = null;

        medicoVO.setNomeMedico(request.getParameter("medicoSelecionado"));
        MedicoController medicoController = new MedicoController();
        listaMedicos = medicoController.listarTodosOsMedicosVO();

        for (int i = 0; i < listaMedicos.size(); i++) {
            if (medicoVO.getNomeMedico().equals(listaMedicos.get(i).getNomeMedico())) {
                medicoVO.setCodigoMedico(listaMedicos.get(i).getCodigoMedico());
                especializacaoVO.setMedicoVO(medicoVO);
            }
        }

        especialidadeVO.setNomeEspecialidade(request.getParameter("especialidadeSelecionada"));
        EspecialidadeController especialidadeController = new EspecialidadeController();
        listaEspecialidades = especialidadeController.listarTodasAsEspecialidadesVO();

        for (int i = 0; i < listaEspecialidades.size(); i++) {
            if (especialidadeVO.getNomeEspecialidade().equals(listaEspecialidades.get(i).getNomeEspecialidade())) {
                especialidadeVO.setCodigoEspecialidade(listaEspecialidades.get(i).getCodigoEspecialidade());
                especialidadeVO.setInstituicao(listaEspecialidades.get(i).getInstituicao());
                especializacaoVO.setEspecialidadeVO(especialidadeVO);
                listaEspecializacoes.add(especializacaoVO);
            }
        }
        request.setAttribute("listaMedicosEspecialidadesVO", listaEspecializacoes);
        request.getRequestDispatcher("especializacao/CadastrarEspecializacao.jsp").forward(request, response);
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
