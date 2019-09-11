<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Avicena</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <style>
            .generico
            {text-align: center; border-color: transparent; color: red; padding: 10px}
        </style>
    </head>
    <body>

        <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; 
             background-color: #7986cb; padding: 20px; color: white">
            <h1>Sistema Avicena</h1>
            <p>Medicina Humanizada</p> 
        </div>

        <div class="container" style="padding: 3px; margin-top: 1%; margin-bottom: 10%;" >

            <div class="form" style="background-color: #b0bec5; padding: 10px; width: 60%;  
                 border-radius: 10px; float: left; margin-left: 20%; ">

                <p style="text-align: center; font-weight: bold">Insira os dados, a seguir, para cadastrar novo Usuário!</p>

                <form action="usuario" class="was-validated" method="post">
                    <div class="form-group">
                        <input type="hidden" id="cadastrar" name="cadastrar" value="cadastrar">
                        <label for="nome">Nome:</label>
                        <input type="text" class="form-control" id="nome" placeholder="Digite seu nome para seu login" name="nome" style="border-color: gray" required>
                        <div class="valid-feedback">Valido.</div>
                        <div class="invalid-feedback" style = "color: black">Campo obrigatório.</div>
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha:</label>
                        <input type="password" class="form-control" id="senha" placeholder="Digite uma senha" name="senha" style="border-color: gray" required>
                        <div class="valid-feedback">Valido.</div>
                        <div class="invalid-feedback"  style = "color: black">Campo obrigatório.</div>
                    </div>

                    <div class="form-group">
                        <label for="perfil">Perfil:</label>
                        <input type="text" class="form-control" id="perfil" placeholder="Digite seu perfil: atendente, ou medico ou admin" name="perfil" style="border-color: gray" required>
                        <div class="valid-feedback">Valido.</div>
                        <div class="invalid-feedback"  style = "color: black">Campo obrigatório.</div>
                    </div>

                    <button type="submit" class="btn btn-secondary" style="float: left" >Cadastrar</button>
                </form> 

                <form action="controledenavegacao" method="post">

                    <input type="hidden" id="sairdocadastro" name="sairdocadastro" value="sairdocadastro">
                    <input type="submit" value = "Sair" class="btn btn-secondary" 
                           style=" margin-left: 20px; float: left;">            
                </form>
            </div>

        </div>

        <div class="Container" style="text-align: center">

            <%
                Object obj1 = request.getAttribute("usuariocadastrado");
                Object obj2 = request.getAttribute("usuariovalidado");
                if (obj1 != null) {
                    Boolean usuariocadastrado = (Boolean) obj1;
                    if (!usuariocadastrado) {%>

            <input class="generico" type="text" size="125" value="<% out.println("Não "
                                + "foi possível cadastrar o novo Usuário, pois já existe um cadastro com esse nome. "
                                + "Forneça outro nome!");%>">
        </div>

        <div class="Container" style="text-align: center">

            <%}
                }
                if (obj2 != null) {
                    Boolean usuariovalidado = (Boolean) obj2;
                            if (!usuariovalidado) {%>
            <br><br><br>
                   <input class="generico"  type="text" size="125" value="<% out.println("Não foi possível validar o Usuário. "
                                       + "Você precisa se cadastrar para acessar o sistema Avicena!");%>">

            <%}
                        }%>


        </div>      


        <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; margin-top: 40%; 
             background-color: #7986cb;padding: 1px; color: white; font-size: small; ">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </div>

    </body>
</html>
