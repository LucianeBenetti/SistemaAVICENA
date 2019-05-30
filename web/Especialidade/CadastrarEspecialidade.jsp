<%-- 
    Document   : CadastrarEspecialidade
    Created on : 20/05/2019, 09:12:15
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="EspecialidadeCRUD.css">
        <link type="text/css" rel="stylesheet" href="Especialidade/EspecialidadeCRUD.css">
        <title>Cadastrar Especialidade</title>
    </head>
    <body class="body">
        <hr>
        <h1>Cadastro de Especialidade</h1>
        <h3>Por gentileza, preencher os dados do especialidade a ser cadastrada:</h3> 
        <form action="../crudespecialidade" method="POST">
            <div class="form1">
                <fieldset><legend>Especialidade</legend>                    
                    <a>*</a>Campos de preenchimento obrigatório <br><br>
                    <input type="hidden" id="cadastrar" name="cadastrar" value="cadastrar">
                    Nome<a>*</a>: <br>
                    <input type="text" name="nomeespecialidade" required size="80"><br><br>
                    Instituição<a>*</a>: <br>
                    
                    <input type="text" name="instituicaoespecialidade" required size="80"><br><br>
                  
                    <br><br>
                    <input type="reset" value="Limpar Campos">
                    <input type="submit" value = "Cadastrar Especialidade">    
                </fieldset>

                <br><br>
            </div>
        </form>
        <div class="form2">

        </div>
        <div>
            <form action="../controledenavegacao" method="post">
                <input type="hidden" id="avicena" name="avicena" value="avicena">
                <input type="submit" value = "Voltar">
            </form>   
        </div>
        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>    

    </body>
</html>