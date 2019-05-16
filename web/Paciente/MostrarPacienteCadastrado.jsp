<%-- 
    Document   : MostrarPacienteCadastrado
    Created on : 12/03/2019, 13:14:30
    Author     : 80119050
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Paciente/CRUDPaciente.css">
        <title>Cliente Cadastrado</title>
    </head>
    <body class="body">
        <br><br>
        <hr>
        <h1>O Paciente foi cadastrado com os seguintes dados:</h1>

        <div class="form1">
            <form>

                <fieldset><legend>Paciente</legend>
                    <br>
                    Identificação: <br>
                    <input type="text" size ="5" value="<%= request.getAttribute("idpaciente")%>"><br><br>
                    Nome: <br>
                    <input type="text" size ="67" value="<%= request.getAttribute("nomepaciente")%>"><br><br>

                    <div style="width:67%">
                        <div style="float:left"> Celular<a>*</a>: </div>
                        <div style="float:right"> Fone Residencial: </div>
                    </div>
                    <br>
                    <div style="width:82%">

                        <div style="float:left"> <input type="text" size="25" value="<%= request.getAttribute("celularpaciente")%>" onkeyup="maskIt(this, event, '(##)####-####')"></div>    
                        <div style="float:right"> <input type="text" size="25" value="<%= request.getAttribute("foneresidencial")%>" onkeyup="maskIt(this, event, '(##)####-####')"></div>
                    </div>
                    <br><br>

                    Fone Comercial: <br>
                    <input type="text" size="30" value="<%= request.getAttribute("fonecomercial")%>" onkeyup="maskIt(this, event, '(##)####-####')"><br><br>
                    e-mail:<br>
                    <input type="email" size="67" value="<%= request.getAttribute("email")%>"><br><br>
                    
                    <div style="width:55%">
                        <div style="float:left"> CPF<a>*</a>: </div>
                        <div style="float:right"> CNPJ: </div>
                    </div>
                    <br>
                    <div style="width:82%">
                        <div style="float:left"> <input type="text" size="25" value="<%= request.getAttribute("cpfpaciente")%>" onkeyup="maskIt(this, event, '###.###.###-##')"></div>    
                        <div style="float:right"> <input type="text" size="25" value="<%= request.getAttribute("cnpjpaciente")%>"></div>
                    </div>
                    <br><br>

                </fieldset>

                <br><br>

                <br>
                </div>


                <div class="form2">

                    <fieldset><legend>Endereço</legend>
                        <br>

                        <div style="width:100%">
                            <div style="float:left"> Rua<a>*</a>: </div>
                            <div style="float:right"> Num<a>*</a>: </div>
                        </div>  
                        <br>
                        <div style="width:100%">
                            <div style="float:left"> <input type="text" size="70" value="<%= request.getAttribute("logradouro")%>"></div>    
                            <div style="float:right"> <input type="text" size="3" value="<%= request.getAttribute("numlogradouro")%>"></div>
                        </div>  
                        <br><br>
                        Complemento: <br>
                        <input type="text" size="70" value="<%= request.getAttribute("complemento")%>"><br><br>

                        <div style="width:64%">
                            <div style="float:left"> Bairro<a>*</a>: </div>
                            <div style="float:right"> Cidade<a>*</a>: </div>
                        </div>
                        <br>
                        <div style="width:82%">
                            <div style="float:left">  <input type="text" value="<%= request.getAttribute("bairro")%>"></div>    
                            <div style="float:right"> <input type="text" value="<%= request.getAttribute("cidade")%>"></div>
                        </div>                    

                        <br><br>
                        <div style="width:60%">
                            <div style="float:left"> UF<a>*</a>: </div>
                            <div style="float:right"> CEP: </div>
                        </div>
                        <br>
                        <div style="width:82%">
                            <div style="float:left">  <select style="width:150px;" value="<%= request.getAttribute("uf")%>"></select></div>    
                            <div style="float:right"> <input type="text" value="<%= request.getAttribute("cep")%>"> </div>
                        </div>                    
                        <br><br>

                        <br><br>
                    </fieldset>
                </div>
            </form> 
            <div>
                <form action="controledenavegacao" method="POST">
                    <input type="hidden" id="avicena" name="avicena" value="avicena">
                    <input type="submit" value="Voltar">
                </form>
            </div>
            <footer class="footer">                
                &copy; Desenvolvido por Luciane Benetti e Marco Sena.
            </footer>

    </body>
</html>
