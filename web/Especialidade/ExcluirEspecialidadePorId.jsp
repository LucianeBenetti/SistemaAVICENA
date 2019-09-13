<%@page import="java.util.ArrayList"%>
<%@page import="model.vo.Especialidade.EspecialidadeVO"%>
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script type="text/javascript" src="Especialidade/selecionarLinhaTabela.js"></script>

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
        <div class="container" style="padding: 3px; margin-top: 2%; margin-bottom: 10%;" >

            <div class="container" style="padding: 3px; margin-top: 2%; margin-bottom: 10%;" >

                <div class="form" style="background-color: #c8e6c9; padding: 10px; width: 60%;  
                     border-radius: 10px; float: left; margin-left: 20%;">

                    <p style="text-align: center; font-weight: bold">Lista das especialidades cadastradas na clínica AVICENA:</p>

                    <%
                        Object obj = request.getAttribute("especialidadevoretornada");

                        if (obj != null) {
                            Boolean EspecialidadeVORetornada = (Boolean) obj;

                            if (!EspecialidadeVORetornada) {%>                     
                           <input type="text" size="65" style="margin-left: 5px;" value="<% out.println("Especialidade não encontrada!"
                                       + " Tente novamente!");%>">               
                    <%} else {%>

                    <form name="atualizarespecialidade" action="crudespecialidade" method="post">
                        <div class="container-fluid">

                            <div style="overflow-x:auto;">
                                <table class="table table-borderless table-sm table-hover table-primary table-striped">
                                    <thead>
                                        <tr class="table-success" >
                                            <th>Id</th>
                                            <th>Nome</th> 
                                            <th>Instituição</th> 
                                        </tr>        
                                        <%
                                            ArrayList<EspecialidadeVO> especialidadesVO = (ArrayList<EspecialidadeVO>) request.getAttribute("especialidadesBuscadas");
                                            for (EspecialidadeVO especialidadeVO : especialidadesVO) {%>   
                                        <tr onclick="clickLinhaTabela(this)">
                                            <td><%= especialidadeVO.getCodigoEspecialidade()%></td>
                                            <td><%= especialidadeVO.getNomeEspecialidade()%></td>
                                            <td><%= especialidadeVO.getInstituicao()%></td>
                                        </tr>     
                                        <% }     %>
                                </table>

                                <br><br>
                                ID: <br>
                                <input type="text" name="codigoespecialidade" size="4" readonly> <br><br>
                                Nome: <br>
                                <input type="text" name="nomeespecialidade" size="65" readonly> <br><br>
                                Instituicao:<br>
                                <input type="text" name="instituicaoespecialidade" size="65" readonly> <br><br>
                                <br><br>

                                <input type="hidden" id="excluir" name="excluir" value="excluir">
                                <button type="submit" class="btn btn-primary" style="float: left" >Excluir Especialidade</button>
                            </div>

                        </div>
                        <%}
                            }%>  
                    </form><br><br>


                    <form action="controledenavegacao" method="post">

                        <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                        <input type="submit" value = "Voltar" class="btn btn-primary" 
                               style=" margin-left: 20px; float: left;">            
                    </form> 

                </div>
            </div>
        </div>
        <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0; margin-top: 25%; 
             background-color: #7986cb;padding: 4px; color: white; font-size: small; ">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </div>

    </body>
</html>

