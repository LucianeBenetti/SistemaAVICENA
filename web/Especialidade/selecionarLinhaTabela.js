var tabela = document.getElementById("tabelaEspecialidades");
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
    var cod=row.cells[0].innerText;
    var especialidade=row.cells[1].innerText;
    var instituicao=row.cells[2].innerText;;
    document.atualizarespecialidade.codigoespecialidade.value=cod;
    document.atualizarespecialidade.nomeespecialidade.value=especialidade;
    document.atualizarespecialidade.instituicaoespecialidade.value=instituicao;
}

