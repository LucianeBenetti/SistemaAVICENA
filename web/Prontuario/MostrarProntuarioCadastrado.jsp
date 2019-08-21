<%-- 
    Document   : MostrarProntuarioCadastrado
    Created on : 21/08/2019, 15:32:57
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="Prontuario/ProntuarioCRUD.css">
    <title>Prontuario Cadastrado</title>
</head>
<body class="body">
    <br><br>
    <hr>

    <%
        Object obj1 = request.getAttribute("prontuariocadastrado");
        if (obj1 != null) {
            Boolean prontuarioCadastrada = (Boolean) obj1;
            if (prontuarioCadastrada) {%> 

    <h1>O Prontuario foi cadastrado com os seguintes dados:</h1>
    <form>
        <div class="form1">      

            <fieldset><legend>Prontuario</legend>

                <br>
                Nome do Paciente: <br>                       
                <input type="text" readonly name="nomepaciente" size="50"  value="<%= request.getAttribute("nomepaciente")%>"><br><br>  
                Medicamentos: <br>                       
                <input type="text" readonly name="medicamentos"  size="50" value="<%= request.getAttribute("medicamentos")%>"><br><br>
                Exames: <br>
                <input type="text" name="exames"  size="50" readonly value="<%= request.getAttribute("exames")%>"> <br><br>
                Procedimentos: <br>
                <input type="text" name="procedimentos"  size="50" readonly value="<%= request.getAttribute("procedimentos")%>"> <br><br>
                Registro de Observações:
                <input type="text" readonly name="registro"  size ="50" value="<%= request.getAttribute("registro")%>"><br><br>

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
                <h3>Resultado do cadastro da Prontuario</h3>     
                <fieldset><legend>Prontuario</legend>
                    <br>             
                    <% out.println("Prontuario já cadastrada na base de dados!");%>
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
