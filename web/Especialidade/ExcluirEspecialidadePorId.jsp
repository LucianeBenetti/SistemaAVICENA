<%-- 
    Document   : ExcluirEspecialidadePorId
    Created on : 20/05/2019, 15:32:50
    Author     : 80130917
--%>

<%@page import="model.vo.Especialidade.EspecialidadeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="Especialidade/selecionarLinhaTabela.js"></script>
    <link type="text/css" rel="stylesheet" href="EspecialidadeCRUD.css">
    <link type="text/css" rel="stylesheet" href="Especialidade/EspecialidadeCRUD.css">
    <title>Excluir Especialidade</title>
</head>
<body class="body">

    <div class="consultaNome">
        <h2>Excluir Especialidade!</h2>

        <form method="post" action="../pesquisarparaexcluir">

            <fieldset><legend>Digite o nome da Especialidade a ser consultada na base de dados</legend>
                <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                Nome<a>*</a>:<br> 
                <input type="text" name="nomeespecialidade" required ><br><br>
                <input type="submit" value = "Pesquisar Especialidade"> 
            </fieldset>
        </form>
        <br><br>
        <div>
            <form action="../controledenavegacao" method="POST">
                <input type="hidden" id="avicena" name="avicena" value="avicena">
                <input type="submit" value="Voltar">
            </form>
        </div>
    </div>

    <div class="resultadodaconsultaNome">
        <h2>Resultado da pesquisa de Especialidade por Nome</h2>

        <%
            Object obj = request.getAttribute("especialidadevoretornada");

            if (obj != null) {
                Boolean EspecialidadeVORetornada = (Boolean) obj;

                if (!EspecialidadeVORetornada) {%>                     
               <input type="text" size="100" style="margin-left: 5px;" value="<% out.println("Especialidade não encontrada!"
                    + " Tente novamente. Se a Especialidade não for cadastrada, por gentileza, cadastrá-la!!");%>">               
        <%} else {%>

        <form name="atualizarespecialidade" action="crudespecialidade" method="post">
            <fieldset><legend>Dados do Especialidade</legend>
                <table id="tabelaEspecialidades">
                    <tr>
                        <th>Id</th>
                        <th>Nome</th> 
                        <th>Instituição</th> 
                    </tr>        
                    <%
                        ArrayList<EspecialidadeVO> especialidadesVO = (ArrayList<EspecialidadeVO>) request.getAttribute("especialidadesBuscadas");
                        for (EspecialidadeVO especialidadeVO : especialidadesVO) {%>   
                    <tr onclick="clickLinhaTabela(this)">
                        <td><%= especialidadeVO.getCodigoEspecialidade()%></td>
                        <td><%= especialidadeVO.getNomeEspecialidade()%></td>
                        <td><%= especialidadeVO.getInstituicao()%></td>
                    </tr>     
                    <% }     %>
                </table>

                <br><br>
                ID: <br>
                <input type="text" name="codigoespecialidade" size="4" readonly> <br><br>
                Nome: <br>
                <input type="text" name="nomeespecialidade" size="80" readonly> <br><br>
                Instituicao:<br>
                <input type="text" name="instituicaoespecialidade" size="80" readonly> <br><br>
                <br><br>

                <input type="hidden" id="excluir" name="excluir" value="excluir">
                <input type="submit" value="Excluir Especialidade">
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