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
  if (checkBox.checked == true){
    txtArea.disabled = false;
  } else {
    txtArea.disabled = true;
  }
  
}

function clickExcluirConsulta(){
    var codigoconsulta = row.cells[0].innerText;
    var codogopaciente = row.cells[1].innerText;
    var nomepaciente = row.cells[2].innerText;
    var dataconsulta = row.cell[3].innerText;
    var horarioconsulta = row.cell[4].innerText;
    var codigoespecializacao = row.cells[5].innerText;
    var codigomedico = row.cells[6].innerText;
    var nomemedico = row.cells[7].innerText;
    var codigoespecialidade = row.cells[8].innerText;
    var nomeespecialidade = row.cells[9].innerText;
    var codigoconvenio = row.cells[10].innerText;
    var nomeconvenio = row.cells[11].innerText;
    document.cadastrarconsulta.codigoconsulta.value = codigoconsulta;
    document.cadastrarconsulta.codogopaciente.value = codogopaciente;
    document.cadastrarconsulta.nomepaciente.value = nomepaciente;
    document.cadastrarconsulta.dataconsulta.value = dataconsulta;
    document.cadastrarconsulta.horarioconsulta.value = horarioconsulta;
    document.cadastrarconsulta.codigoespecializacao.value = codigoespecializacao;
    document.cadastrarconsulta.codigomedico.value = codigomedico;
    document.cadastrarconsulta.nomemedico.value = nomemedico;
    document.cadastrarconsulta.codigoespecialidade.value = codigoespecialidade;
    document.cadastrarconsulta.nomeespecialidade.value = nomeespecialidade;
    document.cadastrarconsulta.codigoconvenio.value = codigoconvenio;
    document.cadastrarconsulta.nomeconvenio.value = nomeconvenio;
   
}