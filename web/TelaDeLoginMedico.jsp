<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sistema Avicena</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    </head>
<body>

  <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; 
             background-color: #7986cb; padding: 20px; color: white">
      <h1>Sistema Avicena</h1>
      <p>Medicina Humanizada</p> 
  </div>

  <div class="container" style="padding: 10px; margin-top: 3%; margin-bottom: 4%;" >

            <div class="form" style="background-color: #b0bec5; padding: 20px; width: 50%; height: 380px;  
                 border-radius: 15px; margin-left: 25%; ">

                <p style="text-align: center; font-weight: bold">Faça o Login para acessar o sistema Avicena!</p>

                <form action="usuario" class="was-validated" method="post">
                    <div class="form-group">
                        <input type="hidden" id="validar" name="validar" value="validar">
                        <input type="hidden" id="medico" name="medico" value="medico">
                        <label for="nome">Nome:</label>
                        <input type="text" class="form-control" id="nome" placeholder="Digite seu login" name="nome" style="border-color: gray" required>
                        <div class="valid-feedback">Valido.</div>
                        <div class="invalid-feedback" style = "color: black">Campo obrigatório.</div>
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha:</label>
                        <input type="password" class="form-control" id="senha" placeholder="Digite sua senha" name="senha" style="border-color: gray" required>
                        <div class="valid-feedback">Valido.</div>
                        <div class="invalid-feedback"  style = "color: black">Campo obrigatório.</div>
                    </div>
                    <div class="form-group form-check">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" name="lembrar"> Lembre-me
                        </label>
                    </div>
                    <button type="submit" class="btn btn-secondary" style="float: left;" >Enviar</button>
                </form>
                
                <form action="controledenavegacao" method="post">
                    <input type="hidden" id="sair" name="sair" value="sair">
                    <input type="submit" class="btn btn-secondary" style="float: left; margin-left: 10px" value = "Sair">
                </form>
            </div>

  </div>

     <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; 
     background-color: #7986cb;padding: 1px; color: white; font-size: small; ">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
     </div>

</body>
</html>
