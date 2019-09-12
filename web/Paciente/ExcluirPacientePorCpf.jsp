<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Avicena</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <style>
            .generico
            {text-align: center; border-color: transparent; color: red; padding: 10px}
        </style>
    </head>
<body>

        <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; 
             background-color: #7986cb; padding: 20px; color: white">
            <h1>Sistema Avicena</h1>
            <p>Medicina Humanizada</p> 
        </div>
    <div class="container" style="padding: 3px; margin-top: 2%; margin-bottom: 10%;" >

        <div class="container" style="padding: 3px; margin-top: 2%; margin-bottom: 10%;" >
            
            <div class="form" style="background-color: #c8e6c9; padding: 10px; width: 60%;  
                 border-radius: 10px; float: left; margin-left: 20%;">
            
            <p style="text-align: center; font-weight: bold">Digite o CPF do Paciente que deseja excluir da base de dados:</p>

                
            <form action="../crudpaciente" class="was-validated" method="post">
                    <div class="form-group">
                        <input type="hidden" id="excluir" name="excluir" value="excluir">
                        <label for="cpf">CPF:</label>
                        <input type="text" class="form-control" id="cpf" name="cpfpaciente" placeholder="Digite o CPF do paciente"  style="border-color: gray" required>
                        <div class="valid-feedback">Valido.</div>
                        <div class="invalid-feedback" style = "color: black">Campo obrigatório.</div>
                    </div>
                
                <button type="submit" class="btn btn-primary" style="float: left" >Excluir Paciente</button>
            </form>
             
            <form action="../controledenavegacao" method="post">

                    <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                    <input type="submit" value = "Voltar" class="btn btn-primary" 
                           style=" margin-left: 20px; float: left;">            
                </form>            
                
            </div>
            
        </div>
    </div>
        
    <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0; margin-top: 25%; 
             background-color: #7986cb;padding: 4px; color: white; font-size: small; ">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </div>

</body>
</html>