<%-- 
    Document   : PesquisarConsultaPorPaciente
    Created on : 13/08/2019, 13:28:50
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
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#calendario").datepicker({dateFormat: 'dd/mm/yy'});
            });
        </script>
    </head>
    <body class="body">

        <div class="form1">
            <h2>Pesquisar Consulta!</h2>

            <fieldset><legend>Digite o CPF do Paciente</legend>
                <div>
                    <form method="post" action="../pesquisarconsultaparaatualizar">

                        <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                        CPF<a>*</a>:<br> 
                        <input type="text" name="cpfpaciente" required onkeyup="maskIt(this, event, '###.###.###-##')">
                        <input type="submit" value="Buscar Paciente">

                    </form>
                </div>
            </fieldset>
        </div>
        <form name="atualizarconsulta" action="atualizarconsulta" method="post">
            <div class="resultadodaconsultaNome">
                <%
                    Object consultas = request.getAttribute("listaconsultas");
                    ArrayList<ConsultaVO> consultasVO = (ArrayList<ConsultaVO>) consultas;
                    if (consultasVO != null) {%>
                <h2>Selecione a Consulta a ser atualizada</h2>
                <table id="tabelaConsulta">
                    <tr>
                        <th>Id</th>
                        <th>Nome do Paciente</th> 
                        <th>Nome do Médico</th> 
                        <th>Especialidade</th>
                        <th>Convenio</th>
                        <th>Data da Consulta</th>
                        <th>Horário da Consulta</th>
                        <th>Atenção Especial</th>
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
                        <td ><%= consultaVO.getAtencaoEspecial()%></td>
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
                    <input type="hidden" readonly name="codigopaciente" size="50" >
                    <input type="text" readonly name="nomepaciente" size="50" ><br><br>  
                    Nome do Médico: <br>
                    <input type="hidden" readonly name="codigoespecializacao" size="50" >
                    <input type="text" readonly name="nomemedico"  size="50" required> <br><br>
                    Nome da Especialidade: <br>
                    <input type="text" readonly name="nomeespecialidade"  size="50" required> <br><br>
                    Convênio <br> 
                    <input type="hidden" readonly name="codigoconvenio" size="50" >
                    <input type="text" readonly name="nomeconvenio"  size="50"><br><br>
                           <input type="text" readonly name="atencaoespecial" size="50"><br><br>
                    <div style="width:55%">
                        <div style="float:left"> Data<a>*</a>: </div>
                        <div style="float:right"> Horário<a>*</a>: </div>
                    </div>
                    <br>
                    <div style="width:80%">
                        <div style="float:left"> <input type="text" name="dataconsulta" id="calendario" size="20" required></div>    
                        <select style="width:180px; margin-left: 30px;" name="horarioconsulta" required><option selected disabled>Selecione um horário</option><br><br>
                            <option>08:00</option>
                            <option>08:30</option>
                            <option>09:00</option>
                            <option>09:30</option>
                            <option>10:00</option>
                            <option>10:30</option>
                            <option>11:00</option>
                            <option>11:30</option>
                            <option>13:30</option>
                            <option>14:00</option>
                            <option>14:30</option>
                            <option>15:00</option>
                            <option>15:30</option>
                            <option>16:00</option>
                            <option>16:30</option>
                            <option>17:00</option>
                            <option>17:30</option>                                                                 
                        </select><br><br> 
                    </div>   
             
                    
                    <input type="hidden" id="excluir" name="excluir" value="excluir">
                    <input type="submit" value="Atualizar Dados da Consulta">
                </fieldset>

                <%  }%>      
            </div>    

        </form><br><br>
        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>


    </body>
</html>
