<%-- 
    Document   : MostrarConsultaCadastrada
    Created on : 09/08/2019, 12:58:38
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="Consulta/ConsultaCRUD.css">
    <title>Consulta Cadastrada</title>
</head>
<body class="body">
    <br><br>
    <hr>

    <%
        Object obj1 = request.getAttribute("consultacadastrada");

        if (obj1 != null) {
            Boolean consultaCadastrada = (Boolean) obj1;

            if (consultaCadastrada) {%> 

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
                <input type="text" readonly size ="50" value="<%= request.getAttribute("atençãoEspecial")%>"><br><br>

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
                <h3>Resultado do cadastro da Consulta</h3>     
                <fieldset><legend>Consulta</legend>

                    <br>             
                    <% out.println("Consulta já cadastrada na base de dados!");%>

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
