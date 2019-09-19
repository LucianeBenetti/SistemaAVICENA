<%@page import="model.vo.Medico.MedicoVO"%>
<%@page import="model.vo.Consulta.ConsultaVO"%>
<%@page import="model.vo.Convenio.ConvenioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>    
        <meta charset= "utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <style>
            /* Make the image fully responsive */
            .carousel-inner img {
                width: 100%;
            }

            .generico
            {text-align: center; border-color: transparent; color: red; padding: 10px}

        </style> 
    </head>
    <body>  
        <nav class="navbar navbar-expand-sm navbar-dark justify-content-left" 
             style= "background-color: #7986cb; font-size: 18px; color: #ffffff; ">
            <a class="navbar-brand">
                <img src="icon2.png" alt="logo" style="width:50px; height: 30px;">
            </a>
            <ul class="navbar-nav">
                <form action="controledenavegacao" method="POST">
                    <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                    <input type="submit" value="Inicio" style="border:none; background-color: #7986cb; color: white; padding: 8px;">
                </form>  
                <li>
                    <form action="controledenavegacao" method="POST">
                        <input type="hidden" id="sair" name="sair" value="sair">
                        <input type="submit" value="Sair" style="border:none; background-color: #7986cb; color: white; padding: 8px;">
                    </form>
                </li>
            </ul>
        </nav>

        <h2>Relatório de Consultas por Médico</h2>
        <br><br>
        <form name="f1"  action="pesquisarconsultapormedico" method="POST">

            <div class="container-fluid">

                <%
                    Object listaMedicos = request.getAttribute("listamedicosvo");
                    if (listaMedicos != null) {
                        ArrayList<MedicoVO> medicos = (ArrayList<MedicoVO>) listaMedicos;
                %>

                <h5>Por gentileza, selecionar o nome do Médico a ser pesquisado:</h5>
                <select name="medicoselecionado" >
                    <option selected disabled >Selecione um Médico</option>
                    <% for (int i = 0; i < medicos.size(); i++) {%>
                    <option name="medicoselecionado" value="<%=(medicos.get(i).getNomeMedico())%>"><%out.println(medicos.get(i).getNomeMedico());%></option>
                    <%} %>  
                </select>
                <br /><br />
                <input type="submit" value = "Buscar Médico Selecionado">   

                <%} %>  
                <br><br>
            </div>
        </form>  
        <form name="f2" action="gerarrelatorioconsultaspormedico" method="post">
            <div class="container-fluid">
                <%
                    Object consultas = request.getAttribute("listadeconsultas");
                    ArrayList<ConsultaVO> consultasVO = (ArrayList<ConsultaVO>) consultas;
                    if (consultasVO != null) {%>
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
                        </thead>
                        <% for (ConsultaVO consultaVO : consultasVO) {%>  

                        <tr onclick="clickAtualizarConsulta(this)">
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
                        <% }  %>
                    </table>
                    <br><br>
                    <input type="hidden" id="gerarrelatorio" name="gerarrelatorio" value="gerarrelatorio">
                    <input type="submit" value="Gerar Relatório">
                    <%  }%>    

                    <br><br>         
                </div>
        </form>
     
        <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0; margin-top: 45%;
             background-color: #7986cb; padding: 4px; color: white; font-size: 10pt;">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </div>
    </body>
</html>
