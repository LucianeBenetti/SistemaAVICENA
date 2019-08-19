<%@page import="model.vo.Consulta.ConsultaVO"%>
<%@page import="model.vo.Convenio.ConvenioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>    
        <meta charset= "utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link type="text/css" rel="stylesheet" href="Relatorios/CRUDRelatorio.css">
        <link type="text/css" rel="stylesheet" href="CRUDRelatorio.css">
        <title>Sistema Avicena</title> 
    </head>
    <body class="body">  

        <div class="form1">
            <h2>Pesquisar Convênio por CNPJ!</h2>

            <form method="post" action="../pesquisarconsultaporconvenio">

                <fieldset><legend>Digite o CNPJ do Convênio a ser consultado na base de dados</legend>
                    <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                    CNPJ<a>*</a>:<br> 
                    <input type="text" name="cnpjconvenio" required onkeyup="maskIt(this, event, '##.###.###/####-##')"><br><br>
                    <input type="submit" value = "Pesquisar Convenio">                

                </fieldset>
            </form>
            <br><br>
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

                <input type="hidden" name="caminhoEscolhido" id="gerarrelatorio" name="gerarrelatorio" value="gerarrelatorio">

                <input type="submit" value="Gerar Relatório">
            </div>

            <%  }%>      
            <div >

            </div>
        </form><br><br>         

    </body>
</html>
