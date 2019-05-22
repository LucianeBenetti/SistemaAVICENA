<%-- 
    Document   : ListarTodasEspecializacoes
    Created on : 22/05/2019, 08:54:01
    Author     : 80130917
--%>

<%@page import="model.vo.Especializacao.EspecializacaoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Especializacao/CRUDEspecializacao.css">
        <title>Todas as Especializações da Clínica Avicena</title>
    </head>
    <body class="body">

        <h1>Lista das especializações cadastrads na clínica AVICENA</h1><br> 

        <table id="tabelaListarTodas">
            <tr>
                <th>Id</th>
                <th>Nome</th> 
                <th>Especialidade</th> 
                <th>Ano</th> 
                <th>Instituição</th> 
            </tr>            

            <%
                ArrayList<EspecializacaoVO> especializacaosVO = (ArrayList<EspecializacaoVO>) request.getAttribute("especializacoes");

                for (EspecializacaoVO especializacaoVO : especializacaosVO) {%>   
            <tr>
                <td><%= especializacaoVO.getCodigoEspecializacao()%></td>
                <td><%= especializacaoVO.getMedicoVO().getNomeMedico()%></td>
                <td><%= especializacaoVO.getEspecialidadeVO().getNomeEspecialidade()%></td>
                <td><%= especializacaoVO.getAnoEspecializacao()%></td>
                <td><%= especializacaoVO.getEspecialidadeVO().getInstituicao()%></td>
            </tr>                   

            <%
                }
            %>
        </table>      
        <br><br>
        <form action="controledenavegacao" method="post">
            <input type="hidden" id="avicena" name="avicena" value="avicena">
            <input type="submit" value = "Voltar">
        </form>

        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>

    </body>
</html>
