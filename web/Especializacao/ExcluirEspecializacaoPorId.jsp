<%-- 
    Document   : ExcluirEspecializacoPorId
    Created on : 22/05/2019, 14:34:25
    Author     : 80130917
--%>

<%@page import="model.vo.Medico.MedicoVO"%>
<%@page import="model.vo.Especializacao.EspecializacaoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link type="text/css" rel="stylesheet" href="CRUDEspecializacao.css">
    <link type="text/css" rel="stylesheet" href="Especializacao/CRUDEspecializacao.css">
    <title>Excluir Especialização</title>
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

        <form action="crudespecializacao" method="post">

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
                <input type="text" readonly name="idespecializacao"> <br><br>
                Nome: <br>
                <input type="text" readonly name="nomeespecializacao"> <br><br>
                Ano <br>
                <input type="text" readonly name="anoespecializacao"> <br><br>
                Instituicao:<br>
                <input type="text" readonly name="instituicaoespecializacao"> <br><br>
                <br><br>
                <br><br>
                <input type="hidden" id="excluir" name="excluir" value="excluir">
                <input type="submit" value="Excluir Especializacao">
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