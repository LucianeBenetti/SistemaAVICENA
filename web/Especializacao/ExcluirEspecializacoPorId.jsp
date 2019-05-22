<%-- 
    Document   : ExcluirEspecializacoPorId
    Created on : 22/05/2019, 14:34:25
    Author     : 80130917
--%>

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

    <div class="consultaNome">
        <h2>Excluir Especialização!</h2>

        <form method="post" action="../pesquisarparaexcluir">

            <fieldset><legend>Digite o nome da Especialização a ser consultada na base de dados</legend>
                <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                Nome<a>*</a>:<br> 
                <input type="text" name="nomeespecializacao" required ><br><br>
                <input type="submit" value = "Pesquisar Especialização"> 
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
                        ArrayList<EspecializacaoVO> especializacoesVO = (ArrayList<EspecializacaoVO>) request.getAttribute("especializacaosBuscadas");
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