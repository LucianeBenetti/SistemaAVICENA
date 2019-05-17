<%-- 
    Document   : ListarTodosOsConvenios
    Created on : 17/05/2019, 14:02:10
    Author     : 80130917
--%>

<%@page import="model.vo.Convenio.ConvenioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Convenio/CRUDConvenio.css">
        <title>Todos os Convênios da Clínica Avicena</title>
    </head>
    <body class="body">

        <h1>Lista dos convênios cadastrados na clínica AVICENA</h1><br> 

        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th> 
                <th>CNPJ</th> 
                <th>Valor</th>

            </tr>            

            <%
                ArrayList<ConvenioVO> conveniosVO = (ArrayList<ConvenioVO>) request.getAttribute("convenios");

                for (ConvenioVO convenioVO : conveniosVO) {%>   
            <tr>
                <td><%= convenioVO.getCodigoConvenio()%></td>
                <td><%= convenioVO.getNomeConvenio()%></td>
                <td><%= convenioVO.getCnpjConvenio()%></td>
                <td><%= convenioVO.getValor()%></td>
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
