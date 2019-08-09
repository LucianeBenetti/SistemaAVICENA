<%-- 
    Document   : ExcluirConsulta
    Created on : 09/08/2019, 15:19:10
    Author     : 80130917
--%>

<%@page import="model.vo.Consulta.ConsultaVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="mascarasConsulta.js"></script>
    <script type="text/javascript" src="Consulta/selecionarTabelaEspecializacao.js"></script>
    <link type="text/css" rel="stylesheet" href="ConsultaCRUD.css">
    <link type="text/css" rel="stylesheet" href="Consulta/ConsultaCRUD.css"
</head>
<body class="body">
    <h2>Exclusão de Consulta</h2>
    <%
        Object obj = request.getAttribute("consultavoretornada");
        Boolean ConsultaVORetornada = (Boolean) obj;
        if (!ConsultaVORetornada) {%>                     
    <input type="text" size="100" style="margin-left: 5px;" value="<% out.println("Consulta não encontrada!");%>">               
    <%} else {%>

    <form name="cadastrarconsulta" action="excluirconsulta" method="post">
        <%
            Object consultas = request.getAttribute("listaConsultas");
            ArrayList<ConsultaVO> consultasVO = (ArrayList<ConsultaVO>) consultas;
                      if (consultasVO != null) {%>

        <fieldset><legend>Selecione a Consulta a ser excluida</legend>
            <table id="tabelaConsulta">
                <tr>
                    <th>Id</th>
                    <th>Nome do Paciente</th> 
                    <th>Data da Consulta</th>
                    <th>Horário da Consulta</th> 
                    <th>Nome do Médico</th> 
                    <th>Especialidade</th>
                    <th>Convenio</th>
                </tr>        
                <% for (ConsultaVO consultaVO : consultasVO) {%>  

                <tr onclick="clickLinhaTabela(this)">
                    <td><%= consultaVO.getCodigoConsulta()%></td>
                    <td><%= consultaVO.getPacienteVO().getNomePaciente()%></td>
                    <td ><%= consultaVO.getDataConsulta()%></td>
                    <td ><%= consultaVO.getHorarioConsulta()%></td>
                    <td hidden><%= consultaVO.getEspecializacaoVO().getCodigoEspecializacao()%></td>
                    <td><%= consultaVO.getEspecializacaoVO().getMedicoVO().getNomeMedico()%></td>
                    <td><%= consultaVO.getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade()%></td>
                    <td><%= consultaVO.getConvenioVO().getNomeConvenio()%></td>
                </tr>     
                <% }  %>
                <% }%>
            </table>
            <br><br>
        </fieldset>

        <br><br>
        <input type="hidden" name="codigoconsulta" size="4" readonly>
        Nome: <br>                       
        <input type="text" readonly name="nomepaciente" size="50" required><br><br>  
        <input type="hidden" name="codigopaciente">
        <div style="width:25%">
            <div style="float:left"> Data: </div>
            <div style="float:right"> Horário: </div>
        </div>
        <br>
         <div style="width:28%">
            <div style="float:left"> <input type="text" name="dataconsulta" size="15" required></div>    
            <div style="float:right"> <input type="text" name="horarioconsulta" size="15" required></div><br><br> 
        <input type="hidden" name="codigoespecializacao" size="4" readonly>
        Nome do Médico: <br>
        <input type="text" name="nomemedico" required size="50" readonly> <br><br>
         Nome da Especialidade: <br>
        <input type="text" name="nomeespecialidade" required size="50" readonly> <br><br>
        Convênio <br>                       
        <input type="text" readonly name="nomeconvenio" required size="50"><br><br>
             

            <input type="hidden" id="excluir" name="excluir" value="excluir">
            <input type="submit" value="Excluir Consulta">
            </fieldset>
            </form><br><br>
            <%  }%>      
        </div>            
        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>

</body>
</html>

