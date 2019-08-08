<%-- 
    Document   : CadastrarPaciente
    Created on : 11/03/2019, 13:34:38
    Author     : 80119050
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="mascarasPaciente.js"></script>
        <link type="text/css" rel="stylesheet" href="PacienteCRUD.css">
        <link type="text/css" rel="stylesheet" href="Paciente/PacienteCRUD.css">
        <title>Cadastrar Paciente</title>
    </head>
    <body class="body">
        <hr>
        <h1>Cadastro de Paciente</h1>
        <h3>Por gentileza, preencher os dados do paciente a ser cadastrado:</h3> 
        <form action="../crudpaciente" method="POST">
            <div class="form1">
                <fieldset><legend>Paciente</legend>                    
                    <a>*</a>Campos de preenchimento obrigatório <br><br>
                    <input type="hidden" id="cadastrar" name="cadastrar" value="cadastrar">
                    Nome<a>*</a>: <br>
                    <input type="text" name="nomepaciente" required size="83"><br><br>

                    <div style="width:74%">
                        <div style="float:left"> Celular<a>*</a>: </div>
                        <div style="float:right"> Fone Residencial: </div>
                    </div>
                    <br>
                    <div style="width:100%">

                        <div style="float:left"> <input type="text" name="celularpaciente" required size="35" onkeyup="maskIt(this, event, '(##)####-####')"></div>    
                        <div style="float:right"> <input type="text" name="foneresidencial" size="35" onkeyup="maskIt(this, event, '(##)####-####')"></div>
                    </div>
                    <br><br>
                    Fone Comercial: <br>
                    <input type="text" name="fonecomercial" size="35" onkeyup="maskIt(this, event, '(##)####-####')">
                    <br><br>
                    
                    e-mail:<br>
                    <input type="email" name="email" size="83">
                    <br><br>
                    <div style="width:62%">
                        <div style="float:left"> CPF<a>*</a>: </div>
                        <div style="float:right"> CNPJ: </div>
                    </div>
                    <br>
                    <div style="width:100%">
                        <div style="float:left"> <input type="text" name="cpfpaciente" size="35" required onkeyup="maskIt(this, event, '###.###.###-##')"></div>    
                        <div style="float:right"> <input type="text" name="cnpjpaciente" size="35" onkeyup="maskIt(this, event, '##.###.###/####-##')"></div>
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
                        <div style="float:left"> Rua: </div>
                        <div style="float:right"> Num: </div>
                    </div>  
                    <br>
                    <div style="width:100%">
                        <div style="float:left"> <input type="text" name="logradouro" size="80"></div>    
                        <div style="float:right"> <input type="text" name="numlogradouro" size="3"></div>
                    </div>  
                    <br><br>
                    Complemento: <br>
                    <input type="text" name="complemento" size="90"><br><br>

                    <div style="width:62%">
                        <div style="float:left"> Bairro: </div>
                        <div style="float:right"> Cidade: </div>
                    </div>
                    <br>
                    <div style="width:100%">
                        <div style="float:left"> <input type="text" name="bairro" size="40"></div>    
                        <div style="float:right"> <input type="text" name="cidade" size="40"></div>
                    </div>                    

                    <br><br>

                    UF: <br>
                    <select style="width:150px;" name="uf"><option selected disabled>Selecione um estado</option><br><br>
                        <option>AC</option>
                        <option>AL</option>
                        <option>AP</option>
                        <option>AM</option>
                        <option>BA</option>
                        <option>CE</option>
                        <option>DF</option>
                        <option>ES</option>
                        <option>GO</option>
                        <option>MA</option>
                        <option>MG</option>
                        <option>MS</option>
                        <option>MT</option>
                        <option>PA</option>
                        <option>PB</option>
                        <option>PI</option>
                        <option>PE</option>
                        <option>PR</option>
                        <option>RJ</option>
                        <option>RN</option>
                        <option>RS</option>
                        <option>RO</option>
                        <option>RR</option>
                        <option>SC</option>
                        <option>SE</option>
                        <option>SP</option>
                        <option>TO</option>                                                 
                    </select><br><br>
                    CEP:<br>
                    <input type="text" name="cep" onkeyup="maskIt(this, event, '#####-###')"> 
                    <br><br>                        

                    <input type="reset" value="Limpar Campos">
                    <input type="submit" value = "Cadastrar Paciente">              
                </fieldset>
            </div>
        </form>
        <div class="form3">
               <form action="../controledenavegacao" method="post">
                    <input type="hidden" id="avicena" name="avicena" value="avicena">
                    <input type="submit" value = "Voltar">
               </form>   
        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>    

    </body>
</html>
