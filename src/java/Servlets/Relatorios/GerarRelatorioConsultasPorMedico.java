package Servlets.Relatorios;

import Servlets.Consulta.CadastrarConsulta;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

        Object usuarioValidado = request.getSession().getAttribute("perfil");
        Boolean resultadoEmissaoRelatorio = true;
        Object listaconsultas = request.getSession().getAttribute("listadeconsultas");
        ArrayList<ConsultaVO> consultas = (ArrayList<ConsultaVO>) listaconsultas;
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("C:\\SENAC\\RelatorioMedico.pdf"));
        document.open();

        Image figura = Image.getInstance("C:\\SENAC\\coracao.png");
        document.add(figura);
        Paragraph pTitulo = new Paragraph(new Phrase(20F, "AVICENA - Medicina Humanizada", FontFactory.getFont(FontFactory.HELVETICA, 18F)));
        pTitulo.setAlignment(Element.ALIGN_CENTER);
        document.add(pTitulo);
        Paragraph pSubTitulo = new Paragraph(new Phrase("Relatório de Consultas por Médico", FontFactory.getFont(FontFactory.HELVETICA, 16F)));
        pSubTitulo.setAlignment(Element.ALIGN_CENTER);
        document.add(pSubTitulo);
        document.add(new Paragraph("\n\n"));

        PdfPTable table = new PdfPTable(new float[]{7f, 7f, 5f, 7f, 7f});
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

        //ConsultaVO consultaVO = new ConsultaVO();
        for (int i = 0; i < consultas.size(); i++) {
            Calendar c = Calendar.getInstance();
            c.setTime(consultas.get(i).getDataConsulta());
            Date dataSQL = new Date(c.getTimeInMillis());

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String dataFormatada = dateFormat.format(dataSQL);

            PdfPCell celula1 = new PdfPCell(new Phrase(consultas.get(i).getEspecializacaoVO().getMedicoVO().getNomeMedico()));
            celula1.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celula2 = new PdfPCell(new Phrase(dataFormatada));
            celula2.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celula3 = new PdfPCell(new Phrase(consultas.get(i).getHorarioConsulta()));
            celula3.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celula4 = new PdfPCell(new Phrase(consultas.get(i).getPacienteVO().getNomePaciente()));
            celula4.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell celula5 = new PdfPCell(new Phrase(consultas.get(i).getConvenioVO().getNomeConvenio()));
            celula5.setHorizontalAlignment(Element.ALIGN_CENTER);

            table.addCell(celula1);
            table.addCell(celula2);
            table.addCell(celula3);
            table.addCell(celula4);
            table.addCell(celula5);

        }
        document.add(table);
        document.close();
        Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "D://SENAC//RelatorioMedico.pdf"});
        if (usuarioValidado.equals("admin")) {
            request.setAttribute("resultadotransacao", resultadoEmissaoRelatorio);
            request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
        } else if (usuarioValidado.equals("atendente")) {
            request.setAttribute("resultadotransacao", resultadoEmissaoRelatorio);
            request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
        } else if (usuarioValidado.equals("medico")) {
            request.setAttribute("resultadotransacao", resultadoEmissaoRelatorio);
            request.getRequestDispatcher("WEB-INF/PaginaInicialMedico.jsp").forward(request, response);
        }
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
