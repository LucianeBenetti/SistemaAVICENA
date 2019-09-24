<%@page import="model.vo.Convenio.ConvenioVO"%>
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
        <script type="text/javascript" src="Consulta/selecionarTabelaEspecializacao.js"></script>
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

                <div class="form" style="background-color: #c8e6c9; padding: 10px; width: 60%;  
                     border-radius: 10px; float: left; margin-left: 20%;">

                    <p style="text-align: center; font-weight: bold">Lista das especialidades cadastradas na clínica AVICENA:</p>

                    <%  Object obj = request.getAttribute("listaEspecializacoes");
                        ArrayList<EspecializacaoVO> especializacoesVO = (ArrayList<EspecializacaoVO>) obj;
                        if (especializacoesVO != null) {%>
                    <div class="container-fluid">

                        <div >
                            <table class="table table-borderless table-sm table-hover table-primary table-striped">
                                <thead>
                                    <tr class="table-success" >
                                        <th>Id</th>
                                        <th>Nome do Médico</th> 
                                        <th>Especialidade</th> 
                                    </tr>        
                                    <% for (EspecializacaoVO especializacaoVO : especializacoesVO) {%>  

                                    <tr onclick="clickLinhaTabela(this)">
                                        <td><%= especializacaoVO.getCodigoEspecializacao()%></td>
                                        <td hidden><%= especializacaoVO.getMedicoVO().getCodigoMedico()%></td>
                                        <td><%= especializacaoVO.getMedicoVO().getNomeMedico()%></td>
                                        <td hidden><%= especializacaoVO.getEspecialidadeVO().getCodigoEspecialidade()%></td>
                                        <td><%= especializacaoVO.getEspecialidadeVO().getNomeEspecialidade()%></td>
                                        <td hidden><%= especializacaoVO.getEspecialidadeVO().getInstituicao()%></td>
                                        <td hidden><%= especializacaoVO.getAnoEspecializacao()%></td>
                                    </tr>     
                                    <% }     %>
                                    <% }     %>
                            </table>
                            <%
                                Object objconvenio = request.getAttribute("convenios");
                                ArrayList<ConvenioVO> conveniosVO = (ArrayList<ConvenioVO>) objconvenio;
                                if (conveniosVO != null) {%>
                            <div class="container-fluid">

                                <div style="overflow-x:auto;">
                                    <table class="table table-borderless table-sm table-hover table-primary table-striped">
                                        <thead>
                                            <tr class="table-success" >
                                                <th>Id</th>
                                                <th>Nome do Convênio</th> 
                                                <th>Valor (R$)</th> 
                                            </tr>        
                                            <%
                                                for (ConvenioVO convenioVO : conveniosVO) {%>   
                                            <tr onclick="clickLinhaTabelaConvenio(this)">
                                                <td><%= convenioVO.getCodigoConvenio()%></td>
                                                <td><%= convenioVO.getNomeConvenio()%></td>
                                                <td><%= convenioVO.getValor()%></td>
                                            </tr>     
                                            <% }     %>
                                            <% }%>
                                    </table>
                                </div>    
                            </div>
                        </div>
                    </div>

                    <form name="cadastrarconsulta" action="cadastrarconsulta" method="post">

                        <input type="hidden" name="codigoespecializacao" size="4" readonly>
                        <input type="hidden" name="codigoespecialidade" size="4" readonly>
                        <input type="hidden" readonly name="codigoconvenio" size="50">
                        <input type="hidden" readonly name="valorconvenio" size="50">
                        <input type="hidden" name="ano" size="8"> 
                        <input type="hidden"  name="codigomedico" size="4" readonly>
                        <input type="hidden" name="instituicao" size="50" readonly>
                        <input type="hidden" name="codigopaciente" value="<%= request.getAttribute("codigopaciente")%>">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputnome">Nome:</label>
                                <input type="text" class="form-control" id="inputnome" name="nomepaciente" required readonly value="<%= request.getAttribute("nomepaciente")%>">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputnomeconvenio">Convênio:</label>
                                <input type="text" class="form-control" id="inputnomeconvenio" name="nomeconvenio">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputnomemedico">Nome do Médico:</label>
                                <input type="nomemedico" class="form-control" id="inputnomemedico" name="nomemedico">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputnomeespecialidade">Especialidade</label>
                                <input type="text" class="form-control" id="inputnomeespecialidade" name="nomeespecialidade">
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
                                <input type="checkbox" id="click" onclick="clickCheckbox(this)"> Necessita de atenção especial?
                                <textarea disabled class="form-control" name="atencaoespecial" id="tornarVisivel"></textarea>
                            </div>
                        </div> 

                        <div class="form-row">
                            <button type="submit" class="btn btn-primary" style=" float: left; margin-left: 1.5%">Cadastrar Consulta</button> 
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
