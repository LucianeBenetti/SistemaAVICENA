<%@page import="model.vo.medico.MedicoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.vo.especialidade.EspecialidadeVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Avicena</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
       

        <style>
            .generico
            {text-align: center; border-color: transparent; color: red; padding: 10px}
        </style>
    </head>
    <body>

        <div class="jumbotron jumbotron-fluid text-center" style="margin-bottom:0; 
             background-color: #7986cb; padding: 20px; color: white">
            <h1>Sistema Avicena</h1>
            <p>Medicina Humanizada</p> 
        </div>
        <div class="container" style="padding: 3px; margin-top: 2%; margin-bottom: 10%;" >

            <div class="container" style="padding: 3px; margin-top: 2%; margin-bottom: 10%;" >

                <div class="form" style="background-color: #c8e6c9; padding: 10px; width: 60%;  
                     border-radius: 10px; float: left; margin-left: 20%;">

                    <p style="text-align: center; font-weight: bold">Selecione o nome da Médico para buscar sua(s) especialização(ões) da base de dados:</p>

                    <form action="pesquisarparaexcluirespecializacao" method="POST">

                        <%
                            Object listaMedicos = request.getAttribute("listaMedicosVO");
                            if (listaMedicos != null) {
                                ArrayList<MedicoVO> medicos = (ArrayList<MedicoVO>) listaMedicos;
                        %>

                        <select name="medicoSelecionado" >
                            <option selected disabled >Selecione um Médico</option>
                            <% for (int i = 0; i < medicos.size(); i++) {%>
                            <option name="medicoSelecionado" value="<%=(medicos.get(i).getNomeMedico())%>"><%out.println(medicos.get(i).getNomeMedico());%></option>
                            <%} %>  
                        </select>
                        <br /><br />
                        <button type="submit" class="btn btn-primary" style="float: left" >Pesquisar Médico</button> 

                        <%}%>  
                    </form> 

                    <form action="controledenavegacao" method="post">
                        <input type="hidden" id="voltarpaginainicial" name="voltarpaginainicial" value="voltarpaginainicial">
                        <input type="submit" value = "Voltar" class="btn btn-primary" 
                               style=" margin-left: 20px; float: left;">            
                    </form>              

                </div>

            </div>
        </div>

        <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0; margin-top: 25%; 
             background-color: #7986cb;padding: 4px; color: white; font-size: small; ">
            &copy; Desenvolvido por Luciane Benetti e Marco Sena.
        </div>

    </body>
</html>

