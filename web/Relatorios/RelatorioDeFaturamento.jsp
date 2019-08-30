<%@page import="model.vo.Consulta.ConsultaVO"%>
<%@page import="model.vo.Convenio.ConvenioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>    
        <meta charset= "utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link type="text/css" rel="stylesheet" href="Relatorios/CRUDRelatorio.css">
        <link type="text/css" rel="stylesheet" href="CRUDRelatorio.css">
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datainicial").datepicker({dateFormat: 'dd/mm/yy'});
            });
            $(function () {
                $("#datafinal").datepicker({dateFormat: 'dd/mm/yy'});
            });
        </script>
        <title>Sistema Avicena</title> 
    </head>
    <body class="body">  
        <div class="form1">
            <h2>Pesquisar Datas para Relatório de Faturamento!</h2>

            <form method="post" action="../pesquisarconsultapordata">
                <fieldset>
                    <br />
                    <div style="width:55%">
                        <div style="float:left"> Data Inicial: </div>
                        <div style="float:right"> Data Final: </div>
                    </div>
                    <br>
                    <div style="width:69%">
                        <div style="float:left"> <input type="text" name="datainicial" id="datainicial" size="20" required></div>    
                        <div style="float:right"> <input type="text" name="datafinal" id="datafinal" size="20" required></div>        
                    </div>
                    <br /><br />
                    <input type="submit" value = "Buscar Período Selecionado">  
                    <br /><br />
                </fieldset>
            </form>
        </div>

        <form action="gerarrelatorioconsultasporconvenio" method="post">

            <div class="resultadodaconsultaNome">

                <%
                    Object consultas = request.getAttribute("listaconsultas");
                    ArrayList<ConsultaVO> consultasVO = (ArrayList<ConsultaVO>) consultas;
                    if (consultasVO != null) {%>

                <h2>Relatório de Consultas</h2>

                <table id="tabelaConsulta">
                    <tr>
                        <th>Id</th>
                        <th>Nome do Paciente</th> 
                        <th>Nome do Médico</th> 
                        <th>Especialidade</th>
                        <th>Convenio</th>
                        <th>Data da Consulta</th>
                        <th>Horário da Consulta</th>
                    </tr>        
                    <% for (ConsultaVO consultaVO : consultasVO) {%>  

                    <tr onclick="clickAtualizarConsulta(this)">
                        <td><%= consultaVO.getCodigoConsulta()%></td>
                        <td hidden><%= consultaVO.getPacienteVO().getCodigoPaciente()%></td>
                        <td><%= consultaVO.getPacienteVO().getNomePaciente()%></td>
                        <td hidden><%= consultaVO.getEspecializacaoVO().getCodigoEspecializacao()%></td>
                        <td><%= consultaVO.getEspecializacaoVO().getMedicoVO().getNomeMedico()%></td>
                        <td><%= consultaVO.getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade()%></td>
                        <td hidden><%= consultaVO.getConvenioVO().getCodigoConvenio()%></td>
                        <td><%= consultaVO.getConvenioVO().getNomeConvenio()%></td>
                        <td ><%= consultaVO.getDataConsulta()%></td>
                        <td ><%= consultaVO.getHorarioConsulta()%></td>
                    </tr>     
                    <% }  %>
                </table>
                <br><br>

                <input type="hidden" id="gerarrelatorio" name="gerarrelatorio" value="gerarrelatorio">
                <input type="submit" value="Gerar Relatório">
            </div>

            <%  }%>      
            <div >

            </div>
        </form><br><br>         

    </body>
</html>
