<%-- 
    Document   : MostrarConsultaExcluida
    Created on : 13/08/2019, 11:34:57
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="Consulta/CRUDConsulta.css">
    <title>Consulta Excluida</title>
</head>
<body class="body">
    <div class="principal">
        <div class="secao3">
        </div>
        <div class="cadastro">
            <h3>Exclusão de Consulta por Paciente!</h3>
            <fieldset><legend>Resultado da exclusão:</legend>
                <%
                    Object obj1 = request.getAttribute("codigoconsulta");

                    if (obj1 != null) {
                        Integer especializacaoExcluida = (Integer) obj1;
                        if (especializacaoExcluida != null) {%>

                A Consulta foi Excluída com sucesso! 
            </fieldset>
        </div>
        <%} else {%>

        <div class="secao3">
        </div>
        <div class="cadastro">
            <fieldset>
                <% out.println("Consulta não pode ser excluída na base de dados!");%>

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
