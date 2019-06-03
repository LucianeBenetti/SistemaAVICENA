<%-- 
    Document   : CadastrarMedico
    Created on : 08/05/2019, 15:12:14
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="mascarasMedico.js"></script>
        <link type="text/css" rel="stylesheet" href="CRUDMedico.css">
        <link type="text/css" rel="stylesheet" href="Medico/CRUDMedico.css">
        <title>Cadastrar Médico</title>
    </head>
    <body class="body">
        <hr>
        <h1>Cadastro de Médico</h1>
        <h3>Por gentileza, preencher os dados do medico a ser cadastrado:</h3> 
        <form action="../crudmedico" method="POST">
            <div class="form1">
                <fieldset><legend>Médico</legend>                    
                    <a>*</a>Campos de preenchimento obrigatório <br><br>
                    <input type="hidden" id="cadastrar" name="cadastrar" value="cadastrar">
                    Nome<a>*</a>: <br>
                    <input type="text" name="nomemedico" required size="83"><br><br>

                    <div style="width:74%">
                        <div style="float:left"> Celular WhatsApp<a>*</a>: </div>
                        <div style="float:right"> Celular: </div>
                    </div>
                    <br>
                    <div style="width:100%">

                        <div style="float:left"> <input type="text" name="celularwhats" required size="35" onkeyup="maskIt(this, event, '(##)####-####')"></div>    
                        <div style="float:right"> <input type="text" name="celularmedico" size="35" onkeyup="maskIt(this, event, '(##)####-####')"></div>
                    </div>
                    <br><br>

                    e-mail:<br>
                    <input type="email" name="email" size="83"><br><br>
                    CRM: <br>
                    <input type="crm" name="crm" size="83">

                    <br><br>
                    <div style="width:62%">
                        <div style="float:left"> CPF<a>*</a>: </div>
                        <div style="float:right"> CNPJ: </div>
                    </div>
                    <br>
                    <div style="width:100%">
                        <div style="float:left"> <input type="text" name="cpfmedico" size="35" required onkeyup="maskIt(this, event, '###.###.###-##')"></div>    
                        <div style="float:right"> <input type="text" name="cnpjmedico" size="35" onkeyup="maskIt(this, event, '##.###.###/####-##')"></div>
                    </div>
                    <br><br>
                    <input type="reset" value="Limpar Campos">
                    <input type="submit" value = "Cadastrar Medico">    
                </fieldset>

                <br><br>


            </div>

        </fieldset>
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