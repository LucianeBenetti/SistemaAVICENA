<%-- 
    Document   : MostarConvenioCadastrado
    Created on : 17/05/2019, 13:39:55
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="Convenio/CRUDConvenio.css">
    <title>Convênio Cadastrado</title>
</head>
<body class="body">
    <br><br>
    <hr>

    <%
        Object obj1 = request.getAttribute("conveniocadastrado");

        if (obj1 != null) {
            Boolean convenioCadastrado = (Boolean) obj1;

            if (convenioCadastrado) {%> 

    <h1>O Convênio foi cadastrado com os seguintes dados:</h1>
    <form>
        <div class="form1">      

            <fieldset><legend>Convênio</legend>
                <br>
                Identificação: <br>
                <input type="text" readonly size ="5" value="<%= request.getAttribute("idconvenio")%>"><br><br>
                Nome: <br>
                <input type="text" readonly size ="67" value="<%= request.getAttribute("nomeconvenio")%>"><br><br>

                <div style="width:67%">
                    <div style="float:left"> CNPJ<a>*</a>: </div>
                    <div style="float:right"> Valor </div>
                </div>
                <br>
                <div style="width:80%">
                    <div style="float:left"> <input type="text" readonly size="25" value="<%= request.getAttribute("cnpjconvenio")%>" onkeyup="maskIt(this, event, '##.###.###/####-##')"></div>    
                    <div style="float:right"> <input type="text" readonly size="25" value="<%= request.getAttribute("valor")%>" onkeyup="maskIt(this, event, '###.###.###,##', true, {pre: 'R$', pos: ''})"></div>
                </div>
                <br><br>

                <br><br>
            </fieldset>
        </div>
        <div class="form2">  
        </div>

        <%} else {%>
        <br> 
        <h1>Resultado do cadastro do Convênio:</h1>            
        <br>             
        <input type="text" readonly size="40" style="margin-left: 5px;" value="<% out.println("Convênio já cadastrado na base de dados!");%>">
        <%}%>
        <%}%>
    </form>
    <br><br>
    <form action="controledenavegacao" method="POST">
        <input type="hidden" id="avicena" name="avicena" value="avicena">
        <input type="submit" value="Voltar">
    </form>

    <footer class="footer">                
        &copy; Desenvolvido por Luciane Benetti e Marco Sena.
    </footer>

</body>
</html>
