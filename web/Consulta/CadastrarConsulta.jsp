<%-- 
    Document   : CadastrarConsulta
    Created on : 03/06/2019, 13:57:02
    Author     : 80130917
--%>

<%@page import="model.vo.Especializacao.EspecializacaoVO"%>
<%@page import="model.vo.Especialidade.EspecialidadeVO"%>
<%@page import="model.vo.Medico.MedicoVO"%>
<%@page import="model.vo.Convenio.ConvenioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="mascarasConsulta.js"></script>
        <script type="text/javascript" src="Consulta/selecionarTabelaEspecializacao.js"></script>
        <link type="text/css" rel="stylesheet" href="CRUDConsulta.css">
        <link type="text/css" rel="stylesheet" href="Consulta/CRUDConsulta.css">
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#calendario").datepicker({dateFormat: 'dd/mm/yy'});
            });
        </script>
        <title>Cadastrar Consulta</title>
    </head>
    <body class="body">
        <div class="form1">
            <h2>Cadastrar Consulta!</h2>

            <fieldset><legend>Digite o CPF do Paciente</legend>
                <div>
                    <form method="post" action="../pesquisardadosparaconsulta">

                        <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                        CPF<a>*</a>:<br> 
                        <input type="text" name="cpfpaciente" required onkeyup="maskIt(this, event, '###.###.###-##')">
                        <input type="submit" value="Buscar Paciente">

                    </form>
                </div>
            </fieldset>
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
        <div class="resultadodaconsulta">

            <%
                Object obj = request.getAttribute("listaEspecializacoes");
                ArrayList<EspecializacaoVO> especializacoesVO = (ArrayList<EspecializacaoVO>) obj;
                if (especializacoesVO != null) {%>

            <h2>Dados de Médicos por Especialidade</h2>
            <table id="tabelaConsulta">
                <tr>
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
            <h2>Lista de Convênios</h2>
            <table id="tabelaConsulta">
                <tr>
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
            
        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>
    </body>
</html>
