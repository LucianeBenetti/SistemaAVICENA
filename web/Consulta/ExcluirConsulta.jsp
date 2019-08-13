<%-- 
    Document   : ExcluirConsulta]
    Created on : 12/08/2019, 15:47:49
    Author     : 80130917
--%>

<%@page import="model.vo.Consulta.ConsultaVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="mascarasConsulta.js"></script>
        <script type="text/javascript" src="Consulta/selecionarTabelaEspecializacao.js"></script>
        <link type="text/css" rel="stylesheet" href="CRUDConsulta.css">
        <link type="text/css" rel="stylesheet" href="Consulta/CRUDConsulta.css">
    </head>
    <body class="body">

        <div class="form1">
            <h2>Excluir Consulta!</h2>

            <fieldset><legend>Digite o CPF do Paciente</legend>
                <div>
                    <form method="post" action="../pesquisarconsultaparaexcluir">

                        <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                        CPF<a>*</a>:<br> 
                        <input type="text" name="cpfpaciente" required onkeyup="maskIt(this, event, '###.###.###-##')">
                        <input type="submit" value="Buscar Paciente">

                    </form>
                </div>
            </fieldset>
        </div>
          <form name="excluirconsulta" action="excluirconsulta" method="post">
        <div class="resultadodaconsultaNome">         
                <%
                    Object consultas = request.getAttribute("listaconsultas");
                    ArrayList<ConsultaVO> consultasVO = (ArrayList<ConsultaVO>) consultas;
                    if (consultasVO != null) {%>
                <h2>Selecione a Consulta a ser excluida</h2>
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

                    <tr onclick="clickExcluirConsulta(this)">
                        <td><%= consultaVO.getCodigoConsulta()%></td>
                        <td><%= consultaVO.getPacienteVO().getNomePaciente()%></td>
                        <td><%= consultaVO.getEspecializacaoVO().getMedicoVO().getNomeMedico()%></td>
                        <td><%= consultaVO.getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade()%></td>
                        <td><%= consultaVO.getConvenioVO().getNomeConvenio()%></td>
                        <td ><%= consultaVO.getDataConsulta()%></td>
                        <td ><%= consultaVO.getHorarioConsulta()%></td>
                    </tr>     
                    <% }  %>
                </table>
                <br><br>
                </div>
                <div class="form3">
                    <fieldset>
                        <br><br>
                        <input type="hidden" name="codigoconsulta" size="4" readonly>
                        Nome: <br>                       
                        <input type="text" readonly name="nomepaciente" size="50" ><br><br>  
                        Nome do Médico: <br>
                        <input type="text" name="nomemedico"  size="50" readonly> <br><br>
                        Nome da Especialidade: <br>
                        <input type="text" name="nomeespecialidade"  size="50" readonly> <br><br>
                        Convênio <br>                       
                        <input type="text" readonly name="nomeconvenio"  size="50"><br><br>
                        <!--  <div style="width:55%">
                        <div style="float:left"> Data<a>*</a>: </div>
                        <div style="float:right"> Horário<a>*</a>: </div>
                    </div>
                    <br>
                    <div style="width:80%">
                             <div style="float:left"> <input type="text" name="dataconsulta" readonly size="15"></div>    
                             <div style="float:right"> <input type="text" name="horarioconsulta" readonly size="15"></div><br><br> 
                        
                         </div> -->
                        <input type="hidden" id="excluir" name="excluir" value="excluir">
                        <input type="submit" value="Excluir Consulta">
                    </fieldset>

                    <%  }%>      
                </div>    

            </form><br><br>
            <footer class="footer">                
                &copy; Desenvolvido por Luciane Benetti e Marco Sena.
            </footer>


    </body>
</html>
