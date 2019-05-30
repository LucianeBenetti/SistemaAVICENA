<%-- 
    Document   : MostrarEspecialidadeExcluida
    Created on : 24/05/2019, 11:38:13
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Especialidade/EspecialidadeCRUD.css">
        <title>Resultado da exclusão</title>
    </head>
    <body class="body">
        <div class="principal">
            <div class="secao3">
            </div>
            <div class="cadastro">
                <h3>Exclusão de Escpecialidade por Nome!</h3>
                <fieldset><legend>Resultado da exclusao:</legend>
                    <%
                        Object obj1 = request.getAttribute("codigoespecialidade");

                        if (obj1 != null) {
                            Integer especialidadeExcluida = (Integer) obj1;
                            if (especialidadeExcluida != null) {%>

                    A especialidade foi Excluída com sucesso! 
                    </div>
                    <%} else {%>

                    <div class="secao3">
                    </div>
                    <div class="cadastro">

                        <input type="text" readonly size="40" value="<% out.println("Especialidade não pode ser excluída na base de dados!");%>">

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
