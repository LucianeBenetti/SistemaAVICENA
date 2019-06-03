<%-- 
    Document   : MostrarMedicoExcluido
    Created on : 16/05/2019, 14:22:01
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Medico/CRUDMedico.css">
        <title>Resultado da exclusão</title>
    </head>
    <body class="body">
        <div class="principal">
            <div class="secao3">
            </div>
            <div class="cadastro">
                <h3>Exclusão Médico por CNPJ!</h3>
                <fieldset><legend>Resultado da exclusao:</legend>
                    <%
                        Object obj1 = request.getAttribute("medicoexcluido");

                        if (obj1 != null) {
                            Boolean medicoExcluido = (Boolean) obj1;
                            if (medicoExcluido) {%>

                    O medico foi excluído com sucesso! 
                </fieldset>
            </div>
            <%} else {%>

            <div class="secao3">
            </div>
            <div class="cadastro">
                <fieldset>
                    <% out.println("Médico não pode ser excluído na base de dados!");%>

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
