package Servlets.Prontuario;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import controller.Prontuario.ReceitaController;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Consulta.ConsultaVO;
import model.vo.Paciente.PacienteVO;
import model.vo.Prontuario.ReceitaVO;

public class EmitirReceita extends HttpServlet {

    ReceitaVO receitaVO;
    ReceitaController receitaController;
    java.util.List<ReceitaVO> listaReceitas = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PacienteVO pacienteVO = new PacienteVO();
        ConsultaVO consultaVO = new ConsultaVO();
        String nomePaciente = request.getParameter("nomepaciente");
        int codigoPaciente = new Integer(request.getParameter("codigopaciente"));
        pacienteVO.setCodigoPaciente(codigoPaciente);
        int codigoConsulta = new Integer(request.getParameter("codigoconsulta"));
        consultaVO.setCodigoConsulta(codigoConsulta);
        String medicamentos = request.getParameter("medicamentos");
        String exames = request.getParameter("exames");
        String registros = request.getParameter("registro");

        receitaVO = new ReceitaVO();
        receitaVO.setConsultaVO(consultaVO);
        receitaVO.setMedicamento(request.getParameter("medicamentos"));
        receitaVO.setExame(request.getParameter("exames"));
        receitaVO.setObservacao(request.getParameter("registroobservacao"));

        receitaController = new ReceitaController();
        listaReceitas = receitaController.buscarReceitasPorConsulta(codigoConsulta);

        Boolean resultadoDoCadastro = false;
        receitaController.cadastrarReceitaVO(receitaVO);

        // criação do documento
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream("D:\\SENAC\\PDF_Teste.pdf"));
            document.open();
            // adicionando um parágrafo no documento

            document.addTitle("Receita Médica");
            document.add(new Paragraph("Paciente " + nomePaciente));
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            document.add(new Paragraph("Solicito Medicamentos: " + medicamentos));
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            document.add(new Paragraph("Solicitação de Exames: " + exames));
            document.add(new Paragraph(""));
            document.add(new Paragraph(""));
            document.add(new Paragraph("Observações: " + registros));

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();

        request.setAttribute("codigoPaciente", codigoPaciente);
        request.setAttribute("nomepaciente", nomePaciente);
        request.setAttribute("medicamentos", receitaVO.getMedicamento());
        request.setAttribute("exames", receitaVO.getExame());
        request.setAttribute("registro", receitaVO.getObservacao());
        resultadoDoCadastro = true;
        request.setAttribute("receitacadastrada", resultadoDoCadastro);
        request.getRequestDispatcher("Prontuario/MostrarReceitaCadastrada.jsp").forward(request, response);
    }

}
