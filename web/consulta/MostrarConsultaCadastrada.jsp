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


        <style>
            .generico {border-color: transparent; color: blue; padding: 10px; background-color: #c8e6c9}
        </style>
    </head>

    <body>

        <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; background-color: #7986cb; padding: 5px; color: white">
            <h4>Sistema Avicena</h4>
            Medicina Humanizada 
        </div>

        <div class="form" style="float: left; background-color: #c8e6c9; padding: 10px; width: 80%; margin-left: 10%; margin-top: 2%; background-color: #c8e6c9; 
             padding: 20px; border-radius: 10px;">

            <p style="text-align: center; font-weight: bold">Resultado do Cadastro de Consulta:</p>

            <%
                Object obj1 = request.getAttribute("consultacadastrada");

                if (obj1 != null) {
                    Boolean consultaCadastrada = (Boolean) obj1;

                    if (!consultaCadastrada) {%> 

            <div class="container-fluid" style="margin-right: auto; margin-left: auto;">
                   <input class="generico" type="text" size="100" value="<% out.println("Consulta já cadastrada na base de dados ou a data da consulta é inferior ou igual a data atual!" + "\n"
                               + "Por gentileza, cadastrar novamente!");%>">
            </div>

            <%} else {%>  

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputnome">Nome:</label>
                    <input type="text" readonly class="form-control" id="inputnome" name="nomepaciente" value="<%= request.getAttribute("nomepaciente")%>">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputconvenio">Convênio:</label>
                    <input type="convenio" readonly class="form-control" id="inputconvenio" name="nomeconvenio" value="<%= request.getAttribute("nomeconvenio")%>">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputmedico">Medico:</label>
                    <input type="text" readonly class="form-control" id="inputmedico" name="nomemedico" 
                           value="<%= request.getAttribute("nomemedico")%>">
                </div>

                <div class="form-group col-md-6">
                    <label for="inputespecialidade">Especialidade</label>
                    <input type="text" readonly class="form-control" id="inputespecialidade" name="nomeespecialidade" 
                           value="<%= request.getAttribute("nomeespecialidade")%>">
                </div>

            </div>
            <div class="form-row">
                <div class="form-group col-md-3">
                    <label for="inputdataconsulta">Data da Consulta:</label>
                    <input type="text" readonly class="form-control" id="inputdataconsulta" name="dataconsulta" value="<%= request.getAttribute("dataconsulta")%>">
                </div>
                <div class="form-group col-md-3">
                    <label for="inputhorarioconsulta">Horário da Consulta:</label>
                    <input type="text" readonly class="form-control" id="inputhorarioconsulta" name="horarioconsulta" value="<%= request.getAttribute("horarioconsulta")%>">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputatencaoespecial">Atenção Especial:</label>
                    <input type="text" readonly class="form-control" id="inputatencaoespecial" name="atencaoespecial" value="<%= request.getAttribute("atencaoespecial")%>"></textarea>
                </div>
            </div>
            <% }
                }%> 
            <form action="controledenavegacao" method="POST">
                <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                <input type="submit" value = "Voltar" class="btn btn-primary" 
                       style="margin-top: 2%; margin-left: 1%; float: left;">            
            </form>        
        </div>    

        <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0;margin-top: 45%; 
             background-color: #7986cb;padding: 4px; color: white; font-size: small; ">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </div> 

    </body>
</html>
