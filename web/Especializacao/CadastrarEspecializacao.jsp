<%-- 
    Document   : CadastrarEspecializacao
    Created on : 22/05/2019, 09:26:11
    Author     : 80130917
--%>

<%@page import="model.vo.Especializacao.EspecializacaoVO"%>
<%@page import="model.vo.Especialidade.EspecialidadeVO"%>
<%@page import="model.vo.Medico.MedicoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="CRUDEspecializacao.css">
    <link type="text/css" rel="stylesheet" href="Especializacao/CRUDEspecializacao.css">
    <title>Cadastrar Especializacao</title>
</head>
<body class="body">
    <hr>
    <h1>Cadastro de Especialização</h1>
    <h3>Por gentileza, selecionar os dados do especialização a ser cadastrada:</h3> 

    <div class="form1">
        <%
            Object listaMedicos = request.getAttribute("listaMedicosVO");
            if (listaMedicos != null) {
                ArrayList<MedicoVO> medicos = (ArrayList<MedicoVO>) listaMedicos;

        %>
        <fieldset>   
            <h4>Selecione o Médico</h4>
            <form action="pesquisarmedicoespecialidadeparacadastrar" method="POST">

                <select name="medicoSelecionado" >
                    <option selected disabled >Selecione um Médico</option>
                    <% for (int i = 0; i < medicos.size(); i++) {%>
                    <option name="medicoSelecionado" value="<%=(medicos.get(i).getNomeMedico())%>"><%out.println(medicos.get(i).getNomeMedico());%></option>
                    <%} %>  
                </select>

                <h4>Selecione a Especialidade do Médico</h4>
                <%
                    Object listaEspecialidades = request.getAttribute("listaEspecialidadesVO");
                    if (listaEspecialidades != null) {
                        ArrayList<EspecialidadeVO> especialidades = (ArrayList<EspecialidadeVO>) listaEspecialidades;
                %>
                <select name="especialidadeSelecionada" >
                    <option selected disabled >Selecione uma Especialidade</option>
                    <% for (int i = 0; i < especialidades.size(); i++) {%>
                    <option name="especialidadeSelecionada" value="<%=(especialidades.get(i).getNomeEspecialidade())%>"><%out.println(especialidades.get(i).getNomeEspecialidade());%></option>

                    <%}%>  
                    <%}%>
                </select>
                <br /><br />
                <input type="submit" value = "Buscar Dados Selecionados">  
            </form>
        </fieldset>
        <%}%>      

    </div>

    <div class="form2">
      
            <%
                Object listaMedicosEspecialidades = request.getAttribute("listaMedicosEspecialidadesVO");
                if (listaMedicosEspecialidades != null) {
                    ArrayList<EspecializacaoVO> especializacoes = (ArrayList<EspecializacaoVO>) listaMedicosEspecialidades;
            %>

            <fieldset>      
                  <form action="crudespecializacao" method="POST">
                <a>*</a>Campos de preenchimento obrigatório <br><br>
                <input type="hidden" id="cadastrar" name="cadastrar" value="cadastrar">

                <% for (int i = 0; i < especializacoes.size(); i++) {%>
                Id Medico: <br>
                <input type="text" name="codigomedico" readonly size="3" value="<%=(especializacoes.get(i).getMedicoVO().getCodigoMedico())%>"><br><br>
                Nome do Médico: <br>
                <input type="text" name="nomemedico" readonly size="80" value="<%=(especializacoes.get(i).getMedicoVO().getNomeMedico())%>"><br><br>

                Id Especialidade <br>
                <input type="text" name="codigoespecialidade" readonly size="3" value="<%=(especializacoes.get(i).getEspecialidadeVO().getCodigoEspecialidade())%>"><br><br>
                Nome da Especialidade: <br>
                <input type="text" name="nomeespecialidade" readonly size="80" value="<%=(especializacoes.get(i).getEspecialidadeVO().getNomeEspecialidade())%>"><br><br>

                Instituição: <br>         
                <input type="text" name="instituicaoespecialidade" readonly size="80" value="<%=(especializacoes.get(i).getEspecialidadeVO().getInstituicao())%>"><br><br>
                Ano<a>*</a>: <br>
                <input type="text" name="anoespecializacao" required size="8"><br><br>
                <%}%>  
                <br><br>
                <input type="reset" value="Limpar Campos">
                <input type="submit" value = "Cadastrar Especialidade">    
        </form>

            </fieldset>
            <%}%> 


    </div>

    <div>
        <form action="../controledenavegacao" method="post">
            <input type="hidden" id="avicena" name="avicena" value="avicena">
            <input type="submit" value = "Voltar">
        </form>   
    </div>
    <footer class="footer">                
        &copy; Desenvolvido por Luciane Benetti e Marco Sena.
    </footer>    

</body>
</html>