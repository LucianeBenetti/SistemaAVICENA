<%-- 
    Document   : ResultadoDaAtualizacao
    Created on : 21/05/2019, 09:42:32
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Especialidade/CRUDEspecialidade.css">
        <title>Resultado da Atualização</title>
    </head>
    <body class="body">        

        <div class="resultadodaatualizacao">
            <h2>Resultado da atualização:</h2>
            <%
                Object obj1 = request.getAttribute("atualizacao");

                if (obj1 != null) {
                    Boolean especialidadeAtualizado = (Boolean) obj1;

                    if (especialidadeAtualizado) {%>                     
            <input type="text" size="40" style="margin-left: 5px;" value="<% out.println("Dados da Especialização atualizados com sucesso!!");%>">               
            <%} else {%>
            <input type="text" size="40" style="margin-left: 5px;" value="<% out.println("Não foi possível atualizar os dados do Especialização!! Tente novamente");%>">

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
