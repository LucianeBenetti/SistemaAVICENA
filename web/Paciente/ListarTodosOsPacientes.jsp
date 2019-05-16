<%-- 
    Document   : ListarTodosOsPacientes
    Created on : 29/03/2019, 14:03:09
    Author     : 80119050
--%>

<%@page import="model.vo.Paciente.PacienteVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="Paciente/CRUDPaciente.css">
        <title>Todos os Pacientes da Clínica Avicena</title>
    </head>
    <body class="body">

        <h1>Lista dos pacientes cadastrados na clínica AVICENA</h1><br> 
        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th> 
                <th>Celular</th>
                <th>Fone Residencial</th>
                <th>Fone Comercial</th> 
                <th>e-mail</th>
                <th>CPF</th>
                <th>CNPJ</th>
                <th>Logradouro</th> 
                <th>Número</th>
                <th>Complemento</th>
                <th>Bairro</th>
                <th>Cidade</th> 
                <th>UF</th>
                <th>CEP</th>
            </tr>            

            <%
                ArrayList<PacienteVO> pacientesVO = (ArrayList<PacienteVO>) request.getAttribute("pacientes");

                for (PacienteVO pacienteVO : pacientesVO) {%>   
            <tr>
                <td><%= pacienteVO.getCodigoPaciente()%></td>
                <td><%= pacienteVO.getNomePaciente()%></td>
                <td><%= pacienteVO.getCelMensagemPaciente()%></td>
                <td><%= pacienteVO.getFoneResidencial()%></td>
                <td><%= pacienteVO.getFoneComercial()%></td>
                <td><%= pacienteVO.getEmailPaciente()%></td>                        
                <td><%= pacienteVO.getCpfPaciente()%></td>
                <td><%= pacienteVO.getCnpjPaciente()%></td>
                <td><%= pacienteVO.getLogradouro()%></td>
                <td><%= pacienteVO.getNumLogradouro()%></td>
                <td><%= pacienteVO.getComplemento()%></td>
                <td><%= pacienteVO.getBairro()%></td>
                <td><%= pacienteVO.getCidade()%></td>
                <td><%= pacienteVO.getUf()%></td>
                <td><%= pacienteVO.getCep()%></td>
            </tr>                   

            <%
                }
            %>
        </table>      

       <div>
            <form action="controledenavegacao" method="POST">
                <input type="hidden" id="avicena" name="avicena" value="avicena">
                <input type="submit" value="Voltar">
            </form>
        </div>  

        <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>

    </body>
</html>
