<%-- 
    Document   : MostrarMedicoCadastrado
    Created on : 16/05/2019, 13:27:13
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="Medico/CRUDMedico.css">
    <title>Médico Cadastrado</title>
</head>
<body class="body">
    <br><br>
    <hr>
    <%
        Object obj1 = request.getAttribute("medicocadastrado");

        if (obj1 != null) {
            Boolean medicoCadastrado = (Boolean) obj1;

            if (medicoCadastrado) {%> 

    <h1>O Médico foi cadastrado com os seguintes dados:</h1>
    <form>
        <div class="form1">      

            <fieldset><legend>Médico</legend>
                <br>
                Identificação: <br>
                <input type="text" readonly="" size ="5" value="<%= request.getAttribute("idmedico")%>"><br><br>
                Nome: <br>
                <input type="text" readonly size ="67" value="<%= request.getAttribute("nomemedico")%>"><br><br>

                <div style="width:67%">
                    <div style="float:left"> Celular Whats App<a>*</a>: </div>
                    <div style="float:right"> Celular: </div>
                </div>
                <br>
                <div style="width:82%">
                    <div style="float:left"> <input type="text" readonly size="25" value="<%= request.getAttribute("celularwhats")%>" onkeyup="maskIt(this, event, '(##)####-####')"></div>    
                    <div style="float:right"> <input type="text" readonly size="25" value="<%= request.getAttribute("celularmedico")%>" onkeyup="maskIt(this, event, '(##)####-####')"></div>
                </div>
                <br><br>
                e-mail:<br>
                <input type="email" readonly size="67" value="<%= request.getAttribute("email")%>"><br><br>

                CRM:<br>
                <input type="crm" readonly size="67" value="<%= request.getAttribute("crm")%>"><br><br>

                <div style="width:55%">
                    <div style="float:left"> CPF<a>*</a>: </div>
                    <div style="float:right"> CNPJ: </div>
                </div>
                <br>
                <div style="width:82%">
                    <div style="float:left"> <input type="text" readonly size="25" value="<%= request.getAttribute("cpfmedico")%>" onkeyup="maskIt(this, event, '###.###.###-##')"></div>    
                    <div style="float:right"> <input type="text" readonly size="25" value="<%= request.getAttribute("cnpjmedico")%>"></div>
                </div>
                <br><br>
            </fieldset>
        </div>
        <div class="form2">  
        </div>
        <%} else {%>
        <div class="principal">
            <div class="secao3">
            </div>
            <div class="cadastro">
                <br> 
                <h3>Resultado do cadastro do Médico</h3>     
                  <fieldset><legend>Médico</legend>
                       
                <br>             
                <input type="text" readonly size="40" style="margin-left: 5px;" value="<% out.println("Médico já cadastrado na base de dados!");%>">

                <%}%>

                <%}%>
                </form> 
                <br><br>

                <div class="secao4">

                </div>
                </fieldset>
                <br><br>
                <div>
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

