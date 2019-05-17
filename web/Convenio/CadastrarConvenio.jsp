<%-- 
    Document   : CadastrarConvenio
    Created on : 17/05/2019, 10:02:23
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
        <title>Cadastrar Convenio</title>
    </head>
    <body class="body">
        <hr>
        <h1>Cadastro de Convenio</h1>
        <h3>Por gentileza, preencher os dados do convenio a ser cadastrado:</h3> 
        <form action="../crudconvenio" method="POST">
            <div class="form1">
                <fieldset><legend>Convenio</legend>                    
                    <a>*</a>Campos de preenchimento obrigatório <br><br>
                    <input type="hidden" id="cadastrar" name="cadastrar" value="cadastrar">
                    Nome<a>*</a>: <br>
                    <input type="text" name="nomeconvenio" required size="83"><br><br>

                    <div style="width:60%">
                        <div style="float:left"> CNPJ<a>*</a>: </div>
                        <div style="float:right"> Valor<a>*</a>: </div>
                    </div>
                    <br>
                    <div style="width:80%">

                        <div style="float:left"> <input type="text" name="cnpjconvenio" required size="35" onkeyup="maskIt(this, event, '##.###.###/####-##')"></div>    
                        <div style="float:right"> <input type="text" name="valor" required size="20" onkeyup="maskIt(this, event, '###.###.###,##', true, {pre: 'R$', pos: ''})"></div>
                    </div>
                    <br><br>
                    <input type="reset" value="Limpar Campos">
                    <input type="submit" value = "Cadastrar Convenio">    
                </fieldset>

                <br><br>
            </div>
        </form>
        <div class="form3">
            <form action="../controledenavegacao" method="post">
                <input type="hidden" id="avicena" name="avicena" value="avicena">
                <input type="submit" value = "Voltar">
            </form>   
            <footer class="footer">                
                &copy; Desenvolvido por Luciane Benetti e Marco Sena.
            </footer>    

    </body>
</html>