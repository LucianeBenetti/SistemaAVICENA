<%-- 
    Document   : ListarTodosOsProntuarios
    Created on : 24/05/2019, 09:06:03
    Author     : 80130917
--%>

<%@page import="model.vo.Prontuario.ProntuarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Prontuario/CRUDProntuario.css">
        <title>Todos os Prontuários da Clínica Avicena</title>
    </head>
    <body class="body">

        <h1>Lista dos Prontuários cadastrados na clínica AVICENA</h1><br> 

        <table id="tabelaListarTodas">
            <tr>
                <th>Id</th>
                <th>Nome do Paciente</th> 
                <th>Nome do Médico</th> 
                <th>Especialidade do Médico</th>
                <th>Convênio</th>
                <th>Data da Consulta</th>
                <th>Horário da Consulta</th>
                <th>Medicamentos</th>
                <th>Exames</th>
                <th>Registro</th>

            </tr>            

            <%
                ArrayList<ProntuarioVO> prontuariosVO = (ArrayList<ProntuarioVO>) request.getAttribute("prontuarios");

                for (ProntuarioVO prontuarioVO : prontuariosVO) {%>   
            <tr>
                <td><%= prontuarioVO.getCodigoProntuario()%></td>
                <td><%= prontuarioVO.getConsultaVO().getPacienteVO().getNomePaciente()%></td>
                <td><%= prontuarioVO.getConsultaVO().getEspecializacaoVO().getMedicoVO().getNomeMedico()%></td>
                <td><%= prontuarioVO.getConsultaVO().getEspecializacaoVO().getEspecialidadeVO().getNomeEspecialidade()%></td>
                <td><%= prontuarioVO.getConsultaVO().getConvenioVO().getNomeConvenio()%></td>
                <td><%= prontuarioVO.getConsultaVO().getDataConsulta()%></td>
                <td><%= prontuarioVO.getConsultaVO().getHorarioConsulta()%></td>
                <td><%= prontuarioVO.getMedicamento()%></td>
                <td><%= prontuarioVO.getExame()%></td>
                <td><%= prontuarioVO.getRegistro()%></td>
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
