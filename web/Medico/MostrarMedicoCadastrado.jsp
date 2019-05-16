<%-- 
    Document   : MostrarMedicoCadastrado
    Created on : 16/05/2019, 13:27:13
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="Medico/MedicoCRUD.css">
    <title>Cliente Cadastrado</title>
</head>
<body class="body">
    <br><br>
    <hr>
    <h1>O Medico foi cadastrado com os seguintes dados:</h1>

    <div class="form1">
        <form>

            <fieldset><legend>Medico</legend>
                <br>
                Identificação: <br>
                <input type="text" size ="5" value="<%= request.getAttribute("idmedico")%>"><br><br>
                Nome: <br>
                <input type="text" size ="67" value="<%= request.getAttribute("nomemedico")%>"><br><br>

                <div style="width:67%">
                    <div style="float:left"> Celular Whats App<a>*</a>: </div>
                    <div style="float:right"> Celular: </div>
                </div>
                <br>
                <div style="width:82%">

                    <div style="float:left"> <input type="text" size="25" value="<%= request.getAttribute("celularwhats")%>" onkeyup="maskIt(this, event, '(##)####-####')"></div>    
                    <div style="float:right"> <input type="text" size="25" value="<%= request.getAttribute("celularmedico")%>" onkeyup="maskIt(this, event, '(##)####-####')"></div>
                </div>
                <br><br>
                e-mail:<br>
                <input type="email" size="67" value="<%= request.getAttribute("email")%>"><br><br>

                CRM:<br>
                <input type="crm" size="67" value="<%= request.getAttribute("crm")%>"><br><br>

                <div style="width:55%">
                    <div style="float:left"> CPF<a>*</a>: </div>
                    <div style="float:right"> CNPJ: </div>
                </div>
                <br>
                <div style="width:82%">
                    <div style="float:left"> <input type="text" size="25" value="<%= request.getAttribute("cpfmedico")%>" onkeyup="maskIt(this, event, '###.###.###-##')"></div>    
                    <div style="float:right"> <input type="text" size="25" value="<%= request.getAttribute("cnpjmedico")%>"></div>
                </div>
                <br><br>

            </fieldset>

            <br><br>

            <div>
                <form action="controledenavegacao" method="POST">
                    <input type="hidden" id="avicena" name="avicena" value="avicena">
                    <input type="submit" value="Voltar">
                </form>
            </div>
    </div>

</form> 

<footer class="footer">                
    &copy; Desenvolvido por Luciane Benetti e Marco Sena.
</footer>

</body>
</html>

