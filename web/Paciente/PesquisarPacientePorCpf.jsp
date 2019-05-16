<%-- 
    Document   : ConsultarPacientePorCpf
    Created on : 01/04/2019, 08:13:17
    Author     : 80119050
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="mascarasPaciente.js"></script>
        <script type="text/javascript" src="Paciente/mascarasPaciente.js"></script>
        <link type="text/css" rel="stylesheet" href="CRUDPaciente.css">
        <link type="text/css" rel="stylesheet" href="Paciente/CRUDPaciente.css">
        <title>Pesquisa de Pacientes por CPF</title>
    </head>
    <body class="body">

        <div class="consultaCPF">
            <h2>Pesquisar Paciente por CPF!</h2>

            <form method="post" action="../pesquisarpacienteporcpf">

                <fieldset><legend>Digite o CPF do Paciente a ser consultado na base de dados</legend>
                    <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                    CPF<a>*</a>:<br> 
                    <input type="text" name="cpfpaciente" required onkeyup="maskIt(this, event, '###.###.###-##')"><br><br>
                    <input type="submit" value = "Pesquisar Paciente">                

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
            <h2>Resultado da pesquisa de Paciente por CPF:</h2>

            <%
                Object obj = request.getAttribute("pacientevoretornado");

                if (obj != null) {
                    Boolean PacienteVORetornado = (Boolean) obj;

                    if (!PacienteVORetornado) {%>                     
                   <input type="text" size="100" style="margin-left: 5px;" value="<% out.println("Paciente não encontrado!"
                               + " Tente novamente. Se o Paciente não for cadastrado, por gentileza, cadastrá-lo!!");%>">               
            <%} else {%>

            <form action="atualizarpaciente" method="post">

                <fieldset><legend>Dados do Paciente</legend>
                    Nome: <br>                       
                    <input type="text" name="nomepaciente" size="77" value="<%= request.getAttribute("nomepaciente")%>"><br><br>            

                    <div style="width:61.5%">
                        <div style="float:left"> Celular<a>*</a>: </div>
                        <div style="float:right"> Fone Residencial: </div>
                    </div>
                    <br>
                    <div style="width:80%">

                        <div style="float:left"> <input type="text" name="celularpaciente" onkeyup="maskIt(this, event, '(##)####-####')" value="<%= request.getAttribute("celmenpaciente")%>" required size="31"></div>    
                        <div style="float:right"><input type="text" name="foneresidencial" onkeyup="maskIt(this, event, '(##)####-####')" value="<%= request.getAttribute("foneresidencial")%>"size="31"></div>
                    </div>
                    <br><br>
                    Fone Comercial: <br>
                    <input type="text" name="fonecomercial" onkeyup="maskIt(this, event, '(##)####-####')" value="<%= request.getAttribute("fonecomercial")%>"size="31">
                    <br><br>

                    e-mail: <br>
                    <input type="email" name="email" value="<%= request.getAttribute("email")%>" size="77"><br><br>

                    <div style="width:51%">
                        <div style="float:left"> CPF<a>*</a>: </div>
                        <div style="float:right"> CNPJ: </div>
                    </div>
                    <br>
                    <div style="width:80%">
                        <div style="float:left">  <input type="text" name="cpfpaciente" size="31" onkeyup="maskIt(this, event, '###.###.###-##')" value="<%= request.getAttribute("cpfpaciente")%>" required ></div>    
                        <div style="float:right"> <input type="text" name="cnpjpaciente" size="31" onkeyup="maskIt(this, event, '##.###.###/####-##')" value="<%= request.getAttribute("cnpjpaciente")%>"></div>
                    </div>
                    <br><br>

                    <div style="width:79%">
                        <div style="float:left"> Rua<a>*</a>: </div>
                        <div style="float:right"> Num<a>*</a>: </div>
                    </div>  
                    <br>
                    <div style="width:80%">
                        <div style="float:left"> <input type="text" name="logradouro" value="<%= request.getAttribute("logradouro")%>"required size="65"></div>    
                        <div style="float:right"> <input type="text" name="numlogradouro" value="<%= request.getAttribute("numlogradouro")%>" required size="3"></div>
                    </div>  
                    <br><br>
                    Complemento: <br>
                    <input type="text" name="complemento" value="<%= request.getAttribute("complemento")%>" size="77"><br><br>

                    <div style="width:53%">
                        <div style="float:left"> Bairro<a>*</a>: </div>
                        <div style="float:right"> Cidade<a>*</a>: </div>
                    </div>
                    <br>
                    <div style="width:80%">
                        <div style="float:left"> <input type="text" size="31" name="bairro" value="<%= request.getAttribute("bairro")%>" required></div>    
                        <div style="float:right"> <input type="text" size="31" name="cidade" value="<%= request.getAttribute("cidade")%>" required></div>
                    </div>                    
                    <br><br>

                    <div style="width:50%">
                        <div style="float:left"> UF<a>*</a>: </div>
                        <div style="float:right"> CEP: </div>
                    </div>
                    <br>
                    <div style="width:80%">
                        <div style="float:left"> <input type="text" size="31" name="uf" value="<%= request.getAttribute("uf")%>"required></div>    
                        <div style="float:right"> <input type="text" size="31" name="cep" onkeyup="maskIt(this, event, '#####-###')" value="<%= request.getAttribute("cep")%>"></div>
                    </div>                    
                    <br><br>

                    <input type="submit" value="Atualizar Dados do Paciente">
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
