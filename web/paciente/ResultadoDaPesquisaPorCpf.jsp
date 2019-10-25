<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Avicena</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="mascarasPaciente.js"></script>
        <script type="text/javascript" src="paciente/mascarasPaciente.js"></script>

        <style>
            .generico {border-color: transparent; color: red; padding: 10px; background-color: #c8e6c9}
        </style>
    </head>

    <body>

        <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; background-color: #7986cb; padding: 5px; color: white">
            <h4>Sistema Avicena</h4>
            Medicina Humanizada 
        </div>
        <div class="form" style="float: left; background-color: #c8e6c9; padding: 10px; width: 80%; margin-left: 10%; margin-top: 2%; background-color: #c8e6c9; 
             padding: 20px; border-radius: 10px;">

            <p style="text-align: center; font-weight: bold">Resultado da pesquisa de Paciente por CPF:</p>

            <%
                Object obj = request.getAttribute("pacientevoretornado");

                if (obj != null) {
                    Boolean PacienteVORetornado = (Boolean) obj;

                    if (PacienteVORetornado) {%>

            <form action="atualizarpaciente" method="post" style="padding: 10px;">               

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputnome">Nome:</label>
                        <input type="text" class="form-control" id="inputnome" name="nomepaciente" placeholder="Digite o nome do paciente"
                               value="<%= request.getAttribute("nomepaciente")%>">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputemail">E-mail:</label>
                        <input type="email" class="form-control" id="inputemail" name="emailpaciente" placeholder="Digite o email do paciente"
                               value="<%= request.getAttribute("emailpaciente")%>">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="inputcelular">Celular:</label>
                        <input type="text" class="form-control" id="inputcelular" name="celularpaciente" placeholder="Digite o celular do paciente"
                               value="<%= request.getAttribute("celmenpaciente")%>" required onkeyup="maskIt(this, event, '(##)#####-####')">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputfoneresidencial">Fone Residencial:</label>
                        <input type="text" class="form-control" id="inputfoneresidencial" name="foneresidencial" placeholder="Digite o fone residencial do paciente" 
                               value="<%= request.getAttribute("fonecomercial")%>"onkeyup="maskIt(this, event, '(##)####-####')">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputfonecomercial">Fone Comercial:</label>
                        <input type="text" class="form-control" id="inputfonecomercial" name="fonecomercial" placeholder=" Digite o fone comercial do paciente" 
                               value="<%= request.getAttribute("fonecomercial")%>" onkeyup="maskIt(this, event, '(##)####-####')">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputcpf">CPF:</label>
                        <input type="text" class="form-control" id="inputcpf" name="cpfpaciente" placeholder="Digite o CPF do paciente" 
                               value="<%= request.getAttribute("cpfpaciente")%>" required onkeyup="maskIt(this, event, '###.###.###-##')">
                    </div>
                    <div class="form-group col-md-6" style="size:30px">
                        <label for="inputcnpj">CNPJ:</label>
                        <input type="text" class="form-control" id="inputcnpj" name="cnpjpaciente" placeholder="Digite o CNPJ do paciente" 
                               value="<%= request.getAttribute("cnpjpaciente")%>" onkeyup="maskIt(this, event, '##.###.###/####-##')">
                    </div>             
                </div>

                <div class="form-row">
                    <div class="form-group col-md-7">
                        <label for="inputendereco">Endereço:</label>
                        <input type="text" class="form-control" id="inputendereco" name="logradouro" placeholder="Avenida, rua, travessa, servidão"
                               value="<%= request.getAttribute("logradouro")%>">
                    </div>                   
                    <div class="form-group col-md-1">
                        <label for="inputnumlogradouro">Num.: </label>
                        <input type="text" class="form-control" id="inputnumlogradouro" name="numlogradouro"
                               value="<%= request.getAttribute("numlogradouro")%>">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputcomplemento">Complemento:</label>
                        <input type="text" class="form-control" id="inputcomplemento" name="complemento" placeholder="Bloco, apartamento, nome do condomínio"
                               value="<%= request.getAttribute("complemento")%>">
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="inputbairro">Bairro:</label>
                        <input type="text" class="form-control" id="inputbairro" name="bairro" placeholder="Digite o bairro"
                               value="<%= request.getAttribute("bairro")%>">
                    </div>             
                    <div class="form-group col-md-3">
                        <label for="inputcidade">Cidade:</label>
                        <input type="text" class="form-control" id="inputcidade" name="cidade" placeholder="Digite a cidade"
                               value="<%= request.getAttribute("cidade")%>">
                    </div>

                    <div class="form-group col-md-2">
                        <label for="inputuf">UF.: </label>
                        <select style="width:150px;" class="form-contol" id="inputuf" name="uf" value="<%= request.getAttribute("uf")%>">
                            <option selected disabled>Selecione um estado</option><br><br>
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

                        </select>
                    </div>

                    <div class="form-group col-md-3">
                        <label for="inpucep">CEP.: </label>
                        <input type="text" class="form-control" id="inputcep" name="cep" placeholder="Digite o CEP"
                               value="<%= request.getAttribute("cep")%>"onkeyup="maskIt(this, event, '#####-###')">
                    </div>
                </div><br><br>               
                <%} }%>
                <input type="submit" class="btn btn-primary" value="Atualizar" Paciente"
                       style=" float: left; margin-left: 1.5%">              
            </form>

            <form action="../controledenavegacao" method="POST">
                <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                <input type="submit" class="btn btn-primary" value = "Voltar"  
                       style=" margin-left: 2%; float: left;">            
            </form>            

        </div>

    </div>

    <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0;
         margin-top: 2%; background-color: #7986cb;padding: 4px; color: white; font-size: small; ">
        &copy; Desenvolvido por Luciane Benetti e Marco Sena.
    </div>

</body>  
</html>
