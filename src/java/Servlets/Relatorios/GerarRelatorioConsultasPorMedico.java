package Servlets.Relatorios;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Consulta.ConsultaVO;

public class GerarRelatorioConsultasPorMedico extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DocumentException {
        response.setContentType("text/html;charset=UTF-8");

        Object listaconsultas = request.getSession().getAttribute("listadeconsultas");
        ArrayList<ConsultaVO> consultas = (ArrayList<ConsultaVO>) listaconsultas;
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("D:\\SENAC\\RelatorioMedico.pdf"));
        document.open();

        PdfPTable table = new PdfPTable(new float[]{10f, 5f, 3f});
        PdfPCell celulaNomeMedico = new PdfPCell(new Phrase("Nome do Médico"));
        celulaNomeMedico.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell celulaDataConsulta = new PdfPCell(new Phrase("Data da Consulta"));
        celulaDataConsulta.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell celulaHorario = new PdfPCell(new Phrase("Horário"));
        celulaHorario.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell celulaNomePeciente = new PdfPCell(new Phrase("Nome Paciente"));
        celulaNomePeciente.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell celulaNomeConvenio = new PdfPCell(new Phrase("Convênio"));
        celulaNomeConvenio.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell(celulaNomeMedico);
        table.addCell(celulaDataConsulta);
        table.addCell(celulaHorario);
        table.addCell(celulaNomePeciente);
        table.addCell(celulaNomeConvenio);
        for (int i = 0; i < consultas.size(); i++) {
            PdfPCell celula1 = new PdfPCell(new Phrase(consultas.get(i).getCodigoConsulta()));
            PdfPCell celula2 = new PdfPCell(new Phrase(consultas.get(i).getDataConsulta()));
            PdfPCell celula3 = new PdfPCell(new Phrase(consultas.get(i).getHorarioConsulta()));
            PdfPCell celula4 = new PdfPCell(new Phrase(consultas.get(i).getPacienteVO().getNomePaciente()));
            PdfPCell celula5 = new PdfPCell(new Phrase(consultas.get(i).getConvenioVO().getNomeConvenio()));

            table.addCell(celula1);
            table.addCell(celula2);
            table.addCell(celula3);
            table.addCell(celula4);
            table.addCell(celula5);
            document.add(table);
        }
        document.close();

//         String nomePaciente = request.getParameter("nomepaciente");
//        String medicamentos = request.getParameter("medicamentos");
//        String exames = request.getParameter("exames");
//        String registros = request.getParameter("registro");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(GerarRelatorioConsultasPorMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(GerarRelatorioConsultasPorMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
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
