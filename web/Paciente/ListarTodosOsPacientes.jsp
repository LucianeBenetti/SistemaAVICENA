<%@page import="model.vo.Paciente.PacienteVO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>    
        <meta charset= "utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
        <div class="container-fluid">
           
        <p style="font-size: medium; font-weight: bold">Lista dos pacientes cadastrados na cl�nica Avicena:</p>
            <div style="overflow-x:auto;">
                <table class="table table-borderless table-sm table-hover table-primary table-striped">
                    <thead>
                        <tr class="table-success" >
                            <th>Id</th>
                            <th>Nome</th>
                            <th>Celular</th>
                            <th>Fone Residencial</th>
                            <th>Fone Comercial</th>
                            <th>e-mail</th>
                            <th>CPF</th>
                            <th>CNPJ</th>
                            <th>Logradouro</th>
                            <th>N�mero</th>
                            <th>Complemento</th>
                            <th>Bairro</th>
                            <th>Cidade</th>
                            <th>UF</th>
                            <th>CEP</th>
                        </tr>
                    </thead>
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

            </div>
        </div>  
        <div class="jumbotron jumbotron-fluid text-center" style="clear: both; margin-bottom:0;
                 margin-top: 35%; background-color: #7986cb;padding: 4px; color: white; font-size: small; ">
                &copy; Desenvolvido por Luciane Benetti e Marco Sena.
            </div>
    </body>
</html>
