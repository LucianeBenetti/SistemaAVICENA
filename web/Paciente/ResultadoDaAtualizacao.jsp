<%-- 
    Document   : ResultadoDaAtualizacao
    Created on : 07/05/2019, 10:26:07
    Author     : 80119050
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Paciente/CRUDPaciente.css">
        <title>Resultado da Atualização</title>
    </head>
    <body class="body">        

        <div class="resultadodaatualizacao">
            <h2>Resultado da atualização:</h2>
            <%
                Object obj1 = request.getAttribute("atualizacao");

                if (obj1 != null) {
                    Boolean pacienteAtualizado = (Boolean) obj1;

                    if (pacienteAtualizado) {%>                     
            <input type="text" size="40" style="margin-left: 5px;" value="<% out.println("Dados do Paciente atualizados com sucesso!!");%>">               
            <%} else {%>
            <input type="text" size="40" style="margin-left: 5px;" value="<% out.println("Não foi possível atuaizar os dados do Paciente!! Tente novamente");%>">

            <%}
                }%>            
            <div>
                <br><br>
                <form action="controledenavegacao" method="POST">
                    <input type="hidden" id="avicena" name="avicena" value="avicena">
                    <input type="submit" value="Voltar">
                </form>
            </div>
        </div>
        <br><br>

        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>        
    </body>
</html>
