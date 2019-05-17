<%-- 
    Document   : PesquisarMedicoPorCPF
    Created on : 08/05/2019, 15:11:41
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="mascarasMedico.js"></script>
        <script type="text/javascript" src="Medico/mascarasMedico.js"></script>
        <link type="text/css" rel="stylesheet" href="CRUDMedico.css">
        <link type="text/css" rel="stylesheet" href="Medico/CRUDMedico.css">
        <title>Pesquisa de Medicos por CPF</title>
    </head>
    <body class="body">

        <div class="consultaCPF">
            <h2>Pesquisar Medico por CPF!</h2>

            <form method="post" action="../pesquisarmedicoporcpf">

                <fieldset><legend>Digite o CPF do Medico a ser consultado na base de dados</legend>
                    <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                    CPF<a>*</a>:<br> 
                    <input type="text" name="cpfmedico" required onkeyup="maskIt(this, event, '###.###.###-##')"><br><br>
                    <input type="submit" value = "Pesquisar Medico">                

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
            <h2>Resultado da pesquisa de Medico por CPF:</h2>

            <%
                Object obj = request.getAttribute("medicovoretornado");

                if (obj != null) {
                    Boolean MedicoVORetornado = (Boolean) obj;

                    if (!MedicoVORetornado) {%>                     
            <input type="text" size="100" style="margin-left: 5px;" value="<% out.println("Medico não encontrado!"
                               + " Tente novamente. Se o Medico não for cadastrado, por gentileza, cadastrá-lo!!");%>">               
            <%} else {%>

            <form action="atualizarmedico" method="post">

                <fieldset><legend>Dados do Medico</legend>
                    Nome: <br>                       
                    <input type="text" name="nomemedico" size="77" value="<%= request.getAttribute("nomemedico")%>"><br><br>            

                    <div style="width:61.5%">
                        <div style="float:left"> Celular Whast App<a>*</a>: </div>
                        <div style="float:right"> Celular: </div>
                    </div>
                    <br>
                    <div style="width:80%">

                        <div style="float:left"> <input type="text" name="celularwhats" onkeyup="maskIt(this, event, '(##)####-####')" value="<%= request.getAttribute("celularwhats")%>" required size="31"></div>    
                        <div style="float:right"><input type="text" name="celularmedico" onkeyup="maskIt(this, event, '(##)####-####')" value="<%= request.getAttribute("celularmedico")%>"size="31"></div>
                    </div>
                    <br><br>
                    e-mail: <br>
                    <input type="email" name="email" value="<%= request.getAttribute("email")%>" size="77"><br><br>

                    CRM: <br>
                    <input type="crm" name="crm" value="<%= request.getAttribute("crm")%>" size="77"><br><br>

                    <div style="width:51%">
                        <div style="float:left"> CPF<a>*</a>: </div>
                        <div style="float:right"> CNPJ: </div>
                    </div>
                    <br>
                    <div style="width:80%">
                        <div style="float:left">  <input type="text" name="cpfmedico" size="31" onkeyup="maskIt(this, event, '###.###.###-##')" value="<%= request.getAttribute("cpfmedico")%>" required ></div>    
                        <div style="float:right"> <input type="text" name="cnpjmedico" size="31" onkeyup="maskIt(this, event, '##.###.###/####-##')" value="<%= request.getAttribute("cnpjmedico")%>"></div>
                    </div>
                    <br><br>
                           
                    <br><br>

                    <input type="submit" value="Atualizar Dados do Medico">
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

