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
        <%
            Object convenios = request.getAttribute("listaconvenios");
            ArrayList<ConvenioVO> conveniosVO = (ArrayList<ConvenioVO>) convenios;
            if (conveniosVO != null) {%>

        <div class="form1">
            <h2>Pesquisar Convênio por CNPJ!</h2>

            <form method="post" action="pesquisarconsultaporconvenio">

                <fieldset><legend>Por gentileza, selecionar o nome do Convênio a ser pesquisado:</legend>
                    <select name="convenioselecionado" >
                        <option selected disabled >Selecione um Convênio</option>
                        <% for (int i = 0; i < conveniosVO.size(); i++) {%>
                        <option name="convenioselecionado" value="<%=(conveniosVO.get(i).getCnpjConvenio())%>"><%out.println(conveniosVO.get(i).getNomeConvenio());%></option>
                        <%} %>  
                    </select>
                    <br /><br />
                    <input type="submit" value = "Buscar Convênio Selecionado">   
                </fieldset>

                <%} %>  
                <br><br>
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
