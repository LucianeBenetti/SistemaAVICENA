<%-- 
    Document   : PesquisarConvenioPorCnpj
    Created on : 17/05/2019, 14:16:20
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="mascarasConvenio.js"></script>
        <script type="text/javascript" src="Convenio/mascarasConvenio.js"></script>
        <link type="text/css" rel="stylesheet" href="CRUDConvenio.css">
        <link type="text/css" rel="stylesheet" href="Convenio/CRUDConvenio.css">
        <title>Pesquisa de Convênios por CNPJ</title>
    </head>
    <body class="body">

        <div class="consultaCPF">
            <h2>Pesquisar Convênio por CNPJ!</h2>

            <form method="post" action="../pesquisarconvenioporcnpj">

                <fieldset><legend>Digite o CNPJ do Convênio a ser consultado na base de dados</legend>
                    <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                    CPF<a>*</a>:<br> 
                    <input type="text" name="cnpjconvenio" required onkeyup="maskIt(this, event, '##.###.###/####-##')"><br><br>
                    <input type="submit" value = "Pesquisar Convenio">                

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

        <div class="resultadodaconsultaCPF">
            <h2>Resultado da pesquisa de Convenio por CPF:</h2>

            <%
                Object obj = request.getAttribute("conveniovoretornado");

                if (obj != null) {
                    Boolean ConvenioVORetornado = (Boolean) obj;

                    if (!ConvenioVORetornado) {%>                     
                   <input type="text" size="100" style="margin-left: 5px;" value="<% out.println("Convênio não encontrado!"
                        + " Tente novamente. Se o Convênio não for cadastrado, por gentileza, cadastrá-lo!!");%>">               
            <%} else {%>

            <form action="atualizarconvenio" method="post">

                <fieldset><legend>Dados do Convenio</legend>
                    Nome: <br>                       
                    <input type="text" name="nomeconvenio" size="77" value="<%= request.getAttribute("nomeconvenio")%>"><br><br>            

                    <div style="width:61.5%">
                        <div style="float:left"> CNPJ<a>*</a>: </div>
                        <div style="float:right"> Valor<a>*</a>: </div>
                    </div>
                    <br>
                    <div style="width:80%">

                        <div style="float:left"> <input type="text" name="cnpjconvenio" onkeyup="maskIt(this, event, '##.###.###/####-##')" value="<%= request.getAttribute("cnpjconvenio")%>" required size="31"></div>    
                        <div style="float:right"><input type="text" name="valor" onkeyup="maskIt(this, event, '###.###.###,##', true, {pre: 'R$', pos: ''})" value="<%= request.getAttribute("valor")%>" required size="31"></div>
                    </div>
                    <br><br>
                  
                    <br><br>

                    <input type="submit" value="Atualizar Dados do Convênio">
                </fieldset>
            </form><br><br>
            <%}
                }%>      
        </div>            

        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>

    </body>
</html>

