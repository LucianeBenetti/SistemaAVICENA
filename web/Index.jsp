<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset= "utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link type="text/css" rel="stylesheet" href="PaginaInicial.css">    
       

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <title>Sistema Avicena - Página de Login</title>

        <style>
            /* Make the image fully responsive */  
            .carousel-inner{margin: 0 auto;       
            }
            .carousel-inner img {max-width: 100%;    
            }

            .container{float:top}
            .menu{float: bottom}
        </style>    

    <div class="container">    

        <div id="demo" class="carousel slide" data-ride="carousel">

            <!-- Indicators -->
            <ul class="carousel-indicators">
                <li data-target="#demo" data-slide-to="0" class="active"></li>
                <li data-target="#demo" data-slide-to="1"></li>
                <li data-target="#demo" data-slide-to="2"></li>
            </ul>

            <!-- The slideshow -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="Slide1.JPG" alt="Senac" width="1500" height="200">
                </div>
                <div class="carousel-item">
                    <img src="Slide2.JPG" alt="Disciplina" width="1500" height="200">
                </div>
                <div class="carousel-item">
                    <img src="Slide3.JPG" alt="Professor" width="1500" height="200">
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="carousel-control-prev" href="#demo" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#demo" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>
        </div>
    </div>    
</head>    
<body>    
    <div class="principal">
        <div class="secao3">

        </div>

        <div class="login">

            <fieldset><legend>Faça o login para acessar o sistema Avicena - especialidades médicas</legend><br><br>
                <form action="usuario" method="post">                   
                    <input type="hidden" id="validar" name="validar" value="validar">
                    Nome: <br>
                    <input type="text" name="nome" size=70 required=""><br><br>
                    Senha: <br>
                    <input type="password" size=70 name="senha" required=""><br><br>
                    <input type="submit" value="OK"/>

                </form><br> 

                <form action="CadastrarUsuario.jsp" method="post">
                    Não sou cadastrado <input type="submit" value = "Clique aqui!">
                </form> 
            </fieldset>  

        </div>

        <%
            Object obj1 = request.getAttribute("usuariovalidado");

            if (obj1 != null) {
                Boolean usuarioValidado = (Boolean) obj1;

                if (!usuarioValidado) {%>

               <input type="text" size="80" style="margin-left: 300px;"value="<% out.println("Nome ou senha incorretos!"
                            + " Tente novamente. Se não for cadastrado, cadastra-se!");%>">
        <%}
                    }%>

        <div class="secao4">

        </div>   

        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>
    </div>    
</body>
</html>
