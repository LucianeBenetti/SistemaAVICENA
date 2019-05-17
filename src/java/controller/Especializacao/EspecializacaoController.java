
package controller.Especializacao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.bo.Especializaco.EspecializacaoBO;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class EspecializacaoController {
    
EspecializacaoBO bo = new EspecializacaoBO();

	public String salvar(EspecializacaoVO especializacao) {

		String validacao = validarEspecializacao(especializacao);

		if (validacao == "") {

			if (bo.inserir(especializacao)) {
				validacao = "Especializa��o salva com sucesso!";
			} else {
				validacao = "Erro ao salvar especializa��o!";
			}
		}
		return validacao;
	}

	private String validarEspecializacao(EspecializacaoVO especializacao) {

		EspecialidadeVO especialidade = new EspecialidadeVO();
		MedicoVO medico = new MedicoVO();

		String validacao = "";
		if (especializacao.getAnoEspecializacao() == null) {
			validacao = "O ano est� nulo!";
		} else {
			if (especializacao.getAnoEspecializacao().trim().equals("")) {
				validacao += "- O preenchimento de todos os campos � obrigat�rio. Por gentileza, informar os dados corretos! \n";
			} else {
				if (bo.existeEspecializacao(especializacao)) {
					validacao = "Especializa��o j� cadastrada! Tente novamente.";
				}
			}

		}
		return validacao;
	}

	public ArrayList<EspecialidadeVO> consultarEspecialidade(String nomeEspecializacao, String nomeMedico) {

		return null;
	}

	public void excluirEspecializacao(EspecializacaoVO especializacaoExcluida) {

		bo.excluirEspecializacao(especializacaoExcluida);

	}

	public EspecializacaoVO atualizar(EspecializacaoVO especializacao, int codigoEspecializacao) {
		EspecializacaoVO especializacaoBuscada = bo.atualizar(especializacao, codigoEspecializacao);

		return especializacaoBuscada;

	}

	public ArrayList<EspecializacaoVO> listarEspecializacoesPorMedicoEspecialidade(MedicoVO medico,
			EspecialidadeVO especialidade) {
		return bo.listarTodasEspecializacoesPorMedicoEspecialidade(medico, especialidade);
	}

	public ArrayList<EspecializacaoVO> listarTodasEspecializacoes() {

		return bo.listarTodasEspecializacoes();
	}

	public List<EspecializacaoVO> existeCadastro(String nomeMedico, String nomeEspecialidade) {
		return bo.existeEspecializacaoPorNome(nomeMedico, nomeEspecialidade);

	}

	public boolean existeEspecializacao(EspecializacaoVO especializacao) {

		return bo.existeEspecializacao(especializacao);
	}

}

