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
        <script type="text/javascript" src="mascarasPaciente.js"></script>
        <script type="text/javascript" src="Paciente/mascarasPaciente.js"></script>

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
                    <input type="text" class="form-control" id="inputnome" name="nomepaciente" value="<%= request.getAttribute("nomepaciente")%>">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputconvenio">Convênio:</label>
                    <input type="convenio" class="form-control" id="inputconvenio" name="nomeconvenio" value="<%= request.getAttribute("nomeconvenio")%>">">
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="inputmedico">Medico:</label>
                    <input type="text" class="form-control" id="inputmedico" name="nomemedico" 
                           value="<%= request.getAttribute("nomemedico")%>">
                </div>

                <div class="form-group col-md-4">
                    <label for="inputespecialidade">Especialidade</label>
                    <input type="text" class="form-control" id="inputespecialidade" name="nomeespecialidade" 
                           value="<%= request.getAttribute("nomeespecialidade")%>">
                </div>

            </div>
            <div class="form-group col-md-4">
                <label for="inputdataconsulta">Data da Consulta:</label>
                <input type="text" class="form-control" id="inputdataconsulta" name="dataconsulta" placeholder="Digite o fone residencial do paciente" 
                       value="<%= request.getAttribute("dataconsulta")%>">
            </div>
            <div class="form-group col-md-4">
                <label for="inputhorarioconsulta">Horário da Consulta:</label>
                <input type="text" class="form-control" id="inputhorarioconsulta" name="horarioconsulta" placeholder=" Digite o fone comercial do paciente" 
                       value="<%= request.getAttribute("horarioconsulta")%>">
            </div>
        </div>



        <div class="form-group col-md-3">
            <label for="inputcidade">Atenção Especial:</label>
            <input type="text" class="form-control" id="inputcidade" name="cidade" placeholder="Digite a cidade"
                   value="<%= request.getAttribute("cidade")%>">
        </div>


        <h1>A Consulta foi cadastrada com os seguintes dados:</h1>
        <form>
            <div class="form1">      

                <fieldset><legend>Consulta</legend>
                    <br>
                    Nome do Paciente: <br>                       
                    <input type="text" readonly name="nomepaciente" size="50"  value="<%= request.getAttribute("nomepaciente")%>"><br><br>  
                    Nome do Convênio <br>                       
                    <input type="text" readonly name="nomeconvenio"  size="50" value="<%= request.getAttribute("nomeconvenio")%>"><br><br>
                    Nome do Médico: <br>
                    <input type="text" name="nomemedico"  size="50" readonly value="<%= request.getAttribute("nomemedico")%>"> <br><br>
                    Nome da Especialidade: <br>
                    <input type="text" name="nomeespecialidade"  size="50" readonly value="<%= request.getAttribute("nomeespecialidade")%>"> <br><br>
                    <div style="width:55%">
                        <div style="float:left"> Data da Consulta: </div>
                        <div style="float:right"> Horário da Consulta: </div>
                    </div>
                    <br>
                    <div style="width:80%">
                        <div style="float:left"> <input type="text" name="dataconsulta" size="20" value="<%= request.getAttribute("dataconsulta")%>"></div>    
                        <div style="float:left"> <input type="text" name="horarioconsulta" size="20" value="<%= request.getAttribute("horarioconsulta")%>"></div>  <br><br>  
                    </div>
                    Atenção Especial:
                    <input type="text" readonly size ="50" value="<%= request.getAttribute("atençãoespecial")%>"><br><br>

                    <br><br>
                    <br><br>
                </fieldset>
            </div>
            <div class="form2">  
            </div>

          
                        <form action="controledenavegacao" method="POST">
                            <input type="hidden" id="avicena" name="avicena" value="avicena">
                            <input type="submit" value="Voltar">
                        </form>
                    </div>   
                </div>     
            </div>
            <footer class="footer">                
                &copy; Desenvolvido por Luciane Benetti e Marco Sena.
            </footer>

    </body>
</html>
