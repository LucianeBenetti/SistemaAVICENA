<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>        
        <meta charset= "utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <style>
            /* Make the image fully responsive */
            .carousel-inner img {
                width: 100%;
            }
        </style> 

        <title>Sistema Avicena</title>

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
                    <img src="Slide1.JPG" alt="Senac" width="1300" height="200">
                </div>
                <div class="carousel-item">
                    <img src="Slide2.JPG" alt="Disciplina" width="1300" height="200">
                </div>
                <div class="carousel-item">
                    <img src="Slide3.JPG" alt="Professor" width="1300" height="200">
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

    <nav class="navbar navbar-expand-sm navbar-dark justify-content-center" style= "background-color: #7986cb; 
         font-size: 18px; color: #ffffff; ">
        <a class="navbar-brand">
            <img src=icon2.png alt="logo" style="width:50px; height: 30px;">
        </a>

        <ul class="navbar-nav">

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Pacientes
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="Paciente/CadastrarPaciente.jsp">Cadastrar Paciente</a>
                    <a class="dropdown-item" href="Paciente/PesquisarPacientePorCpf.jsp">Pesquisar/Alterar Paciente</a>
                    <a class="dropdown-item" href="listarpacientes">Listar Todos Pacientes</a>

                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                    Consultas
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="Consulta/CadastrarConsulta.jsp">Cadastrar Consulta</a>
                    <a class="dropdown-item" href="Consulta/PesquisarConsultaPorPaciente.jsp">Pesquisar/Alterar Consulta</a>
                    <a class="dropdown-item" href="Consulta/ExcluirConsulta.jsp">Excluir Consulta</a>
                    <a class="dropdown-item" href="listarconsultas">Listar Todas Consultas</a>                             

                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Convênios
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="Convenio/CadastrarConvenio.jsp">Cadastrar Convenio</a>
                    <a class="dropdown-item" href="Convenio/PesquisarConvenioPorCnpj.jsp">Pesquisar/Alterar Convenio</a>
                    <a class="dropdown-item" href="listarconvenios">Listar Todos Convênios</a>                             

                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Médicos
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="Medico/CadastrarMedico.jsp">Cadastrar Médico</a>
                    <a class="dropdown-item" href="Medico/PesquisarMedicoPorCpf.jsp">Pesquisar/Alterar Médico</a>
                    <a class="dropdown-item" href="listarmedicos">Listar Todos Médicos</a>

                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Especialidades
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="Especialidade/CadastrarEspecialidade.jsp">Cadastrar Especialidade</a>
                    <a class="dropdown-item" href="Especialidade/PesquisarEspecialidadePorNome.jsp">Pesquisar/Altear Especialidade</a>
                    <a class="dropdown-item" href="listarespecialidades">Listar Todas Especialidades</a>

                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Relatórios
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="pesquisarconvenio">Consultas por Convênio</a>
                    <a class="dropdown-item" href="pesquisarmedico">Consultas por Médico</a>
                </div>
            </li>
            <li>
                <form action="controledenavegacao" method="POST">
                    <input type="hidden" id="sair" name="sair" value="sair">
                    <input type="submit" value="Sair" style="border:none; background-color: #7986cb; color: white; padding: 8px;">
                </form>

            </li>
        </ul>

    </nav>
    
    <div class="container" style="text-align: center">

        <h3>Sistema AVICENA - Especialidades Médicas</h3>

        <h5>

            <%

                Object obj1 = request.getAttribute("cadastrado");

                if (obj1 != null) {

                    Boolean usuariocadastrado = (Boolean) obj1;
                        if (usuariocadastrado) {%>
            <input class="generico"  type="text" size="150" 
                   value="<% out.println("Transação realizada com sucesso!");%>">

            <%}
                    }%>

        </h5>            
                    
    </div>

         

    <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0px; margin-top: 20%; background-color: #7986cb; 
         padding: 1px; color: white; ">
        <p>&copy; Desenvolvido por Luciane Benetti e Marco Sena.</p>
    </div>


</body>

</html>