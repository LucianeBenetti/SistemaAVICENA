var tabela = document.getElementById("tabelaEspecializacao");
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
    var cod = row.cells[0].innerText;
    var codigomedico = row.cells[1].innerText;
    var medico = row.cells[2].innerText;
    var codigoespecialidade = row.cells[3].innerText;
    var especialidade = row.cells[4].innerText;
    var instituicao = row.cells[5].innerText;
    var ano = row.cells[6].innerText;
    document.atualizarespecializacao.codigoespecializacao.value = cod;
    document.atualizarespecializacao.codigomedico.value = codigomedico;
    document.atualizarespecializacao.nomemedico.value = medico;
    document.atualizarespecializacao.codigoespecialidade.value = codigoespecialidade;
    document.atualizarespecializacao.nomeespecialidade.value = especialidade;
    document.atualizarespecializacao.instituicaoespecialidade.value = instituicao;
    document.atualizarespecializacao.anoespecializacao.value = ano;
}

