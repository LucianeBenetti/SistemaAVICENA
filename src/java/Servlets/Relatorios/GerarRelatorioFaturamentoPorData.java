package Servlets.Relatorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Consulta.ConsultaVO;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class GerarRelatorioFaturamentoPorData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Object listaDeConsultas = request.getSession().getAttribute("listadeconsultas");
        Boolean resultadoEmissaoRelatorio = true;
        ArrayList<ConsultaVO> consultas = (ArrayList<ConsultaVO>) listaDeConsultas;
        String[] columns = {"Nome", "Data Consulta", "Horario", "Convenio", "Valor", "Medico"};
        HSSFWorkbook planilha = new HSSFWorkbook();

        // 1) Cria uma aba na planilha (nome é um parâmetro opcional)
        HSSFSheet abaPlanilha = planilha.createSheet("Consultas");
        Row headerRow = abaPlanilha.createRow(0);

        CellStyle headerStyle = planilha.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        CellStyle textStyle = planilha.createCellStyle();
        textStyle.setAlignment(HorizontalAlignment.CENTER);
        textStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        // 2) Cria o cabeçalho a partir de um array columns
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerStyle);

        }

        // 3) Cria as linhas com os produtos da lista
        int rowNum = 1;
        for (ConsultaVO consulta : consultas) {

            Calendar c = Calendar.getInstance();
            c.setTime(consulta.getDataConsulta());
            Date dataSQL = new Date(c.getTimeInMillis());

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String dataFormatada = dateFormat.format(dataSQL);
            Row novaLinha = abaPlanilha.createRow(rowNum++);
            novaLinha.createCell(0).setCellValue(consulta.getPacienteVO().getNomePaciente());
            novaLinha.createCell(1).setCellValue(dataFormatada);
            novaLinha.createCell(2).setCellValue(consulta.getHorarioConsulta());
            novaLinha.createCell(3).setCellValue(consulta.getConvenioVO().getNomeConvenio());
            novaLinha.createCell(4).setCellValue(consulta.getValorConsulta());
            novaLinha.createCell(5).setCellValue(consulta.getEspecializacaoVO().getMedicoVO().getNomeMedico());
            novaLinha.setRowStyle(textStyle);
        }
        // 4) Ajusta o tamanho de todas as colunas conforme a largura do
        // conteúdo
        for (int i = 0; i < columns.length; i++) {
            abaPlanilha.autoSizeColumn(i);
        }
        //5) Escreve o arquivo em disco, no caminho informado
        FileOutputStream fileOut = null;
        File arquivoRelatorio = new File("C:\\SENAC\\RelatorioFaturamento.xls");
        try {
            fileOut = new FileOutputStream(arquivoRelatorio);
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
        Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "start", "D://SENAC//RelatorioFaturamento.xls"});
        request.setAttribute("resultadotransacao", resultadoEmissaoRelatorio);

        request.getRequestDispatcher("WEB-INF//PaginaInicialAdmin.jsp").forward(request, response);
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
