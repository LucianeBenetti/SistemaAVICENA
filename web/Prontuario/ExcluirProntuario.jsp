<%@page import="model.vo.Prontuario.ProntuarioVO"%>
<%@page import="model.vo.Convenio.ConvenioVO"%>
<%@page import="model.vo.Prontuario.ProntuarioVO"%>
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
            <h2>Excluir Prontuario!</h2>

            <fieldset><legend>Digite o CPF do Paciente</legend>
                <div>
                    <form method="post" action="../pesquisarprontuarioparaexcluir">

                        <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                        CPF<a>*</a>:<br> 
                        <input type="text" name="cpfpaciente" required onkeyup="maskIt(this, event, '###.###.###-##')">
                        <input type="submit" value="Buscar Paciente"><br><br>
                    </form>
                </div>

            </fieldset>

            <form name="cadastrarprontuario" action="excluirprontuario" method="post">
                <fieldset>
                    Nome: <br>   
                    <input type="text" readonly name="nomepaciente" size="50" required ><br><br> 
                    <input type="hidden" readonly name="codigoprontuario"> 
                    <input type="hidden" readonly name="codigopaciente"> 
                    Medicamentos:
                    <textarea name="medicamentos"></textarea><br><br>
                    Exames:<br>
                    <textarea name="exames"></textarea><br><br>
                    Procedimentos:<br>
                    <textarea name="procedimento" ></textarea><br><br>
                    Registro de Observações:<br>
                    <textarea name="registro" ></textarea><br><br>

                    <input type="submit" name="excluir" value="Excluir Prontuario">

                    <br><br>    

                </fieldset>
            </form>
        </div><br><br> 

        <div class="resultadodaconsulta">            
            <%
                Object obj = request.getAttribute("listaprontuarios");
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
