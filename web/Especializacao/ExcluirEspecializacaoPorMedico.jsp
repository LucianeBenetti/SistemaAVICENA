<%@page import="model.vo.Especializacao.EspecializacaoVO"%>
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
        <script type="text/javascript" src="Especializacao/selecionarLinhaTabela.js"></script>

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

                    <p style="text-align: center; font-weight: bold">Lista das especializações cadastradas para o médico selecionado:</p>

                    <%
                        Object obj = request.getAttribute("especializacaovoretornada");

                        if (obj != null) {
                            Boolean EspecializacaoVORetornada = (Boolean) obj;

                            if (!EspecializacaoVORetornada) {%>                     
                           <input type="text" size="100" style="margin-left: 5px;" value="<% out.println("Especialização não encontrada!"
                                + " Tente novamente. Se a Especialização não for cadastrada, por gentileza, cadastrá-la!!");%>">               
                    <%} else {%>
                    <div class="container-fluid">
                        <form name="atualizarespecializacao" action="crudespecializacao" method="post">

                            <div>
                                <table class="table table-borderless table-sm table-hover table-primary table-striped">
                                    <thead>
                                        <tr class="table-success" >
                                            <th>Id</th>
                                            <th>Nome</th> 
                                            <th>Especialidade</th> 
                                            <th>Instituição</th> 
                                            <th>Ano</th> 
                                        </tr>        
                                        <%
                                            ArrayList<EspecializacaoVO> especializacoesVO = (ArrayList<EspecializacaoVO>) request.getAttribute("especializacoesBuscadas");
                                            for (EspecializacaoVO especializacaoVO : especializacoesVO) {%>   
                                        <tr onclick="clickLinhaTabela(this)">
                                            <td><%= especializacaoVO.getCodigoEspecializacao()%></td>
                                            <td hidden><%= especializacaoVO.getMedicoVO().getCodigoMedico()%></td>
                                            <td><%= especializacaoVO.getMedicoVO().getNomeMedico()%></td>
                                            <td hidden><%= especializacaoVO.getEspecialidadeVO().getCodigoEspecialidade()%></td>
                                            <td><%= especializacaoVO.getEspecialidadeVO().getNomeEspecialidade()%></td>
                                            <td><%= especializacaoVO.getEspecialidadeVO().getInstituicao()%></td>
                                            <td><%= especializacaoVO.getAnoEspecializacao()%></td>
                                        </tr>     
                                        <% }%>
                                </table>

                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="inputnomemedico">Nome do Médico:</label>
                                        <input type="text" class="form-control" name="nomemedico" readonly>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label for="inputnomeespecialidade">Nome da Especialidade:</label>
                                        <input type="text" class="form-control" name="nomeespecialidade" readonly >
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-8">
                                        <label for="inputinstituicaoespecialidade">Instituição:</label>
                                        <input type="text" class="form-control" name="instituicaoespecialidade" required readonly>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="inputanoespecializacao">Ano<a>*</a>:</label>
                                        <input type="text" readonly class="form-control"  name="anoespecializacao">
                                    </div>
                                </div>

                                <input type="hidden"  name="codigomedico"  readonly>
                                <input type="hidden" name="codigoespecialidade" readonly>
                                <input type="hidden" name="codigoespecializacao" readonly>

                            </div>


                            <%}
                                }%>  
                            <div class="form-row">
                                <input type="hidden" id="excluir" name="excluir" value="excluir">
                                <button type="submit" class="btn btn-primary" style=" float: left; margin-left: 1.5%" >Excluir Especialização</button>
                            </div>
                        </form>

                        <form action="controledenavegacao" method="post">
                            <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                            <input type="submit" value = "Voltar" class="btn btn-primary" 
                                   style=" margin-left: 20px; clear: both">            
                        </form>   

                    </div>
                </div>

            </div>
        </div>

        <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0; margin-top: 25%; 
             background-color: #7986cb;padding: 4px; color: white; font-size: small; ">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </div>

    </body>
</html>
