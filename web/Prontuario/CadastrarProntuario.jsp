<%@page import="model.vo.Prontuario.ProntuarioVO"%>
<%@page import="model.vo.Consulta.ConsultaVO"%>
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
        <title>Cadastrar Prontuário</title>
    </head>
    <body class="body">
        <div class="form1">
            <h2>Cadastrar Prontuario!</h2>

            <fieldset><legend>Digite o CPF do Paciente</legend>
                <div>
                    <form method="post" action="../pesquisardadosparacadastrarprontuario">

                        <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                        CPF<a>*</a>:<br> 
                        <input type="text" name="cpfpaciente" required onkeyup="maskIt(this, event, '###.###.###-##')">
                        <input type="submit" value="Buscar Paciente"><br><br>
                    </form>
                </div>

            </fieldset>

            <form name="cadastrarprontuario" action="cadastrarprontuario" method="post">
                <fieldset>
                    Nome: <br>   
                    <input type="hidden" readonly name="codigoconsulta"> 
                    <input type="hidden" readonly name="codigopaciente"> 
                    <input type="text" readonly name="nomepaciente" size="50" required ><br><br> 
                    <input type="hidden" readonly name="codigoespecializacao"> 
                    <input type="hidden" readonly name="nomemedico"> 
                    <input type="hidden" readonly name="nomeespecialidade"> 
                    <input type="hidden" readonly name="codigoconvenio"> 
                    <input type="hidden" readonly name="nomeconvenio"> 

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

                    <input type="submit" name="cadastrar" value="Cadastrar Prontuario">
                    
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
                    <th>Convenio</th>
                    <th>Data da Consulta</th>
                    <th>Horário da Consulta</th>
                </tr>        
                <% for (ConsultaVO consultaVO : consultasVO) {%>  

                <tr onclick="clickLinhaTabelaConsulta(this)">
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
                <% }
                    } %>
            </table>
            <br><br>

            <%
                Object obj = request.getAttribute("listaProntuarios");
                ArrayList<ProntuarioVO> listaProntuarios = (ArrayList<ProntuarioVO>) obj;
                if (listaProntuarios != null) {%>

            <h2>Prontuario do Paciente</h2>
            <table id="tabelaConsulta">
                <tr>
                    <th>Id</th>
                    <th>Nome do Paciente</th> 
                    <th>Medicamentos</th>
                    <th>Exames</th>
                    <th>Procedimentos</th>
                    <th>Registro</th>

                </tr>        
                 <% for (ProntuarioVO prontuarioVO : listaProntuarios) {%>
                <tr onclick="clickLinhaTabelaProntuario(this)">
                    <td><%= prontuarioVO.getCodigoProntuario()%></td>
                    <td hidden><%= prontuarioVO.getPacienteVO().getCodigoPaciente()%></td>
                    <td><%= prontuarioVO.getPacienteVO().getNomePaciente()%></td>
                    <td><%= prontuarioVO.getMedicamento()%></td>
                    <td ><%= prontuarioVO.getExame()%></td>
                    <td><%= prontuarioVO.getProcedimento()%></td>
                    <td ><%= prontuarioVO.getRegistro()%></td>
                </tr>     
                <% }}%>
            </table>
            <br><br>      

            <form name="emitirreceita" action="../emitirreceita" method="post">
                <input type="submit" value="Emitir Receita">
            </form>
        </div>


        <br><br>   
        <br><br>
        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>
    </body>
</html>
