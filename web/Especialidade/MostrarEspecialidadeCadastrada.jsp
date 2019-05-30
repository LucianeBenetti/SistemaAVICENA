<%-- 
    Document   : MostrarEspecialidadeCadastrada
    Created on : 20/05/2019, 10:28:37
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="Especialidade/EspecialidadeCRUD.css">
    <title>Especialidade Cadastrada</title>
</head>
<body class="body">
    <br><br>
    <hr>

    <%
        Object obj1 = request.getAttribute("especialidadecadastrada");

        if (obj1 != null) {
            Boolean especialidadeCadastrada = (Boolean) obj1;

            if (especialidadeCadastrada) {%> 

    <h1>A especialidade foi cadastrada com os seguintes dados:</h1>
    <form>
        <div class="form1">      

            <fieldset><legend>Especialidade</legend>
                <br>
                Identificação: <br>
                <input type="text" readonly size ="5" value="<%= request.getAttribute("idespecialidade")%>"><br><br>
                Nome: <br>
                <input type="text" readonly size ="67" value="<%= request.getAttribute("nomeespecialidade")%>"><br><br>
                Instituição: <br>
                <input type="text" readonly size ="67" value="<%= request.getAttribute("instituicaoespecialidade")%>"><br><br>
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
                <h3>Resultado do cadastro da Especialidade</h3>     
                <fieldset><legend>Especialidade</legend>

                    <br>             
                    <input type="text" readonly size="40" style="margin-left: 5px;" value="<% out.println("Especialidade já cadastrada na base de dados!");%>">

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
