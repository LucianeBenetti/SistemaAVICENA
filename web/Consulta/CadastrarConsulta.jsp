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

                    <%  Object obj = request.getAttribute("listaEspecializacoes");
                        ArrayList<EspecializacaoVO> especializacoesVO = (ArrayList<EspecializacaoVO>) obj;
                        if (especializacoesVO != null) {%>





                    <form name="cadastrarconsulta" action="cadastrarconsulta" method="post">
                        <fieldset>
                            <input type="hidden" name="codigoespecializacao" size="4" readonly>
                            Nome: <br>                       
                            <input type="text" readonly name="nomepaciente" size="50" required value="<%= request.getAttribute("nomepaciente")%>"><br><br>  
                            <input type="hidden" name="codigopaciente" value="<%= request.getAttribute("codigopaciente")%>">
                            Nome do Médico: <br>
                            <input type="text" name="nomemedico" required size="50" readonly> <br><br>
                            <input type="hidden" name="codigoespecialidade" size="4" readonly>
                            Nome da Especialidade: <br>
                            <input type="text" name="nomeespecialidade" required size="50" readonly> <br><br>
                            <input type="hidden" name="instituicao" size="50" readonly>
                            <input type="hidden" name="ano" size="8"> 
                            Convênio <br>                       
                            <input type="text" readonly name="nomeconvenio" required size="50"><br><br>
                            <input type="hidden" readonly name="codigoconvenio" size="50">
                            <input type="hidden" readonly name="valorconvenio" size="50">
                            <input type="hidden"  name="codigomedico" size="4" readonly>
                            <div style="width:55%">
                                <div style="float:left"> Data<a>*</a>: </div>
                                <div style="float:right"> Horário<a>*</a>: </div>
                            </div>
                            <br>
                            <div style="width:80%">
                                <div style="float:left"> <input type="text" name="dataconsulta" id="calendario" size="20" required></div>    
                                <select style="width:180px; margin-left: 30px;" name="horaconsulta" required><option selected disabled>Selecione um horário</option><br><br>
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
                                </select><br><br> 
                                <input type="checkbox" id="click" onclick="clickCheckbox(this)"> Necessita de atenção especial?
                                <textarea disabled name="atencaoespecial" id="tornarVisivel"></textarea>
                            </div><br><br>   
                            <input type="submit" value="Cadastrar Consulta">
                            <br><br>    
                        </fieldset> 
                    </form>
                </div>

                <div class="container-fluid">

                    <div style="overflow-x:auto;">
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
                        <br><br>
                        </form>
                        <br><br>
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

                                <br><br>
                            </div>    
                        </div>
                    </div>
                            <script>
                                $(function () {
                                    $("#calendario").datepicker({dateFormat: 'dd/mm/yy'});
                                });
                            </script>  
           <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0; margin-top: 25%; 
             background-color: #7986cb;padding: 4px; color: white; font-size: small; ">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </div>

                            </body>
                            </html>
