<%@page import="model.vo.Prontuario.ProntuarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>    
        <meta charset= "utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <title>Sistema Avicena</title> 
    </head>
    <body>  
        <nav class="navbar navbar-expand-sm navbar-dark justify-content-left" 
             style= "background-color: #7986cb; font-size: 18px; color: #ffffff; ">
            <a class="navbar-brand">
                <img src="icon2.png" alt="logo" style="width:50px; height: 30px;">
            </a>
            <ul class="navbar-nav">
                <form action="controledenavegacao" method="POST">
                    <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                    <input type="submit" value="Inicio" style="border:none; background-color: #7986cb; color: white; padding: 8px;">
                </form>  
                <li>
                    <form action="controledenavegacao" method="POST">
                        <input type="hidden" id="sair" name="sair" value="sair">
                        <input type="submit" value="Sair" style="border:none; background-color: #7986cb; color: white; padding: 8px;">
                    </form>
                </li>
            </ul>
        </nav>
        <div class="container-fluid">
            <h4>Lista dos pacientes cadastrados na clínica AVICENA:</h4><br> 
            <table class="table table-borderless table-sm table-hover table-striped">
                <thead>
                    <tr class="table-warning" >
                <tr>
                    <th>Id</th>
                    <th>Nome do Paciente</th> 
                    <th>Medicamentos</th>
                    <th>Exames</th>
                    <th>Procedimentos</th>
                    <th>Registro</th>
                </tr>         
                </thead>
                <%
                    ArrayList<ProntuarioVO> prontuariosVO = (ArrayList<ProntuarioVO>) request.getAttribute("prontuarios");
                    for (ProntuarioVO prontuarioVO : prontuariosVO) {%>   
                <tr>
                    <td><%= prontuarioVO.getCodigoProntuario()%></td>
                    <td><%= prontuarioVO.getPacienteVO().getNomePaciente()%></td>
                    <td><%= prontuarioVO.getMedicamento()%></td>
                    <td><%= prontuarioVO.getExame()%></td>
                    <td><%= prontuarioVO.getProcedimento()%></td>
                    <td><%= prontuarioVO.getRegistro()%></td>
                </tr>                   
                <%
                    }
                %>
            </table>      
            <br><br>
        </div>
        <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; margin-top: 5%;
             background-color: #7986cb; padding: 5px; color: white; font-size: 10pt;">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </div>
    </body>
</html>
