<%-- 
    Document   : MostrarPacienteExcluido
    Created on : 15/05/2019, 16:37:30
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Paciente/CRUDPaciente.css">
        <title> Resultado da exclusao</title>
    </head>
    <body class="body">

        <div class="resultadodaatualizacao">
            <h2>Resultado da exclusao:</h2>
            <%
                Object obj1 = request.getAttribute("cpfpaciente");

                if (obj1 != null) {%>

            O paciente com CPF <input type="text" value="<%= request.getAttribute("cpfpaciente")%>"> 
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
