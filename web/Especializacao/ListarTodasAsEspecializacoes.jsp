<%@page import="model.vo.Especializacao.EspecializacaoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>    
        <meta charset= "utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link type="text/css" rel="stylesheet" href="Especializacao/CRUDEspecializacao.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <title>Sistema Avicena</title>    
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
        <div class="container">
            <h1>Lista das especializações cadastrads na clínica AVICENA</h1><br> 
            <table id="tabelaListarTodas">
                <tr>
                    <th>Id</th>
                    <th>Nome</th> 
                    <th>Especialidade</th> 
                    <th>Ano</th> 
                    <th>Instituição</th> 
                </tr>            
                <%
                    ArrayList<EspecializacaoVO> especializacaosVO = (ArrayList<EspecializacaoVO>) request.getAttribute("especializacoes");

                    for (EspecializacaoVO especializacaoVO : especializacaosVO) {%>   
                <tr>
                    <td><%= especializacaoVO.getCodigoEspecializacao()%></td>
                    <td><%= especializacaoVO.getMedicoVO().getNomeMedico()%></td>
                    <td><%= especializacaoVO.getEspecialidadeVO().getNomeEspecialidade()%></td>
                    <td><%= especializacaoVO.getAnoEspecializacao()%></td>
                    <td><%= especializacaoVO.getEspecialidadeVO().getInstituicao()%></td>
                </tr>                   
                <%
                    }
                %>
            </table>      
            <br><br>
        </div>
    </body>
</html>
