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

                <div class="form" style="background-color: #c8e6c9; padding: 10px; width: 60%;  
                     border-radius: 10px; float: left; margin-left: 20%;">

                    <p style="text-align: center; font-weight: bold">Lista das especialidades cadastradas na clínica AVICENA:</p>

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
                                            </tr>     
                                            <% }  %>
                                    </table>
                                    <br><br>
                                </div>


                                <br><br>
                                <input type="hidden" name="codigoconsulta" size="4" readonly>
                                Nome: <br>                       
                                <input type="text" readonly name="nomepaciente" size="50" ><br><br>  
                                Nome do Médico: <br>
                                <input type="text" name="nomemedico"  size="50" readonly> <br><br>
                                Nome da Especialidade: <br>
                                <input type="text" name="nomeespecialidade"  size="50" readonly> <br><br>
                                Convênio <br>                       
                                <input type="text" readonly name="nomeconvenio"  size="50"><br><br>
                                <div style="width:55%">
                                    <div style="float:left"> Data<a>*</a>: </div>
                                    <div style="float:right"> Horário<a>*</a>: </div>
                                </div>
                                <br>
                                <div style="width:80%">
                                    <div style="float:left"> <input type="text" name="dataconsulta" readonly size="15"></div>    
                                    <div style="float:right"> <input type="text" name="horarioconsulta" readonly size="15"></div><br><br> 

                                </div> 
                                <input type="hidden" id="excluir" name="excluir" value="excluir">
                                <button type="submit" class="btn btn-primary" style="float: left" >Excluir Consulta</button>
                            </div>

                        </div>
                        <%}%>
                            
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

