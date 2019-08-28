<%@page import="model.vo.Consulta.ConsultaVO"%>
<%@page import="model.vo.Prontuario.ReceitaVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="mascarasProntuario.js"></script>
        <script type="text/javascript" src="Prontuario/selecionarTabelaProntuario.js"></script>
        <link type="text/css" rel="stylesheet" href="ProntuarioCRUD.css">
        <link type="text/css" rel="stylesheet" href="Prontuario/ProntuarioCRUD.css">
        <title>Emitir Receita</title>
    </head>
    <body class="body">
        <div class="form1">
            <h2>Emitir Receita!</h2>

            <fieldset><legend>Digite o CPF do Paciente</legend>
                <div>
                    <form method="post" action="../pesquisardadosparaemitirreceita">

                        <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                        CPF<a>*</a>:<br> 
                        <input type="text" name="cpfpaciente" required onkeyup="maskIt(this, event, '###.###.###-##')">
                        <input type="submit" value="Buscar Paciente"><br><br>
                    </form>
                </div> 

            </fieldset>

            <form name="emitirreceita" action="emitirreceita" method="post">
                <fieldset>
                    Nome: <br>   
                    <input type="hidden" readonly name="codigoreceita"> 
                    <input type="hidden" readonly name="codigoconsulta"> 
                    <input type="hidden" readonly name="codigopaciente"> 
                    <input type="text" readonly name="nomepaciente" size="50"><br><br> 
                    <input type="hidden" readonly name="codigoespecializacao" > 
                    <input type="text" readonly name="nomemedico" size="50"> <br><br>
                    <input type="text" readonly name="nomeespecialidade" size="50"> <br><br>
                    <div style="width:55%">
                        <div style="float:left"> Data: </div>
                        <div style="float:right"> Horário: </div>
                    </div>
                    <br>
                    <div style="width:80%">
                        <div style="float:left"> <input type="text" readonly name="dataconsulta" size="20" ></div>    
                        <div style="float:right"> <input type="text" readonly name="horarioconsulta" size="20"></div>  <br><br>  
                    </div>
                    <input type="hidden" readonly name="codigoprontuario"> 
                    Medicamentos:
                    <textarea name="medicamentos"></textarea><br><br>
                    Exames:<br>
                    <textarea name="exames"></textarea><br><br>
                    Registro de Observações:<br>
                    <textarea name="registroobservacao" ></textarea><br><br>

                    <input type="submit" value="Emitir Receita">

                    <br><br>    

                </fieldset>
            </form>
        </div><br><br> 


        <div class="resultadodaconsulta">  

            <%
                Object consultas = request.getAttribute("listaconsultas");
                ArrayList<ConsultaVO> consultasVO = (ArrayList<ConsultaVO>) consultas;
                if (consultasVO != null) {%>
            <h2>Consultas do Paciente</h2>
            <table id="tabelaConsulta">
                <tr>
                    <th>Id</th>
                    <th>Nome do Paciente</th> 
                    <th>Nome do Médico</th> 
                    <th>Especialidade</th>
                    <th>Data da Consulta</th>
                    <th>Horário da Consulta</th>
                </tr>        
                <% for (ConsultaVO consultaVO : consultasVO) {%>  

                <tr onclick="clickLinhaTabelaConsultaReceita(this)">
                    <td><%= consultaVO.getCodigoConsulta()%></td>
                    <td hidden><%= consultaVO.getPacienteVO().getCodigoPaciente()%></td>
                    <td><%= consultaVO.getPacienteVO().getNomePaciente()%></td>
                    <td hidden><%= consultaVO.getEspecializacaoVO().getCodigoEspecializacao()%></td>
                    <td><%= consultaVO.getEspecializacaoVO().getMedicoVO().getNomeMedico()%></td>
                    <td><%= consultaVO.getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade()%></td>
                    <td ><%= consultaVO.getDataConsulta()%></td>
                    <td ><%= consultaVO.getHorarioConsulta()%></td>
                </tr>     
                <% }
                    } %>
            </table>
            <br><br>

            <%
                Object receitas = request.getAttribute("listareceitas");
                ArrayList<ReceitaVO> receitasVO = (ArrayList<ReceitaVO>) receitas;
                if (receitasVO != null) {%>
            <h2>Receitas do Paciente</h2>
            <table id="tabelaConsulta">
                <tr>
                    <th>Id</th>
                    <th>Nome do Paciente</th> 
                    <th>Nome do Médico</th> 
                    <th>Especialidade</th>
                    <th>Data da Consulta</th>
                    <th>Horário da Consulta</th>
                    <th>Medicamento</th>
                    <th>Exames</th>
                    <th>Observações</th>
                </tr>        
                <% for (ReceitaVO receitaVO : receitasVO) {%>  

                    <td><%= receitaVO.getCodigoReceita()%></td>
                    <td hidden><%= receitaVO.getConsultaVO().getCodigoConsulta()%></td>
                    <td hidden><%= receitaVO.getConsultaVO().getPacienteVO().getCodigoPaciente()%></td>
                    <td><%= receitaVO.getConsultaVO().getPacienteVO().getNomePaciente()%></td>
                    <td hidden><%= receitaVO.getConsultaVO().getEspecializacaoVO().getCodigoEspecializacao()%></td>
                    <td><%= receitaVO.getConsultaVO().getEspecializacaoVO().getMedicoVO().getNomeMedico()%></td>
                    <td><%= receitaVO.getConsultaVO().getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade()%></td>
                    <td ><%= receitaVO.getConsultaVO().getDataConsulta()%></td>
                    <td ><%= receitaVO.getConsultaVO().getHorarioConsulta()%></td>
                    <td ><%= receitaVO.getMedicamento()%></td>
                    <td><%= receitaVO.getObservacao()%></td>

                </tr>     
                <% }
                    }%>
            </table>
            <br><br>
        </div>
        <br><br>   
        <br><br>
        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>
    </body>
</html>
