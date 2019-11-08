<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.vo.consulta.ConsultaVO"%>
<%@page import="java.util.ArrayList"%>
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
        <script type="text/javascript" src="consulta/selecionarTabelaEspecializacao.js"></script>
        <script type="text/javascript" src="jquery-ui.min.js"></script>
        <link rel="stylesheet" href="jquery-ui.min.css"/>
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
                        Object consultas = request.getAttribute("listaconsultas");
                        ArrayList<ConsultaVO> consultasVO = (ArrayList<ConsultaVO>) consultas;
                        if (consultasVO != null) {%>
                    <div class="container-fluid">

                        <div >
                            
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
                                    <% for (ConsultaVO consultaVO : consultasVO) { 

                                    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                                   
                                    
                                    %> 
                                    <tr onclick="clickAtualizarConsulta(this)">
                                        <td><%= consultaVO.getCodigoConsulta()%></td>
                                        <td hidden><%= consultaVO.getPacienteVO().getCodigoPaciente()%></td>
                                        <td><%= consultaVO.getPacienteVO().getNomePaciente()%></td>
                                        <td hidden><%= consultaVO.getEspecializacaoVO().getCodigoEspecializacao()%></td>
                                        <td><%= consultaVO.getEspecializacaoVO().getMedicoVO().getNomeMedico()%></td>
                                        <td><%= consultaVO.getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade()%></td>
                                        <td hidden><%= consultaVO.getConvenioVO().getCodigoConvenio()%></td>
                                        <td><%= consultaVO.getConvenioVO().getNomeConvenio()%></td>
                                        <td ><%= formatador.format(consultaVO.getDataConsulta())%></td>
                                        <td ><%= consultaVO.getHorarioConsulta()%></td>
                                        <td ><%= consultaVO.getAtencaoEspecial()%></td>
                                        <td hidden><%= consultaVO.getValorConsulta()%></td>
                                    </tr>     
                                    <% }
                                        }%>
                            </table>
                        </div>    
                    </div>

                    <form name="atualizarconsulta" action="atualizarconsulta" method="post">
                        <input type="hidden" name="codigoconsulta" size="4" readonly>
                        <input type="hidden" name="codigoespecializacao" size="4" readonly>
                        <input type="hidden" readonly name="codigoconvenio" size="50">
                        <input type="hidden" readonly name="valorconsulta" size="50">
                        <input type="hidden" name="codigopaciente">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputnome">Nome:</label>
                                <input type="text" class="form-control" id="inputnome" name="nomepaciente" readonly>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputnomeconvenio">Convênio:</label>
                                <input type="text" class="form-control" id="inputnomeconvenio" name="nomeconvenio" readonly>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputnomemedico">Nome do Médico:</label>
                                <input type="nomemedico" class="form-control" id="inputnomemedico" name="nomemedico" readonly>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputnomeespecialidade">Especialidade</label>
                                <input type="text" class="form-control" id="inputnomeespecialidade" name="nomeespecialidade" readonly>
                            </div>

                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <script>
                                    $(function () {
                                        $("#calendario").datepicker({dateFormat: 'dd/mm/yy'});
                                    });
                                </script> 
                                <label for="inputdataconsulta">Data:</label>
                                <input type="text" class="form-control" id="calendario" name="dataconsulta">
                            </div>
                            <div class="form-group col-md-6" style="size:30px">
                                <label for="inputhorarioconsulta">Horário:</label>
                                <select required class="form-control" id="inputcnpj" name="horarioconsulta" required><option selected disabled>Selecione um horário</option><br><br>
                                    <option>08:00</option>
                                    <option>08:30</option>
                                    <option>09:00</option>
                                    <option>09:30</option>
                                    <option>10:00</option>
                                    <option>10:30</option>
                                    <option>11:00</option>
                                    <option>11:30</option>
                                    <option>13:30</option>
                                    <option>14:00</option>
                                    <option>14:30</option>
                                    <option>15:00</option>
                                    <option>15:30</option>
                                    <option>16:00</option>
                                    <option>16:30</option>
                                    <option>17:00</option>
                                    <option>17:30</option>                                                                 
                                </select>   
                            </div>             
                        </div>  

                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <textarea readonly class="form-control" name="atencaoespecial"></textarea>
                            </div>
                        </div> 

                        <div class="form-row">
                            <button type="submit" class="btn btn-primary" style=" float: left; margin-left: 1.5%">Atualizar Consulta</button> 
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
        <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0; margin-top: 25%; 
             background-color: #7986cb;padding: 4px; color: white; font-size: small; ">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </div>

    </body>
</html>