<%-- 
    Document   : ExcluirEspecializacoPorId
    Created on : 22/05/2019, 14:34:25
    Author     : 80130917
--%>

<%@page import="model.vo.Medico.MedicoVO"%>
<%@page import="model.vo.Especializacao.EspecializacaoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="Especializacao/selecionarLinhaTabela.js"></script>
    <link type="text/css" rel="stylesheet" href="CRUDEspecializacao.css">
    <link type="text/css" rel="stylesheet" href="Especializacao/CRUDEspecializacao.css">
    <title>Exclusão de Especializações por Médico</title>
</head>
<body class="body">

    <div class="consultaNome">
        <h2>Exclusão de Especialização</h2>
        <form action="pesquisarparaexcluirespecializacao" method="POST">

            <%
                Object listaMedicos = request.getAttribute("listaMedicosVO");
                if (listaMedicos != null) {
                    ArrayList<MedicoVO> medicos = (ArrayList<MedicoVO>) listaMedicos;

            %>
            <fieldset><legend>Por gentileza, selecionar o nome do Médico a ser pesquisado:</legend>
                <select name="medicoSelecionado" >
                    <option selected disabled >Selecione um Médico</option>
                    <% for (int i = 0; i < medicos.size(); i++) {%>
                    <option name="medicoSelecionado" value="<%=(medicos.get(i).getNomeMedico())%>"><%out.println(medicos.get(i).getNomeMedico());%></option>
                    <%} %>  
                </select>
                <br /><br />
                <input type="submit" value = "Buscar Médico Selecionado">   
            </fieldset>

        </form>  
        <%} %>  
        <br><br>
        <div>
            <form action="../controledenavegacao" method="POST">
                <input type="hidden" id="avicena" name="avicena" value="avicena">
                <input type="submit" value="Voltar">
            </form>
        </div>
    </div>

    <div class="resultadodaconsultaNome">
        <h2>Resultado da pesquisa de Especialização por Nome</h2>

        <%
            Object obj = request.getAttribute("especializacaovoretornada");

            if (obj != null) {
                Boolean EspecializacaoVORetornada = (Boolean) obj;

                if (!EspecializacaoVORetornada) {%>                     
        <input type="text" size="100" style="margin-left: 5px;" value="<% out.println("Especialização não encontrada!"
                               + " Tente novamente. Se a Especialização não for cadastrada, por gentileza, cadastrá-la!!");%>">               
        <%} else {%>

        <form name="atualizarespecializacao" action="crudespecializacao" method="post">

            <fieldset><legend>Dados do Especialização</legend>
                <table id="tabelaEspecializacao">
                    <tr>
                        <th>Id</th>
                        <th>Nome</th> 
                        <th>Especialidade</th> 
                        <th>Instituição</th> 
                        <th>Ano</th> 
                    </tr>        
                    <%
                        ArrayList<EspecializacaoVO> especializacoesVO = (ArrayList<EspecializacaoVO>) request.getAttribute("especializacoesBuscadas");
                        for (EspecializacaoVO especializacaoVO : especializacoesVO) {%>   
                    <tr onclick="clickLinhaTabela(this)">
                        <td><%= especializacaoVO.getCodigoEspecializacao()%></td>
                        <td hidden><%= especializacaoVO.getMedicoVO().getCodigoMedico()%></td>
                        <td><%= especializacaoVO.getMedicoVO().getNomeMedico()%></td>
                        <td hidden><%= especializacaoVO.getEspecialidadeVO().getCodigoEspecialidade()%></td>
                        <td><%= especializacaoVO.getEspecialidadeVO().getNomeEspecialidade()%></td>
                        <td><%= especializacaoVO.getEspecialidadeVO().getInstituicao()%></td>
                        <td><%= especializacaoVO.getAnoEspecializacao()%></td>
                    </tr>     
                    <% }     %>
                </table>

                <br><br>
                ID Especialização: <br>
                <input type="text" name="codigoespecializacao" size="4" readonly> <br><br>
                <input type="hidden"  name="codigomedico" size="4" readonly>
                Nome do Médico: <br>
                <input type="text" name="nomemedico" size="80" readonly> <br><br>
                <input type="hidden" name="codigoespecialidade" size="4" readonly>
                Nome da Especialidade: <br>
                <input type="text" name="nomeespecialidade" size="80" readonly> <br><br>
                Instituicao:<br>
                <input type="text" name="instituicaoespecialidade" size="80" readonly> <br><br>
                Ano:<br>
                <input type="text" name="anoespecializacao" size="8" readonly> <br><br>
                <br><br>
                
                <input type="hidden" id="excluir" name="excluir" value="excluir">
                <input type="submit" value="Excluir Especializacao">
            </fieldset>
        </form><br><br>
        <%}
                }%>      
    </div>            


    <footer class="footer">                
        &copy; Desenvolvido por Luciane Benetti e Marco Sena.
    </footer>

</body>
</html>

