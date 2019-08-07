<%-- 
    Document   : ListarTodasAsConsultas
    Created on : 24/05/2019, 09:05:33
    Author     : 80130917
--%>

<%@page import="model.vo.Consulta.ConsultaVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Consulta/CRUDConsulta.css">
        <link type="text/css" rel="stylesheet" href="CRUDConsulta.css">
        <title>Todos os Consultas da Clínica Avicena</title>
    </head>
    <body class="body">

        <h1>Lista das Consultas cadastrados na clínica AVICENA</h1><br> 

        <table id="tabelaListarTodas">
            <tr>
                <th>Id</th>
                <th>Nome do Paciente</th> 
                <th>Nome do Médico</th> 
                <th>Especialidade do Médico</th>
                <th>Convênio</th>
                <th>Data da Consulta</th>
                <th>Horário da Consulta</th>

            </tr>            

            <%
                ArrayList<ConsultaVO> consultasVO = (ArrayList<ConsultaVO>) request.getAttribute("consultas");

                for (ConsultaVO consultaVO : consultasVO) {%>   
            <tr>
                <td><%= consultaVO.getCodigoConsulta()%></td>
                <td><%= consultaVO.getPacienteVO().getNomePaciente()%></td>
                <td><%= consultaVO.getEspecializacaoVO().getMedicoVO().getNomeMedico()%></td>
                <td><%= consultaVO.getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade()%></td>
                <td><%= consultaVO.getConvenioVO().getNomeConvenio()%></td>
                <td><%= consultaVO.getDataConsulta()%></td>
                <td><%= consultaVO.getHorarioConsulta()%></td>
            </tr>                   

            <%
                }
            %>
        </table>      
        <br><br>
        <form action="controledenavegacao" method="post">
            <input type="hidden" id="avicena" name="avicena" value="avicena">
            <input type="submit" value = "Voltar">
        </form>

        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>

    </body>
</html>
