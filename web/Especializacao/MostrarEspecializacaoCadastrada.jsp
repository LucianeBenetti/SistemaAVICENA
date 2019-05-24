<%-- 
    Document   : MostrarEspecializacaoCadastrada
    Created on : 22/05/2019, 15:30:57
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="Especializacao/CRUDEspecializacao.css">
    <title>Convênio Cadastrado</title>
</head>
<body class="body">
    <br><br>
    <hr>

    <%
        Object obj1 = request.getAttribute("especializacaocadastrada");

        if (obj1 != null) {
            Boolean especializacaoCadastrada = (Boolean) obj1;

            if (especializacaoCadastrada) {%> 

    <h1>O Convênio foi cadastrado com os seguintes dados:</h1>
    <form>
        <div class="form1">      

            <fieldset><legend>Especializacao</legend>
                <br>
                Identificação: <br>
                <input type="text" readonly size ="5" value="<%= request.getAttribute("idespecializacao")%>"><br><br>
                Nome Especialidade: <br>
                <input type="text" readonly size ="67" value="<%= request.getAttribute("nomeespecialidade")%>"><br><br>

                Nome Medico: <br>
                <input type="text" readonly size ="67" value="<%= request.getAttribute("nomemedico")%>"><br><br>

                <br><br>

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
                <h3>Resultado do cadastro da Especialização</h3>     
                <fieldset><legend>Especialização</legend>
                    <br>             
                    <input type="text" readonly size="40" style="margin-left: 5px;" value="<% out.println("Especialização já cadastrada na base de dados!");%>">
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
