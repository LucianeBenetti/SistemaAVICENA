package servlets.receita;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import controller.receita.ReceitaController;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.consulta.ConsultaVO;
import model.vo.paciente.PacienteVO;
import model.vo.receita.ReceitaVO;

public class EmitirReceita extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ReceitaVO receitaVO;
        ReceitaController receitaController;
        ArrayList<ReceitaVO> listaReceitas = null;
        Object usuarioValidado = request.getSession().getAttribute("perfil");

        PacienteVO pacienteVO = new PacienteVO();
        ConsultaVO consultaVO = new ConsultaVO();
        String nomePaciente = request.getParameter("nomepaciente");
        int codigoPaciente = new Integer(request.getParameter("codigopaciente"));
        pacienteVO.setCodigoPaciente(codigoPaciente);
        int codigoConsulta = new Integer(request.getParameter("codigoconsulta"));
        consultaVO.setCodigoConsulta(codigoConsulta);
        String medicamentos = request.getParameter("medicamentos");
        String exames = request.getParameter("exames");
        String registros = request.getParameter("registroobservacao");

        receitaVO = new ReceitaVO();
        receitaVO.setConsultaVO(consultaVO);
        receitaVO.setMedicamento(request.getParameter("medicamentos"));
        receitaVO.setExame(request.getParameter("exames"));
        receitaVO.setObservacao(request.getParameter("registroobservacao"));

        receitaController = new ReceitaController();
        listaReceitas = (ArrayList<ReceitaVO>) receitaController.buscarReceitasPorConsulta(codigoConsulta);

        Boolean resultadoDoCadastro = false;
        receitaController.cadastrarReceitaVO(receitaVO);

        // criação do documento
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream("C:\\SENAC\\Receita.pdf"));
            document.open();
            // adicionando um parágrafo no documento

            Image figura = Image.getInstance("C:\\SENAC\\coracao.png");
            document.add(figura);
            Paragraph pTitulo = new Paragraph(new Phrase(20F, "AVICENA - Medicina Humanizada", FontFactory.getFont(FontFactory.HELVETICA, 18F)));
            pTitulo.setAlignment(Element.ALIGN_CENTER);
            document.add(pTitulo);
            Paragraph pSubTitulo = new Paragraph(new Phrase("Receita Médica", FontFactory.getFont(FontFactory.HELVETICA, 16F)));
            pSubTitulo.setAlignment(Element.ALIGN_CENTER);
            document.add(pSubTitulo);
            document.add(new Paragraph("\n\n"));
            document.add(new Paragraph("Paciente: " + nomePaciente + "\n\n"));
            document.add(new Paragraph("Solicitação de Medicamentos: "));
            document.add(new Paragraph(medicamentos + "\n\n"));
            document.add(new Paragraph("Solicitação de Exames: "));
            document.add(new Paragraph(exames + "\n\n"));
            document.add(new Paragraph("Observações: "));
            document.add(new Paragraph(registros + "\n\n"));

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();

        Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "C://SENAC//Receita.pdf"});

        request.setAttribute("codigoPaciente", codigoPaciente);
        request.setAttribute("nomepaciente", nomePaciente);
        request.setAttribute("medicamentos", receitaVO.getMedicamento());
        request.setAttribute("exames", receitaVO.getExame());
        request.setAttribute("registro", receitaVO.getObservacao());
        resultadoDoCadastro = true;
        request.setAttribute("resultadotransacao", resultadoDoCadastro);
        if (usuarioValidado.equals("admin")) {
            request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
        } else if (usuarioValidado.equals("medico")) {
            request.getRequestDispatcher("WEB-INF/PaginaInicialMedico.jsp").forward(request, response);
        }
    }

}
