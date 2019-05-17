<%-- 
    Document   : ExcluirConvenio
    Created on : 17/05/2019, 13:52:04
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="mascarasConvenio.js"></script>
        <link type="text/css" rel="stylesheet" href="CRUDConvenio.css">
        <link type="text/css" rel="stylesheet" href="Convenio/CRUDConvenio.css">
        <title>Excluir Convênio por CNPJ</title>
    </head>
    <body class="body">

        <div class="excluirCPF">
            <h3>Excluir Convênio por CNPJ!</h3>

            <form method="post" action="../crudconvenio">

                <fieldset><legend>Digite o CNPJ do Convênio que deseja excluir da base de dados:</legend>
                    <p><a>*</a>Campos de preenchimento obrigatório</p>                    
                    <input type="hidden" id="excluir" name="excluir" value="excluir">
                    CNPJ<a>*</a>: <br>
                    <input type="text" name="cnpjconvenio" required onkeyup="maskIt(this, event, '##.###.###/####-##')"><br><br>

                    <input type="submit" value="Excluir Convenio">                

                </fieldset>                
            </form> 
            <br><br>
          
            <div>
                <form action="../controledenavegacao" method="POST">
                    <input type="hidden" id="avicena" name="avicena" value="avicena">
                    <input type="submit" value="Voltar">
                </form>
            </div>

        </div>

    </body>
</html>
