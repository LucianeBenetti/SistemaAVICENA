<%-- 
    Document   : MostrarConvenioExcluido
    Created on : 17/05/2019, 13:56:19
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Convenio/CRUDConvenio.css">
        <title>Resultado da exclusão</title>
    </head>
    <body class="body">
        <div class="principal">
            <div class="secao3">
            </div>
            <div class="cadastro">
                <h3>Exclusão Convênio por CNPJ!</h3>
                <fieldset><legend>Resultado da exclusao:</legend>
                    <%
                        Object obj1 = request.getAttribute("convenioexcluido");

                        if (obj1 != null) {
                            Boolean convenioExcluido = (Boolean) obj1;
                            if (convenioExcluido) {%>

                    O convenio foi excluído com sucesso! 
                </fieldset>
            </div>

            <%} else {%>

            <div class="secao3">
            </div>
            <div class="cadastro">
                <fieldset>
                    Convênio não pode ser excluído da base de dados!"

                    <%}%>
                    <%}%>
                    <br><br>
                    <div class="secao4">
                    </div> 
                </fieldset>
                    <br><br>
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
