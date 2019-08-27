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

           <!-- <fieldset><legend>Digite o CPF do Paciente</legend>
                <div>
                    <form method="post" action="../pesquisardadosparaemitirreceita">

                    <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                        CPF<a>*</a>:<br> 
                        <input type="text" name="cpfpaciente" required onkeyup="maskIt(this, event, '###.###.###-##')">
                        <input type="submit" value="Buscar Paciente"><br><br>
                    </form>
                </div> 

            </fieldset>-->
            
           <form name="emitirreceita" action="emitirreceita" method="post">
                <fieldset>
                    Nome: <br>   
                    <input type="hidden" readonly name="codigoreceita"> 
                    <input type="hidden" readonly name="codigoconsulta"> 
                    <input type="hidden" readonly name="codigopaciente"> 
                    <input type="text" readonly name="nomepaciente" size="50" required ><br><br> 
                    <input type="hidden" readonly name="codigoespecializacao"> 
                    <input type="hidden" readonly name="nomemedico"> 
                    <input type="hidden" readonly name="nomeespecialidade"> 
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
                    Procedimentos:<br>
                    <textarea name="procedimento" ></textarea><br><br>
                    Registro de Observações:<br>
                    <textarea name="registro" ></textarea><br><br>

                <input type="submit" value="Emitir Receita">
   
                    <br><br>    

                </fieldset>
            </form>
        </div><br><br> 

    
        <div class="resultadodaconsulta">            
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
                    <th>Posologia</th>
                    <th>Exames</th>
                    <th>Observações</th>
                </tr>        
                <% for (ReceitaVO receitaVO : receitasVO) {%>  

                <tr onclick="clickLinhaTabelaReceita(this)">
                    <td><%= receitaVO.getCodigoReceita()%></td>
                    <td hidden><%= receitaVO.getConsultaVO().getCodigoConsulta()%></td>
                    <td hidden><%= receitaVO.getConsultaVO().getPacienteVO().getCodigoPaciente()%></td>
                    <td><%= receitaVO.getConsultaVO().getPacienteVO().getNomePaciente()%></td>
                    <td hidden><%= receitaVO.getEspecializacaoVO().getCodigoEspecializacao()%></td>
                    <td><%= receitaVO.getEspecializacaoVO().getMedicoVO().getNomeMedico()%></td>
                    <td><%= receitaVO.getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade()%></td>
                    <td ><%= receitaVO.getConsultaVO().getDataConsulta()%></td>
                    <td ><%= receitaVO.getConsultaVO().getHorarioConsulta()%></td>
                    <td ><%= receitaVO.getMedicamento()%></td>
                    <td><%= receitaVO.getPosologia()%></td>
                    <td ><%= receitaVO.getExames()%></td>
                    <td><%= receitaVO.getObservacao()%></td>
                
                </tr>     
                <% }
                    } %>
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
