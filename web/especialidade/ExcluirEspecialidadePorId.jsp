<%@page import="java.util.ArrayList"%>
<%@page import="model.vo.especialidade.EspecialidadeVO"%>
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
        <script type="text/javascript" src="especialidade/selecionarLinhaTabela.js"></script>

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

                <div class="form" style="float: left; background-color: #c8e6c9; padding: 10px; width: 80%; margin-left: 10%; margin-top: 2%; background-color: #c8e6c9; 
             padding: 20px; border-radius: 10px;">

                    <p style="text-align: center; font-weight: bold">Lista das especialidades cadastradas na clínica AVICENA:</p>

                    <%
                        Object obj = request.getAttribute("especialidadevoretornada");

                        if (obj != null) {
                            Boolean EspecialidadeVORetornada = (Boolean) obj;

                            if (EspecialidadeVORetornada) {%>                     

                    <form name="atualizarespecialidade" action="crudespecialidade" method="post">
                        <div class="container-fluid">

                            <div >
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
                                        <% }%>
                                </table>
                                <div class="form-row">

                                    <div class="form-group col-md-6" style="size:30px">
                                        <label for="inputnomeespecialidade">Nome: </label>
                                        <input type="text" readonly class="form-control" id="inputnomeespecialidade" name="nomeespecialidade">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputinstituicaoespecialidade">Instituicao:</label>
                                        <input type="text" readonly class="form-control" id="inputinstituicaoespecialidade" name="instituicaoespecialidade">
                                    </div>
                                </div>

                                  <input type="hidden" name="codigoespecialidade">
                            
                                <input type="hidden" id="excluir" name="excluir" value="excluir">
                                <button type="submit" class="btn btn-primary" style="float: left" >Excluir Especialidade</button>
                            </div>

                        </div>

                        <%    }
                       }%>  
                    </form>

                    <form action="controledenavegacao" method="post">

                        <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                        <input type="submit" value = "Voltar" class="btn btn-primary" 
                               style="margin-left: 20px; clear: both">            
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

