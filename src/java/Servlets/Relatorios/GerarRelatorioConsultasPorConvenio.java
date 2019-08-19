package Servlets.Relatorios;

import controller.Consulta.ConsultaController;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFileChooser;
import model.vo.Consulta.ConsultaVO;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class GerarRelatorioConsultasPorConvenio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        Object listaconsultas = request.getSession().getAttribute("listaconsultas");
        ArrayList<ConsultaVO> consultas = (ArrayList<ConsultaVO>) listaconsultas;
        String[] columns = {"Nome", "Data Consulta", "Horario", "Convenio", "Medico"};
        HSSFWorkbook planilha = new HSSFWorkbook();

        // 1) Cria uma aba na planilha (nome é um parâmetro opcional)
        HSSFSheet abaPlanilha = planilha.createSheet("Consultas");
        Row headerRow = abaPlanilha.createRow(0);

        // 2) Cria o cabeçalho a partir de um array columns
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }
        // 3) Cria as linhas com os produtos da lista
        int rowNum = 1;
        String nomeConvenio = null;
        for (ConsultaVO consulta : consultas) {
            Row novaLinha = abaPlanilha.createRow(rowNum++);
            novaLinha.createCell(0).setCellValue(consulta.getPacienteVO().getNomePaciente());
            novaLinha.createCell(1).setCellValue(consulta.getDataConsulta());
            novaLinha.createCell(2).setCellValue(consulta.getHorarioConsulta());
            novaLinha.createCell(3).setCellValue(consulta.getConvenioVO().getNomeConvenio());
            novaLinha.createCell(4).setCellValue(consulta.getEspecializacaoVO().getMedicoVO().getNomeMedico());
            nomeConvenio = consulta.getConvenioVO().getNomeConvenio();
        }
        // 4) Ajusta o tamanho de todas as colunas conforme a largura do
        // conteúdo
        for (int i = 0; i < columns.length; i++) {
            abaPlanilha.autoSizeColumn(i);
        }
        //5) Escreve o arquivo em disco, no caminho informado
        FileOutputStream fileOut = null;
        File arquivoRelatorio = new File("C:\\SENAC\\Relatorio" + nomeConvenio + ".xls");
        try {
            fileOut = new FileOutputStream(arquivoRelatorio);
            // DataOutputStream abrirArquivo = new DataOutputStream(fileOut);
            //  abrirArquivo.writeBytes(planilha.toString());
            planilha.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOut != null) {
                try {
                    fileOut.close();
                    planilha.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.getRequestDispatcher("WEB-INF/PaginaInicial.jsp").forward(request, response);
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
