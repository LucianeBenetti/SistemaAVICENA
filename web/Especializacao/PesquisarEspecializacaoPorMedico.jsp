<%-- 
    Document   : PesquisarEspecializacaoPorNome
    Created on : 22/05/2019, 15:38:22
    Author     : 80130917
--%>

<%@page import="model.vo.Especialidade.EspecialidadeVO"%>
<%@page import="model.vo.Medico.MedicoVO"%>
<%@page import="model.vo.Especializacao.EspecializacaoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="selecionarLinhaTabela.js"></script>
        <link type="text/css" rel="stylesheet" href="CRUDEspecializacao.css">
        <link type="text/css" rel="stylesheet" href="Especializacao/CRUDEspecializacao.css">
        <title>Pesquisa de Especializações por Médico</title>
    </head>
    <body class="body">

        <hr>
        <h1>Pesquisa de Especialização</h1>
        <h3>Por gentileza, selecionar o nome do Médico a ser pesquisado:</h3> 

        <div class="form1">  

            <%
                Object listaMedicos = request.getAttribute("listaMedicosVO");
                if (listaMedicos != null) {
                    ArrayList<MedicoVO> medicos = (ArrayList<MedicoVO>) listaMedicos;

            %>
            <form action="mostrarespecializacaopesquisada" method="POST">
                <fieldset>   
                    <h4>Selecione o Médico</h4>
                    <select name="medicoSelecionado" >
                        <option selected disabled >Selecione um Médico</option>
                        <% for (int i = 0; i < medicos.size(); i++) {%>
                        <option value="<%=(medicos.get(i).getNomeMedico())%>"><%out.println(medicos.get(i).getNomeMedico());%></option>
                        <%} %>  
                    </select>
                    <br /><br />
                    <input type="submit" value = "Buscar Médico Selecionado">   
                </fieldset>

            </form>  
            <%} %>  
            <br><br>
            <div>
                <form action="../controledenavegacao" method="POST">
                    <input type="hidden" id="avicena" name="avicena" value="avicena">
                    <input type="submit" value="Voltar">
                </form>
            </div>


        </div>
        <div class="resultadodaconsultaNome">
            <h2>Resultado da pesquisa de Especialização por Nome</h2>

            <%
                Object obj = request.getAttribute("especializacaovoretornada");

                if (obj != null) {
                    Boolean EspecializacaoVORetornada = (Boolean) obj;

                    if (!EspecializacaoVORetornada) {%>                     
                   <input type="text" size="100" style="margin-left: 5px;" value="<% out.println("Especialização não encontrada!"
                               + " Tente novamente. Se a Especialização não for cadastrada, por gentileza, cadastrá-la!!");%>">               
            <%} else {%>

            <form action="atualizarespecializacao" method="post">

                <fieldset><legend>Dados do Especialização</legend>
                    <table id="tabelaEspecializacoes">
                        <tr>
                            <th>Id</th>
                            <th>Nome</th> 
                            <th>Especialidade</th> 
                            <th>Ano</th> 
                            <th>Instituição</th>  
                        </tr>        
                        <%
                            ArrayList<EspecializacaoVO> especializacoesVO = (ArrayList<EspecializacaoVO>) request.getAttribute("especializacoesBuscadas");
                            for (EspecializacaoVO especializacaoVO : especializacoesVO) {%>   
                        <tr>
                            <td><%= especializacaoVO.getCodigoEspecializacao()%></td>
                            <td><%= especializacaoVO.getMedicoVO().getNomeMedico()%></td>
                            <td><%= especializacaoVO.getEspecialidadeVO().getNomeEspecialidade()%></td>
                            <td><%= especializacaoVO.getAnoEspecializacao()%></td>
                            <td><%= especializacaoVO.getEspecialidadeVO().getInstituicao()%></td>
                        </tr>     
                        <% }     %>
                    </table>
                    <button id="visualizarDados">Buscar Dados</button>
                    <br><br>
                    ID: <br>
                    <input type="text" name="idespecializacao"> <br><br>
                    Nome: <br>
                    <input type="text" name="nomeespecializacao"> <br><br>
                    Instituicao:<br>
                    <input type="text" name="instituicaoespecializacao"> <br><br>
                    <br><br>

                    <input type="submit" value="Atualizar Dados da Especialização">
                </fieldset>
            </form><br><br>
            <%}
                }%>      
        </div>            


        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>

    </body>
</html>

