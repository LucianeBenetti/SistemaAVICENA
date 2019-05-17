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

        <div class="resultadodaatualizacao">
            <h2>Resultado da exclusão:</h2>
            <%
                Object obj1 = request.getAttribute("cnpjconvenio");

                if (obj1 != null) {%>

            O convenio com CNPJ <input type="text" readonly value="<%= request.getAttribute("cnpjconvenio")%>"> 
            foi Excluído!
            <%}%>

            <div>
                <form action="controledenavegacao" method="POST">
                    <input type="hidden" id="avicena" name="avicena" value="avicena">
                    <input type="submit" value="Voltar">
                </form>
            </div>
            <br><br>
        </div>
        <br><br>

    </body>
</html>
