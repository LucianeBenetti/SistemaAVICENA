<%@page import="model.vo.Especializacao.EspecializacaoVO"%>
<%@page import="model.vo.Medico.MedicoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.vo.Especialidade.EspecialidadeVO"%>
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

                    <p style="text-align: center; font-weight: bold">Informe o ano da especialização para cadastrar na base de dados:</p>

                    <%
                        Object listaMedicosEspecialidades = request.getAttribute("listaMedicosEspecialidadesVO");
                        if (listaMedicosEspecialidades != null) {
                            ArrayList<EspecializacaoVO> especializacoes = (ArrayList<EspecializacaoVO>) listaMedicosEspecialidades;
                    %>

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
                   
                        <input type="reset" value="Limpar Campos">
                        <input type="submit" value = "Cadastrar Especialização">    
                    </form>

                    <%}%> 
                </div>

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

