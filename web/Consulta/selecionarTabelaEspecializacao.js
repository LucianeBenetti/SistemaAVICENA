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
function clickLinhaTabela(row) {
    var codigoespecializacao = row.cells[0].innerText;
    var codigomedico = row.cells[1].innerText;
    var nomemedico = row.cells[2].innerText;
    var codigoespecialidade = row.cells[3].innerText;
    var nomeespecialidade = row.cells[4].innerText;
    var instituicao = row.cells[5].innerText;
    var ano = row.cells[6].innerText;
    document.cadastrarconsulta.codigoespecializacao.value = codigoespecializacao;
    document.cadastrarconsulta.codigomedico.value = codigomedico;
    document.cadastrarconsulta.nomemedico.value = nomemedico;
    document.cadastrarconsulta.codigoespecialidade.value = codigoespecialidade;
    document.cadastrarconsulta.nomeespecialidade.value = nomeespecialidade;
    document.cadastrarconsulta.instituicao.value = instituicao;
    document.cadastrarconsulta.ano.value = ano;
}

function clickLinhaTabelaConvenio(row) {
    var codigoconvenio = row.cells[0].innerText;
    var nomeconvenio = row.cells[1].innerText;
    var valorconvenio = row.cells[2].innerText;
    document.cadastrarconsulta.codigoconvenio.value = codigoconvenio;
    document.cadastrarconsulta.nomeconvenio.value = nomeconvenio;
    document.cadastrarconsulta.valorconvenio.value = valorconvenio;
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
function clickExcluirConsulta(row) {
    var codigoconsulta = row.cells[0].innerText;
    var nomepaciente = row.cells[1].innerText;
    var nomemedico = row.cells[2].innerText;
    var nomeespecialidade = row.cells[3].innerText;
    var nomeconvenio = row.cells[4].innerText;
    var dataconsulta = row.cells[5].innerText;
    var horarioconsulta = row.cells[6].innerText;
    document.excluirconsulta.codigoconsulta.value = codigoconsulta;
    document.excluirconsulta.nomepaciente.value = nomepaciente;
    document.excluirconsulta.nomemedico.value = nomemedico;
    document.excluirconsulta.nomeespecialidade.value = nomeespecialidade;
    document.excluirconsulta.nomeconvenio.value = nomeconvenio;
    document.excluirconsulta.dataconsulta.value = dataconsulta;
    document.excluirconsulta.horarioconsulta.value = horarioconsulta;
}

function clickAtualizarConsulta(row) {
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
    var atencaoespecial = row.cells[10].innerText;
    document.atualizarconsulta.codigoconsulta.value = codigoconsulta;
    document.atualizarconsulta.codigopaciente.value = codigopaciente;
    document.atualizarconsulta.nomepaciente.value = nomepaciente;
    document.atualizarconsulta.codigoespecializacao.value = codigoespecializacao;
    document.atualizarconsulta.nomemedico.value = nomemedico;
    document.atualizarconsulta.nomeespecialidade.value = nomeespecialidade;
    document.atualizarconsulta.codigoconvenio.value = codigoconvenio;
    document.atualizarconsulta.nomeconvenio.value = nomeconvenio;
    document.atualizarconsulta.dataconsulta.value = dataconsulta;
    document.atualizarconsulta.horarioconsulta.value = horarioconsulta;
    document.atualizarconsulta.atencaoespecial.value = atencaoespecial;
}