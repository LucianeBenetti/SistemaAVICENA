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
        String registros = request.getParameter("registroobservacao");

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

            PdfWriter.getInstance(document, new FileOutputStream("D:\\SENAC\\Receita.pdf"));
            document.open();
            // adicionando um parágrafo no documento

            document.add(new Paragraph("Clínica AVICENA - Medicina Humanizada" + "\n\n"));
            document.add(new Paragraph("Receita Médica" + "\n\n"));
            document.add(new Paragraph("Paciente " + nomePaciente + "\n\n"));
            document.add(new Paragraph("Solicitação de Medicamentos: " + "\n\n"));
            document.add(new Paragraph(medicamentos + "\n\n"));
            document.add(new Paragraph("Solicitação de Exames: " + "\n\n"));
            document.add(new Paragraph(exames + "\n\n"));
            document.add(new Paragraph("Observações: " + "\n\n"));
            document.add(new Paragraph(registros + "\n\n"));
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
