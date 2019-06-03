<%-- 
    Document   : ResultadoDaAtualizacao
    Created on : 17/05/2019, 14:32:28
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Convenio/CRUDConvenio.css">
        <title>Resultado da Atualização</title>
    </head>
    <body class="body">        
        <div class="principal">
            <div class="secao3">
            </div>
            <div class="cadastro">
                <h2>Resultado da atualização:</h2>
                <fieldset><legend>Convênio</legend>
                    <%
                        Object obj1 = request.getAttribute("atualizacao");

                        if (obj1 != null) {
                            Boolean convenioAtualizado = (Boolean) obj1;

                            if (convenioAtualizado) {%>                     
                    <input type="text" size="40" readonly style="margin-left: 5px;" value="<% out.println("Dados do Convênio atualizados com sucesso!!");%>">               
                    <%} else {%>
                    <input type="text" size="40" readonly style="margin-left: 5px;" value="<% out.println("Não foi possível atualizar os dados do Convênio!! Tente novamente");%>">

                    <%}
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
