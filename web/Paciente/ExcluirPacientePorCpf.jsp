<%-- 
    Document   : ExcluirPaciente
    Created on : 26/04/2019, 13:56:19
    Author     : 80119050
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="mascarasPaciente.js"></script>
        <link type="text/css" rel="stylesheet" href="CRUDPaciente.css">
        <link type="text/css" rel="stylesheet" href="Paciente/CRUDPaciente.css">
        <title>Excluir Paciente por CPF</title>
    </head>
    <body class="body">

        <div class="excluirCPF">
            <h3>Excluir Paciente por CPF!</h3>

            <form method="post" action="../crudpaciente">

                <fieldset><legend>Digite o CPF do Paciente que deseja excluir da base de dados:</legend>
                    <p><a>*</a>Campos de preenchimento obrigatório</p>                    
                    <input type="hidden" id="excluir" name="excluir" value="excluir">
                    CPF<a>*</a>: <br>
                    <input type="text" name="cpfpaciente" required onkeyup="maskIt(this, event, '###.###.###-##')"><br><br>

                    <input type="submit" value="Excluir Paciente">                

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
