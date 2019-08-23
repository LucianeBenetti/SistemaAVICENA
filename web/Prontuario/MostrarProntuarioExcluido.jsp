<%-- 
    Document   : MostrarProntuarioExcluido
    Created on : 23/08/2019, 08:58:40
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="Prontuario/ProntuarioCRUD.css">
    <title>Prontuario Excluido</title>
</head>
<body class="body">
    <div class="principal">
        <div class="secao3">
        </div>
        <div class="cadastro">
            <h3>Exclusão de Prontuario por Paciente!</h3>
            <fieldset><legend>Resultado da exclusão:</legend>
                <%
                    Object obj1 = request.getAttribute("codigoprontuario");

                    if (obj1 != null) {
                        Integer prontuarioExcluido = (Integer) obj1;
                        if (prontuarioExcluido != null) {%>

                A Prontuario foi Excluído com sucesso! 
            </fieldset>
        </div>
        <%} else {%>

        <div class="secao3">
        </div>
        <div class="cadastro">
            <fieldset>
                <% out.println("Prontuario não pode ser excluído na base de dados!");%>

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
