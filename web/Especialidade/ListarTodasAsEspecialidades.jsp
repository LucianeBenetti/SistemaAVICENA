<%-- 
    Document   : ListarTodasAsEspecialidades
    Created on : 20/05/2019, 10:35:42
    Author     : 80130917
--%>

<%@page import="model.vo.Especialidade.EspecialidadeVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Especialidade/CRUDEspecialidade.css">
        <title>Todos as Especialidades da Clínica Avicena</title>
    </head>
    <body class="body">

        <h1>Lista das especialidades cadastrads na clínica AVICENA</h1><br> 

        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th> 
                <th>Instituição</th> 

            </tr>            

            <%
                ArrayList<EspecialidadeVO> especialidadesVO = (ArrayList<EspecialidadeVO>) request.getAttribute("especialidades");

                for (EspecialidadeVO especialidadeVO : especialidadesVO) {%>   
            <tr>
                <td><%= especialidadeVO.getCodigoEspecialidade()%></td>
                <td><%= especialidadeVO.getNomeEspecialidade()%></td>
                <td><%= especialidadeVO.getInstituicao()%></td>
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
