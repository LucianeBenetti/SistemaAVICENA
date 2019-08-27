var tabela = document.getElementById("tabelaConsulta");
var linhas = tabela.getElementsByTagName("tr");
for (var i = 0; i < linhas.length; i++) {
    var linha = linhas[i];
    linha.addEventListener("click", function () {
        //Adicionar ao atual
        selLinha(this, false); //Selecione apenas um
    });
}

/**
 Caso passe false, você só pode selecionar uma linha por vez.
 **/
function selLinha(linha, multiplos) {
    if (!multiplos) {
        var linhas = linha.parentElement.getElementsByTagName("tr");
        for (var i = 0; i < linhas.length; i++) {
            var linha_ = linhas[i];
            linha_.classList.remove("selecionado");
        }
    }
    linha.classList.toggle("selecionado");
}

/**
 Exemplo de como capturar os dados
 **/
var btnVisualizar = document.getElementById("visualizarDados");

function clickLinhaTabelaProntuario(row) {
    var codigoprontuario = row.cells[0].innerText;
    var codigopaciente = row.cells[1].innerText;
    var nomepaciente = row.cells[2].innerText;
    var medicamentos = row.cells[3].innerText;
    var exames = row.cells[4].innerText;
    var procedimento = row.cells[5].innerText;
    var registro = row.cells[6].innerText;
    document.cadastrarprontuario.codigoprontuario.value = codigoprontuario;
    document.cadastrarprontuario.codigopaciente.value = codigopaciente;
    document.cadastrarprontuario.nomepaciente.value = nomepaciente;
    document.cadastrarprontuario.medicamentos.value = medicamentos;
    document.cadastrarprontuario.exames.value = exames;
    document.cadastrarprontuario.procedimento.value = procedimento;
    document.cadastrarprontuario.registro.value = registro;
}

function clickCheckbox() {
// Get the checkbox
    var checkBox = document.getElementById("click");
    var txtArea = document.getElementById("tornarVisivel")
    // If the checkbox is checked, display the output text
    if (checkBox.checked == true) {
        txtArea.disabled = false;
    } else {
        txtArea.disabled = true;
    }

}
function clickLinhaTabelaConsulta(row) {
    var codigoconsulta = row.cells[0].innerText;
    var codigopaciente = row.cells[1].innerText;
    var nomepaciente = row.cells[2].innerText;
    var codigoespecializacao = row.cells[3].innerText;
    var nomemedico = row.cells[4].innerText;
    var nomeespecialidade = row.cells[5].innerText;
    var codigoconvenio = row.cells[6].innerText;
    var nomeconvenio = row.cells[7].innerText;
    var dataconsulta = row.cells[8].innerText;
    var horarioconsulta = row.cells[9].innerText;
    document.cadastrarprontuario.codigoconsulta.value = codigoconsulta;
    document.cadastrarprontuario.codigopaciente.value = codigopaciente;
    document.cadastrarprontuario.nomepaciente.value = nomepaciente;
    document.cadastrarprontuario.codigoespecializacao.value = codigoespecializacao;
    document.cadastrarprontuario.nomemedico.value = nomemedico;
    document.cadastrarprontuario.nomeespecialidade.value = nomeespecialidade;
    document.cadastrarprontuario.codigoconvenio.value = codigoconvenio;
    document.cadastrarprontuario.nomeconvenio.value = nomeconvenio;
    document.cadastrarprontuario.dataconsulta.value = dataconsulta;
    document.cadastrarprontuario.horarioconsulta.value = horarioconsulta;
}

function clickLinhaTabelaReceita(row) {
    var codigoreceita = row.cells[0].innerText;
    var codigoconsulta = row.cells[1].innerText;
    var codigopaciente = row.cells[2].innerText;
    var nomepaciente = row.cells[3].innerText;
    var codigoespecializacao = row.cells[4].innerText;
    var nomemedico = row.cells[5].innerText;
    var nomeespecialidade = row.cells[6].innerText;
    var dataconsulta = row.cells[7].innerText;
    var horarioconsulta = row.cells[8].innerText;
    document.emitirreceita.codigoreceita.value = codigoreceita;
    document.emitirreceita.codigoconsulta.value = codigoconsulta;
    document.emitirreceita.cadastrarprontuariocodigopaciente.value = codigopaciente;
    document.emitirreceita.nomepaciente.value = nomepaciente;
    document.emitirreceita.codigoespecializacao.value = codigoespecializacao;
    document.emitirreceita.nomemedico.value = nomemedico;
    document.emitirreceita.nomeespecialidade.value = nomeespecialidade;
    document.emitirreceita.dataconsulta.value = dataconsulta;
    document.emitirreceita.horarioconsulta.value = horarioconsulta;
}