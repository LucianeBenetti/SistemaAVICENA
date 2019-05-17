<%-- 
    Document   : ListarTodosOsMedicos
    Created on : 08/05/2019, 15:12:57
    Author     : 80130917
--%>

<%@page import="model.vo.Medico.MedicoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Medico/CRUDMedico.css">
        <title>Todos os Médicos da Clínica Avicena</title>
    </head>
    <body class="body">

        <h1>Lista dos médicos cadastrados na clínica AVICENA</h1><br> 

        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th> 
                <th>CRM</th> 
                <th>Celular</th>
                <th>Fone WhatsApp</th>
                <th>e-mail</th>
                <th>CPF</th>
                <th>CNPJ</th>

            </tr>            

            <%
                ArrayList<MedicoVO> medicosVO = (ArrayList<MedicoVO>) request.getAttribute("medicos");

                for (MedicoVO medicoVO : medicosVO) {%>   
            <tr>
                <td><%= medicoVO.getCodigoMedico()%></td>
                <td><%= medicoVO.getNomeMedico()%></td>
                <td><%= medicoVO.getCrm()%></td>
                <td><%= medicoVO.getCelularMedico()%></td>
                <td><%= medicoVO.getCelMensagemMedico()%></td>
                <td><%= medicoVO.getEmailMedico()%></td>                        
                <td><%= medicoVO.getCpfMedico()%></td>
                <td><%= medicoVO.getCnpjMedico()%></td>

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
