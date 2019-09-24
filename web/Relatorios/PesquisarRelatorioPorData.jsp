<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>    
        <meta charset= "utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <style>
            /* Make the image fully responsive */
            .carousel-inner img {
                width: 100%;
            }

            .generico
            {text-align: center; border-color: transparent; color: red; padding: 10px}

        </style> 
        <title>Sistema Avicena</title> 
    </head>
    <body>  
        <nav class="navbar navbar-expand-sm navbar-dark justify-content-left" 
             style= "background-color: #7986cb; font-size: 18px; color: #ffffff; ">
            <a class="navbar-brand">
                <img src="../icon2.png" alt="logo" style="width:50px; height: 30px;">
            </a>
            <ul class="navbar-nav">
                <form action="../controledenavegacao" method="POST">
                    <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                    <input type="submit" value="Inicio" style="border:none; background-color: #7986cb; color: white; padding: 8px;">
                </form>  
                <li>
                    <form action="../controledenavegacao" method="POST">
                        <input type="hidden" id="sair" name="sair" value="sair">
                        <input type="submit" value="Sair" style="border:none; background-color: #7986cb; color: white; padding: 8px;">
                    </form>
                </li>
            </ul>
        </nav>

        <div class="container-fluid">
            
        <h3>Relatório de Faturamento</h3>
        <h5>Por gentileza, escolher o período para gerar o relatório de faturamento</h5>
        <br><br>
        <form method="post" action="../pesquisarconsultapordata">
            <script>
                $(function () {
                    $("#datainicial").datepicker({dateFormat: 'dd/mm/yy'});
                });
                $(function () {
                    $("#datafinal").datepicker({dateFormat: 'dd/mm/yy'});
                });
            </script>
            <div class="form-row">   
                <div class="form-group col-md-4">
                    <label for="inputdatainicial">Data Inicial:</label>
                    <input type="text"  class="form-control" id="datainicial" name="datainicial">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputdatafinal">Data Final: </label>
                    <input type="text"  class="form-control" id="datafinal" name="datafinal">
                </div>                       
            </div>
            <div class="form-row">
                <input type="hidden" id="gerarrelatorio" name="gerarrelatorio" value="gerarrelatorio">
                <button type="submit" class="btn btn-primary" style=" float: left; margin-left: 1.5%">Buscar Período Selecionado</button> 
            </div>

        </form>
    </div>

    <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0; margin-top: 45%;
         background-color: #7986cb; padding: 4px; color: white; font-size: 10pt;">
        &copy; Desenvolvido por Luciane Benetti e Marco Sena.
    </div>
</body>
</html>