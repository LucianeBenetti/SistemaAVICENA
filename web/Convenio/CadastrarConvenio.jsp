<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema Avicena</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
         <script type="text/javascript" src="mascarasConvenio.js"></script>
    </head>

    <body> 

        <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0;
             background-color: #7986cb; padding: 5px; color: white">
            <h4>Sistema Avicena</h4>
            Medicina Humanizada 
        </div>

        <div class="form" style="float: left; width: 80%; margin-left: 10%; margin-top: 2%; background-color: #c8e6c9; 
             padding: 20px; border-radius: 10px;">

            <h3 style="text-align: center; padding: 20px;">Por gentileza, preencher os dados do convênio a ser cadastrado:</h3>            

            <form action="../crudconvenio" method="POST">
                <input type="hidden" id="cadastrar" name="cadastrar" value="cadastrar">

                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="inputnome">Nome:</label>
                        <input type="text" class="form-control" id="inputnome" name="nomeconvenio" placeholder="Digite o nome do convênio">
                    </div>
                </div>

                <div class="form-row">

                    <div class="form-group col-md-8" style="size:30px">
                        <label for="inputcnpj">CNPJ:</label>
                        <input type="text" class="form-control" id="inputcnpj" name="cnpjconvenio" placeholder="Digite o CNPJ do convênio" onkeyup="maskIt(this, event, '##.###.###/####-##')">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputvalor">Valor</label>
                        <input type="text" class="form-control" id="inputvalor" name="valor" placeholder="Digite o valor do convênio" required onkeyup="maskIt(this, event, '###.###.###,##', true, {pre: 'R$ ', pos: ' '})">
                    </div>
                </div>
                <br><br>               

                <div class="form-row">

                    <button type="submit" class="btn btn-primary" style=" float: left; margin-left: 1.5%">Cadastrar Convênio</button> 

                </div>
            </form>

            <form action="../controledenavegacao" method="POST">
                <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                <input type="submit" value = "Voltar" class="btn btn-primary" 
                       style=" margin-left: 1%; float: left;">            
            </form>
        </div>
     
        <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0; margin-top: 45%;
             background-color: #7986cb; padding: 4px; color: white; font-size: 10pt;">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </div>
    </body>   
</html>
