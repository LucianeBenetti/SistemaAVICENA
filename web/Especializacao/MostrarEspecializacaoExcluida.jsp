<%-- 
    Document   : MostrarEspecializacaoExcluida
    Created on : 24/05/2019, 11:43:49
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
        <title>Resultado da exclusão</title>
    </head>
    <body class="body">
        <div class="principal">
            <div class="secao3">
            </div>
            <div class="cadastro">
                <h3>Exclusão de Especialização por Especialidade!</h3>
                <fieldset><legend>Resultado da exclusao:</legend>
                    <%
                        Object obj1 = request.getAttribute("codigoespecializacaoVO");

                        if (obj1 != null) {
                            Integer especializacaoExcluida = (Integer) obj1;
                            if (especializacaoExcluida != null) {%>

                    A especializacao foi Excluída com sucesso! 
                </fieldset>
            </div>
            <%} else {%>

            <div class="secao3">
            </div>
            <div class="cadastro">
                <fieldset>
            <% out.println("Especializacao não pode ser excluída na base de dados!");%>

                <%}%>
                <%}%>
                </fieldset>
                <div class="secao4">
                </div> 

                <div>
                    <form action="controledenavegacao" method="POST">
                        <input type="hidden" id="avicena" name="avicena" value="avicena">
                        <input type="submit" value="Voltar">
                    </form>
                </div>
            </div>
            <br><br>
        </div>
        <br>
    </body>
</html>
