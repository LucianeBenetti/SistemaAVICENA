<%-- 
    Document   : ExcluirMedico
    Created on : 08/05/2019, 15:11:53
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
        <title>Excluir Medico por CPF</title>
    </head>
    <body class="body">

        <div class="excluirCPF">
            <h3>Excluir Medico por CPF!</h3>

            <form method="post" action="../crudmedico">

                <fieldset><legend>Digite o CPF do Medico que deseja excluir da base de dados:</legend>
                    <p><a>*</a>Campos de preenchimento obrigatório</p>                    
                    <input type="hidden" id="excluir" name="excluir" value="excluir">
                    CPF<a>*</a>: <br>
                    <input type="text" name="cpfmedico" required onkeyup="maskIt(this, event, '###.###.###-##')"><br><br>

                    <input type="submit" value="Excluir Medico">                

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
