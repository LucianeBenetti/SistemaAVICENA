package Servlets.Relatorios;

import controller.Consulta.ConsultaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;
import model.vo.Consulta.ConsultaVO;

public class GerarRelatorioConsultasPorConvenio extends HttpServlet {

    private List<ConsultaVO> consultas;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Salvar relatório como...");

        int resultado = jfc.showSaveDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            String caminhoEscolhido = jfc.getSelectedFile().getAbsolutePath();

            ConsultaController consultaController = new ConsultaController();
            consultaController.gerarRelatorio(consultas, caminhoEscolhido, ConsultaController.TIPO_RELATORIO_XLS);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
