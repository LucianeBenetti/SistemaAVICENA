<%-- 
    Document   : MostrarReceitaCadatrada
    Created on : 28/08/2019, 11:17:22
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="Prontuario/ProntuarioCRUD.css">
    <title>Receita Cadastrada</title>
</head>
<body class="body">
    <br><br>
    <hr>

    <%
        Object obj1 = request.getAttribute("receitacadastrada");
        if (obj1 != null) {
            Boolean receitaCadastrada = (Boolean) obj1;
            if (receitaCadastrada) {%> 

    <h1>O Receita foi cadastrada com os seguintes dados:</h1>
    <form>
        <div class="form1">      

            <fieldset><legend>Receita</legend>

                <br>
                Nome do Paciente: <br>                       
                <input type="text" readonly name="nomepaciente" size="50"  value="<%= request.getAttribute("nomepaciente")%>"><br><br>  
                Medicamentos: <br>                       
                <input type="text" readonly name="medicamentos"  size="50" value="<%= request.getAttribute("medicamentos")%>"><br><br>
                Exames: <br>
                <input type="text" name="exames"  size="50" readonly value="<%= request.getAttribute("exames")%>"> <br><br>
                Registro de Observações:
                <input type="text" readonly name="registro"  size ="50" value="<%= request.getAttribute("registro")%>"><br><br>

                <br><br>
                <br><br>
            </fieldset>
        </div>
        <div class="form2">  
        </div>

        <%}}%>

        <form action="controledenavegacao" method="POST">
            <input type="hidden" id="avicena" name="avicena" value="avicena">
            <input type="submit" value="Imprimir Receita">
        </form>

<footer class="footer">                
    &copy; Desenvolvido por Luciane Benetti e Marco Sena.
</footer>

</body>
</html>
