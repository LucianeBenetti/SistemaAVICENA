package Servlets.Relatorios;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GerarReceitaPDF {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nomePaciente = request.getParameter("nomepaciente");
        String medicamentos = request.getParameter("medicamentos");
        String exames = request.getParameter("exames");
        String registros = request.getParameter("registro");
        // criação do documento
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream("D:\\SENAC\\PDF_Teste.pdf"));
            document.open();
            // adicionando um parágrafo no documento

            document.add(new Paragraph("Receita Médica"));
            document.add(new Paragraph(nomePaciente));
            document.add(new Paragraph(medicamentos));
            document.add(new Paragraph(exames));
            document.add(new Paragraph(registros));

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
   
        try {

            PdfWriter.getInstance(document, new FileOutputStream("D:\\SENAC\\PDF_Teste.pdf"));
            document.open();
            // adicionando um parágrafo no documento
            
            
            document.add(new Paragraph("Gerando PDF - Java"));
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
    }

}
