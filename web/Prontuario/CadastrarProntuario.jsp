<%@page import="model.vo.Consulta.ConsultaVO"%>
<%@page import="model.vo.Prontuario.ProntuarioVO"%>
<%@page import="java.util.ArrayList"%>
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
        <script type="text/javascript" src="Prontuario/selecionarTabelaProntuario.js"></script>
    </head>        

    <body>

        <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; background-color: #7986cb; padding: 5px; color: white">
            <h4>Sistema Avicena</h4>
            Medicina Humanizada 
        </div>

        <div class="container" style="padding: 3px; margin-top: 2%; margin-bottom: 10%;" >
            <div class="form" style="float: left; background-color: #c8e6c9; padding: 10px; width: 80%; margin-left: 10%; margin-top: 2%; background-color: #c8e6c9; 
             padding: 20px; border-radius: 10px;">     

                <p style="text-align: center; font-weight: bold">Selecionar a Consulta e o Prontuário do Paciente (se houver):</p>      

                <%
                    Object obj = request.getAttribute("listaProntuarios");
                    ArrayList<ProntuarioVO> listaProntuarios = (ArrayList<ProntuarioVO>) obj;
                    if (listaProntuarios != null) {%>

                <div class="container-fluid">

                    <div >
                        <table class="table table-borderless table-sm table-hover table-primary table-striped">
                            <thead>
                                <tr class="table-success" >
                                    <th>Id</th>
                                    <th>Nome do Paciente</th> 
                                    <th>Medicamentos</th>
                                    <th>Exames</th>
                                    <th>Procedimentos</th>
                                    <th>Registro</th>

                                </tr>        
                                <% for (ProntuarioVO prontuarioVO : listaProntuarios) {%>
                                <tr onclick="clickLinhaTabelaProntuario(this)">
                                    <td><%= prontuarioVO.getCodigoProntuario()%></td>
                                    <td hidden><%= prontuarioVO.getPacienteVO().getCodigoPaciente()%></td>
                                    <td><%= prontuarioVO.getPacienteVO().getNomePaciente()%></td>
                                    <td><%= prontuarioVO.getMedicamento()%></td>
                                    <td ><%= prontuarioVO.getExame()%></td>
                                    <td><%= prontuarioVO.getProcedimento()%></td>
                                    <td ><%= prontuarioVO.getRegistro()%></td>
                                </tr>     
                                <% }
                                    }%>
                        </table>
                        <br><br>      
                    </div>
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
                                    </tr>        
                                    <% for (ConsultaVO consultaVO : consultasVO) {%>  

                                    <tr onclick="clickLinhaTabelaConsulta(this)">
                                        <td><%= consultaVO.getCodigoConsulta()%></td>
                                        <td hidden><%= consultaVO.getPacienteVO().getCodigoPaciente()%></td>
                                        <td><%= consultaVO.getPacienteVO().getNomePaciente()%></td>
                                        <td hidden><%= consultaVO.getEspecializacaoVO().getCodigoEspecializacao()%></td>
                                        <td><%= consultaVO.getEspecializacaoVO().getMedicoVO().getNomeMedico()%></td>
                                        <td><%= consultaVO.getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade()%></td>
                                        <td hidden><%= consultaVO.getConvenioVO().getCodigoConvenio()%></td>
                                        <td><%= consultaVO.getConvenioVO().getNomeConvenio()%></td>
                                        <td ><%= consultaVO.getDataConsulta()%></td>
                                        <td ><%= consultaVO.getHorarioConsulta()%></td>
                                    </tr>     
                                    <% }
                                        }%>
                            </table>
                        </div>
                        <form name="cadastrarprontuario" action="cadastrarprontuario" method="post">

                            <input type="hidden" readonly name="codigoconsulta"> 
                            <input type="hidden" readonly name="codigopaciente"> 
                            <input type="hidden" readonly name="codigoespecializacao"> 
                            <input type="hidden" readonly name="nomemedico" size="50"> 
                            <input type="hidden" readonly name="nomeespecialidade" size="50"> 
                            <input type="hidden" readonly name="codigoconvenio"> 
                            <input type="hidden" readonly name="nomeconvenio"> 
                            <input type="hidden" readonly name="codigoprontuario"> 
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputnomepaciente">Nome do Paciente</label>
                                    <input type="nomepaciente" readonly class="form-control" id="inputnomepaciente" name="nomepaciente">
                                </div>
                            </div>
                            <div class="form-row">   
                                <div class="form-group col-md-6">
                                    <label for="inputdataconsulta">Data:</label>
                                    <input type="text" readonly class="form-control" id="dataconsulta" name="dataconsulta">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputhorarioconsulta">Horário:</label>
                                    <input type="text" readonly class="form-control" id="inputhorarioconsulta" name="horarioconsulta">
                                </div>                       
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputmedicamentos">Medicamentos:</label>
                                    <textarea  class="form-control" name="medicamentos"></textarea>
                                </div>
                            </div> 

                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputexames">Exames:</label>
                                    <textarea class="form-control" name="exames"></textarea>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputprocedimento">Procedimentos:</label>
                                    <textarea class="form-control" name="procedimento"></textarea>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-12">
                                    <label for="inputregistro">Registro de Observações:</label>
                                    <textarea class="form-control" name="registro"></textarea>
                                </div>
                            </div>

                            <div class="form-row">
                                <button type="submit" class="btn btn-primary" style=" float: left; margin-left: 1.5%">Cadastrar Prontuario</button> 
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
                <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0; margin-top: 45%;
                     background-color: #7986cb; padding: 4px; color: white; font-size: 10pt;">
                    &copy; Desenvolvido por Luciane Benetti e Marco Sena.
                </div>
                </body>
                </html>
