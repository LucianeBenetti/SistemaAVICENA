<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="CRUDConsulta.css">
        <link type="text/css" rel="stylesheet" href="Consulta/CRUDConsulta.css">
        <title>JSP Page</title>
    </head>
    <body class="body">
        
        <div class="principal">
            <div class="secao3">
            </div>
            <div class="cadastro">
                <h3>Resultado da Busca de Paciente!</h3>
                <fieldset>
                    <%
                        Object obj1 = request.getAttribute("pacientevoretornado");

                        if (obj1 != null) {
                            Boolean pacientevoRetornado = (Boolean) obj1;

                            if (!pacientevoRetornado) { %>

                    <br>             
                    <% out.println("Paciente não cadastrado na base de dados." + "\n"
                                + " Por gentileza, tentar novamente!");%>
                    <%  }
                      }%>
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
        </div>
        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>
    </body>
</html>
