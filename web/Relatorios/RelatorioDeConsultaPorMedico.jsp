<%@page import="model.vo.Medico.MedicoVO"%>
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
        <h2>Relatório de Consultas por Médico</h2>
        <form name="f1"  action="pesquisarconsultapormedico" method="POST">

            <div class="consultaNome">

                    <%
                        Object listaMedicos = request.getAttribute("listamedicosvo");
                        if (listaMedicos != null) {
                            ArrayList<MedicoVO> medicos = (ArrayList<MedicoVO>) listaMedicos;
                    %>
                    <fieldset><legend>Por gentileza, selecionar o nome do Médico a ser pesquisado:</legend>
                        <select name="medicoselecionado" >
                            <option selected disabled >Selecione um Médico</option>
                            <% for (int i = 0; i < medicos.size(); i++) {%>
                            <option name="medicoselecionado" value="<%=(medicos.get(i).getNomeMedico())%>"><%out.println(medicos.get(i).getNomeMedico());%></option>
                            <%} %>  
                        </select>
                        <br /><br />
                        <input type="submit" value = "Buscar Médico Selecionado">   
                    </fieldset>

                <%} %>  
                <br><br>
            </div>
        </form>  
         <form name="f2" action="gerarrelatorioconsultaspormedico" method="post">
        <div class="resultadodaconsultaNome">
           
                <%
                    Object consultas = request.getAttribute("listadeconsultas");
                    ArrayList<ConsultaVO> consultasVO = (ArrayList<ConsultaVO>) consultas;
                    if (consultasVO != null) {%>

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
                <%  }%>      

          
            <br><br>         
        </div>
        </form>
    </body>
</html>
