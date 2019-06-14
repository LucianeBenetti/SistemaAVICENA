package Servlets.Consulta;

import controller.Convenio.ConvenioController;
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
import model.vo.Convenio.ConvenioVO;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class PesquisarMedicoEspecialidadeConvenioConsulta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        ArrayList<EspecializacaoVO> listaEspecializacoes = new ArrayList<EspecializacaoVO>();

        MedicoVO medicoVO = new MedicoVO();
        EspecialidadeVO especialidadeVO = new EspecialidadeVO();

        List<EspecialidadeVO> listaEspecialidades = null;
        List<MedicoVO> listaMedicos = null;

        MedicoController medicoController = new MedicoController();
        listaMedicos = medicoController.listarTodosOsMedicosVO();

        for (int i = 0; i < listaMedicos.size(); i++) {
            medicoVO.setCodigoMedico(listaMedicos.get(i).getCodigoMedico());
            especializacaoVO.setMedicoVO(medicoVO);
        }

        EspecialidadeController especialidadeController = new EspecialidadeController();
        listaEspecialidades = especialidadeController.listarTodasAsEspecialidadesVO();

        for (int i = 0; i < listaEspecialidades.size(); i++) {
            especialidadeVO.setCodigoEspecialidade(listaEspecialidades.get(i).getCodigoEspecialidade());
            especialidadeVO.setInstituicao(listaEspecialidades.get(i).getInstituicao());

            especializacaoVO.setEspecialidadeVO(especialidadeVO);

            listaEspecializacoes.add(especializacaoVO);
          

        }

        ConvenioController convenioController = new ConvenioController();
        ArrayList<ConvenioVO> conveniosVO = convenioController.listarTodosOsConveniosVO();

        request.setAttribute("listaMedicosEspecialidadesVO", listaEspecializacoes);
        request.setAttribute("convenios", conveniosVO);
      
        request.getRequestDispatcher("Consulta/CadastrarConsulta.jsp").forward(request, response);

    }

//        ConvenioController covenioController = new ConvenioController();
//        ArrayList<ConvenioVO> listaConveniosVO = new ArrayList<ConvenioVO>();
//
//        listaConveniosVO = covenioController.listarTodosOsConveniosVO();
//        if (listaConveniosVO != null) {
//
//            request.setAttribute("listaconveniosvo", listaConveniosVO);
//
//        }
//        String buscarEspecialidades = request.getParameter("buscarEspecialidades");
//
//        EspecialidadeController especialidadeController = new EspecialidadeController();
//        ArrayList<EspecialidadeVO> listaEspecialidadesVO = new ArrayList<EspecialidadeVO>();
//
//        listaEspecialidadesVO = especialidadeController.listarTodasAsEspecialidadesVO();
//
//        if (listaEspecialidadesVO != null) {
//            request.setAttribute("listaEspecialidadesVO", listaEspecialidadesVO);
//        }
//
//        MedicoController medicoController = new MedicoController();
//        ArrayList<MedicoVO> listaMedicosVO = new ArrayList<MedicoVO>();
//
//        listaMedicosVO = medicoController.listarTodosOsMedicosVO();
//
//        if (listaMedicosVO != null) {
//            request.setAttribute("listaMedicosVO", listaMedicosVO);
//        }
//        System.out.print(listaConveniosVO);
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
