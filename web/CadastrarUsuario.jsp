<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tela de Cadastro</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    </head>
    <body>

        <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; 
             background-color: #7986cb; padding: 20px; color: white;">
            <h1>Sistema Avicena</h1>
            <p>Medicina Humanizada</p> 
        </div>

        <div class="container" style="padding: 10px;" >

            <div class="form" style="background-color: #b0bec5; padding: 20px; width: 50%; 
                 border-radius: 25px; margin-left: 25%; float: left">

                <p style="text-align: center; font-weight: bold">Insira os dados, a seguir, para cadastrar novo Usuário!</p>

                <form action="usuario" class="was-validated">
                    <div class="form-group">
                        <input type="hidden" id="cadastrar" name="cadastrar" value="cadastrar">
                        <label for="nome">Nome:</label>
                        <input type="text" class="form-control" id="nome" placeholder="Digite seu nome de login" name="nome" style="border-color: gray" required>
                        <div class="valid-feedback">Valido.</div>
                        <div class="invalid-feedback" style = "color: black">Campo obrigatório.</div>
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha:</label>
                        <input type="password" class="form-control" id="senha" placeholder="Digite uma senha" name="senha" style="border-color: gray" required>
                        <div class="valid-feedback">Valido.</div>
                        <div class="invalid-feedback"  style = "color: black">Campo obrigatório.</div>
                    </div>
                    <div class="form-group form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" name="lembrar"> Lembre-me
                        </label>
                    </div>
                    <button type="submit" class="btn btn-secondary" style="float: left">Cadastrar</button>

                </form>        

                <form action="controledenavegacao" method="post">

                    <input type="hidden" id="sairdocadastro" name="sairdocadastro" value="sairdocadastro">
                    <input type="submit" value = "Voltar" class="btn btn-secondary" style="float: left;
                           margin-left: 20px">            
                </form>

            </div>  

        </div><br>

        <%
            Object obj1 = request.getAttribute("usuariocadastrado");
            Object obj2 = request.getAttribute("usuariovalidado");

            if (obj1 != null) {
                Boolean usuariocadastrado = (Boolean) obj1;

        if (!usuariocadastrado) {%>

        <input type="text" size="125" style="margin-left: 310px; " value="<% out.println("Não "
                        + "foi possível cadastrar o novo Usuário, pois já existe um cadastro com esse nome. "
                        + "Forneça outro nome!");%>">


        <%}
            }

            if (obj2 != null) {
                Boolean usuariovalidado = (Boolean) obj2;
            if (!usuariovalidado) {%>
        <br><br><br>
               <input type="text" size="100" value="<% out.println("Não foi possível validar o Usuário. "
                        + "Você precisa se cadastrar para acessar o sistema Avicena!");%>">

        <%}
                }%>



        <div class="jumbotron jumbotron-fluid text-center" style=" width: 100%; margin-top: 40px; margin-bottom:0; 
             background-color: #7986cb; padding: 1px; color: white; float: left">
            <p>&copy; Desenvolvido por Luciane Benetti e Marco Sena.</p>
        </div> 


    </body>
</html>
