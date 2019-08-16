<%@page import="model.vo.Prontuario.ProntuarioVO"%>
<%@page import="model.vo.Convenio.ConvenioVO"%>
<%@page import="model.vo.Consulta.ConsultaVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="mascarasProntuario.js"></script>
        <script type="text/javascript" src="Prontuario/selecionarTabelaConsulta.js"></script>
        <link type="text/css" rel="stylesheet" href="ProntuarioCRUD.css">
        <link type="text/css" rel="stylesheet" href="Prontuario/ProntuarioCRUD.css">
        <title>Cadastrar Prontuário</title>
    </head>
    <body class="body">
        <div class="form1">
            <h2>Cadastrar Prontuario!</h2>

            <fieldset><legend>Digite o CPF do Paciente</legend>
                <div>
                    <form method="post" action="../pesquisardadosparacadastrarprontuario">

                        <p><a>*</a>Campos de preenchimento obrigatório</p>                    

                        CPF<a>*</a>:<br> 
                        <input type="text" name="cpfpaciente" required onkeyup="maskIt(this, event, '###.###.###-##')">
                        <input type="submit" value="Buscar Paciente"><br><br>
                    </form>

                </div>
                <form name="cadastrarprontuario" action="cadastrarprontuario" method="post">
                    Nome: <br>   
                    <input type="text" readonly name="nomepaciente" size="50" required ><br><br> 
                    <div style="width:55%">
                        <div style="float:left"> Data: </div>
                        <div style="float:right"> Horário: </div>
                    </div>
                    <br>
                    <div style="width:80%">
                        <div style="float:left"> <input type="text" readonly name="dataconsulta" size="20" ></div>    
                        <div style="float:right"> <input type="text" readonly name="horarioconsulta" size="20"></div>  <br><br>  
                    </div>
            </fieldset>
            <fieldset>
                       
                Medicamentos:
                <textarea name="medicamentos"></textarea><br><br>
                Exames:<br>
                <textarea name="exames"></textarea><br><br>
                Registro de Observações:<br>
                <textarea name="registro" ></textarea><br><br>
                
                <input type="submit" value="Cadastrar Prontuario">
                <br><br>    
            </fieldset> 
        </form>
    </div><br><br>            
    <footer class="footer">                
        &copy; Desenvolvido por Luciane Benetti e Marco Sena.
    </footer>
</body>
</html>
