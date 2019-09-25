<%@page import="model.vo.Consulta.ConsultaVO"%>
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
        <script type="text/javascript" src="Consulta/selecionarTabelaEspecializacao.js"></script>

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

                    <p style="text-align: center; font-weight: bold">Lista das consultas cadastradas para o paciente selecionado:</p>

                    <form name="excluirconsulta" action="excluirconsulta" method="post">
                        <div class="resultadodaconsultaNome">         
                            <%
                                Object consultas = request.getAttribute("listaconsultas");
                                ArrayList<ConsultaVO> consultasVO = (ArrayList<ConsultaVO>) consultas;
                                if (consultasVO != null) {%>
                            <div class="container-fluid">

                                <div style="overflow-x:auto;">
                                    <table class="table table-borderless table-sm table-hover table-primary table-striped">
                                        <thead>
                                            <tr class="table-success" >
                                                <th>Id</th>
                                                <th>Nome do Paciente</th> 
                                                <th>Nome do Médico</th> 
                                                <th>Especialidade</th>
                                                <th>Convenio</th>
                                                <th>Data da Consulta</th>
                                                <th>Horário da Consulta</th>
                                                <th>Atenção Especial</th>
                                            </tr>        
                                            <% for (ConsultaVO consultaVO : consultasVO) {%>  

                                            <tr onclick="clickExcluirConsulta(this)">
                                                <td><%= consultaVO.getCodigoConsulta()%></td>
                                                <td><%= consultaVO.getPacienteVO().getNomePaciente()%></td>
                                                <td><%= consultaVO.getEspecializacaoVO().getMedicoVO().getNomeMedico()%></td>
                                                <td><%= consultaVO.getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade()%></td>
                                                <td><%= consultaVO.getConvenioVO().getNomeConvenio()%></td>
                                                <td ><%= consultaVO.getDataConsulta()%></td>
                                                <td ><%= consultaVO.getHorarioConsulta()%></td>
                                                <td ><%= consultaVO.getAtencaoEspecial()%></td>
                                            </tr>     
                                            <% }%>
                                    </table>

                                </div>

                                <input type="hidden" name="codigoconsulta" size="4" readonly>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputnome">Nome:</label>
                                        <input type="text" class="form-control" id="inputnome" name="nomepaciente" required readonly value="<%= request.getAttribute("nomepaciente")%>">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputnomeconvenio">Convênio:</label>
                                        <input type="text" class="form-control"  readonly id="inputnomeconvenio" name="nomeconvenio">
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputnomemedico">Nome do Médico:</label>
                                        <input type="nomemedico" class="form-control" readonly id="inputnomemedico" name="nomemedico">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputnomeespecialidade">Especialidade</label>
                                        <input type="text" class="form-control"  readonly id="inputnomeespecialidade" name="nomeespecialidade">
                                    </div>

                                </div>    
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputdataconsulta">Data da Consulta:</label>
                                        <input type="text" class="form-control" readonly id="inputdataconsulta" name="dataconsulta">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputhorarioconsulta">Horário da Consulta:</label>
                                        <input type="text" class="form-control" readonly id="inputhorarioconsulta" name="horarioconsulta">
                                    </div>
                                </div>

                                <div class="form-group col-md-12">
                                    <label for="inputatencaoespecial">Atenção Especial:</label>
                                    <textarea disabled class="form-control" readonly id="inputatencaoespecial" name="atencaoespecial"></textarea>
                                </div>

                                <div>
                                    <input type="hidden" id="excluir" name="excluir" value="excluir">
                                    <button type="submit" class="btn btn-primary" style="float: left" >Excluir Consulta</button>
                                </div>

                            </div>
                            <%} else {%>

                            <% out.println("Não foi possível atualizar os dados da Consulta! Por gentileza, tente novamente");%>

                            <%}%>
                        </div>

                    </form><br><br>


                    <form action="controledenavegacao" method="post">

                        <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                        <input type="submit" value = "Voltar" class="btn btn-primary" 
                               style=" margin-left: 20px; float: left;">            
                    </form> 


                </div>
            </div>
            <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0; margin-top: 25%; 
                 background-color: #7986cb;padding: 4px; color: white; font-size: small; ">
                &copy; Desenvolvido por Luciane Benetti e Marco Sena.
            </div>

    </body>
</html>

