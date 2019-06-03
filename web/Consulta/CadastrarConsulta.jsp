<%-- 
    Document   : CadastrarConsulta
    Created on : 03/06/2019, 13:57:02
    Author     : 80130917
--%>

<%@page import="model.vo.Convenio.ConvenioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link type="text/css" rel="stylesheet" href="ConsultaCRUD.css">
        <link type="text/css" rel="stylesheet" href="Consulta/ConsultaCRUD.css">
        <title>Cadastrar Consulta</title>
    </head>
    <body class="body">
        <div class="form1">
            <h2>Pesquisar Paciente por CPF!</h2>

            <form method="post" action="../pesquisarpacienteparaconsulta">

                <fieldset><legend>Digite o CPF do Paciente a ser consultado na base de dados</legend>
                    <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                    CPF<a>*</a>:<br> 
                    <input type="text" name="cpfpaciente" required onkeyup="maskIt(this, event, '###.###.###-##')"><br><br>
                    <input type="submit" value = "Pesquisar Paciente">                

                </fieldset>
            </form>
            <br><br>
        </div>
              <div class="secao3">
                  
                  <form action="pesquisarconvenio" method="POST">
                       <input type="submit" value = "Convênio">       
                  </form>                              

            <%
                Object listaConvenios = request.getAttribute("listaconveniosvo");
                if (listaConvenios != null) {
                    ArrayList<ConvenioVO> convenios = (ArrayList<ConvenioVO>) listaConvenios;

            %>
            <fieldset><legend>Por gentileza, selecionar o nome do Médico a ser pesquisado:</legend>
                <select name="convenioSelecionado" >
                    <option selected disabled >Selecione um Convênio</option>
                    <% for (int i = 0; i < convenios.size(); i++) {%>
                    <option name="convenioSelecionado" value="<%=(convenios.get(i).getNomeConvenio())%>"><%out.println(convenios.get(i).getNomeConvenio());%></option>
                    <%} %>  
                </select>
                <br /><br />
                <input type="submit" value = "Buscar Convênio Selecionado">   
            </fieldset>

        </form>  
        <%} %>  
        <br><br>
        </div>

        <%
            Object obj = request.getAttribute("pacientevoretornado");

            if (obj != null) {
                Boolean PacienteVORetornado = (Boolean) obj;

                if (!PacienteVORetornado) {%>                     
        Paciente não encontrado! Tente novamente. Se o Paciente não for cadastrado, por gentileza, cadastrá-lo!!           
        <%} else {%>
        
        <div class="form2">
            <form action="crudconsulta" method="post">
                Nome: <br>                       
                <input type="text" name="nomepaciente" size="77" value="<%= request.getAttribute("nomepaciente")%>"><br><br>            
                Convênio <br>                       
                <input type="text" name="conveniopaciente" size="77" value=""><br><br>  
                Médico <br>                       
                <input type="text" name="conveniopaciente" size="77" value=""><br><br> 
                Especialidade <br>                       
                <input type="text" name="conveniopaciente" size="77" value=""><br><br> 
                Data <br>                       
                <input type="text" name="conveniopaciente" size="77" value=""><br><br> 
                Hora <br>                       
                <input type="text" name="conveniopaciente" size="77" value=""><br><br> 
                <input type="submit" value="Cadastrar Consulta">
                </fieldset>
            </form><br><br>
            <%}
                }%>      
        </div>        
        <div class ="secao4">
            
            
        </div>    
          <footer class="footer">                
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </footer>

    </body>
</html>
