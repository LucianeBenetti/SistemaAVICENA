<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Especializacao/CRUDEspecializacao.css">
        <title>Resultado da Transação</title>
    </head>
    <body class="body">        
        <div class="principal">
            <div class="secao3">
            </div>
            <div class="cadastro">
                <h2>Resultado da transação</h2>
                <fieldset><legend>Especialização</legend>
                    <%
                        Object obj1 = request.getAttribute("resultado");
                        if (obj1 != null) {
                            Boolean resultado = (Boolean) obj1;

                            if (resultado) {%>                     
                    <% out.println("Transação efetuada com sucesso!!");%>            
                    <%} else {%>
                    <% out.println("Não foi possível efetuar a transação solicitada!! Por gentileza, tente novamente");%>

                    <%}
                        }%>            
                    <br><br>
                    <div class="secao4">
                    </div>
                </fieldset>
                <br><br>
                 
            </div>     
        </div>
        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>        
    </body>
</html>
