<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Avicena</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="Convenio/mascarasConvenio.js"></script>

        <style>
            .generico {border-color: transparent; color: red; padding: 10px; background-color: #c8e6c9}
        </style>
    </head>

    <body>

        <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; background-color: #7986cb; padding: 5px; color: white">
            <h4>Sistema Avicena</h4>
            Medicina Humanizada 
        </div>


        <div class="form" style="float: left; background-color: #c8e6c9; padding: 10px; width: 80%; margin-left: 10%; margin-top: 2%; background-color: #c8e6c9; 
             padding: 20px; border-radius: 10px;">

            <h3 style="text-align: center; padding: 20px;">Dados do convênio a ser alterado</h3>            

            <%
                Object obj = request.getAttribute("conveniovoretornado");

                if (obj != null) {
                    Boolean ConvenioVORetornado = (Boolean) obj;

                    if (ConvenioVORetornado) {%>                     

            <form action="atualizarconvenio" method="post">
                <p style="text-align: center; font-weight: bold">Resultado da pesquisa de Convênio por CNPJ</p>
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label for="inputnome">Nome:</label>
                        <input type="text" class="form-control" id="inputnome" name="nomeconvenio" value="<%= request.getAttribute("nomeconvenio")%>"><br><br>
                    </div>
                </div>

                <div class="form-row">

                    <div class="form-group col-md-8" style="size:30px">
                        <label for="inputcnpj">CNPJ:</label>
                        <input type="text" class="form-control" id="inputcnpj" name="cnpjconvenio" onkeyup="maskIt(this, event, '##.###.###/####-##')" value="<%= request.getAttribute("cnpjconvenio")%>" required size="31">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputvalor">Valor</label>
                        <input type="text" class="form-control" id="inputvalor" name="valor" onkeyup="maskIt(this, event, '###.###.###,##', true, {pre: 'R$', pos: ''})" value="<%= request.getAttribute("valor")%>" required size="31">
                    </div>
                </div>
                <br><br>               

                <br><br>

                <%}
                    }%>    

                <div class="form-row">
                    <button type="submit" class="btn btn-primary" style=" float: left; margin-left: 1.5%">Atualizar Convênio</button> 
                </div>
            </form><br><br>

            <form action="controledenavegacao" method="POST">
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
