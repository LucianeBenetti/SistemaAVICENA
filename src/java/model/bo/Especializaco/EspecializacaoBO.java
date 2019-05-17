
package model.bo.Especializaco;

import java.util.ArrayList;
import java.util.List;
import model.dao.Especializacao.EspecializacaoDAO;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class EspecializacaoBO {
    
EspecializacaoDAO dao = new EspecializacaoDAO();

	public boolean inserir(EspecializacaoVO especializacao) {

			int idGerado = dao.inserirEspecializacao(especializacao);
			return idGerado > 0;
		}

	public boolean excluirEspecializacao(EspecializacaoVO especializacao) {
		boolean sucesso = dao.delete(especializacao.getCodigoEspecializacao());
		return sucesso;
	}

	public EspecializacaoVO atualizar(EspecializacaoVO especializacao, int codigoEspecializacao) {
		EspecializacaoVO especializacaoBuscada = dao.atualizarEspecializacao(especializacao,
				especializacao.getCodigoEspecializacao());

		return especializacaoBuscada;

	}

	public ArrayList<EspecializacaoVO> listarTodasEspecializacoes() {

		ArrayList<EspecializacaoVO> especialiacoes = dao.listarTodasEspecializacoes();
		return especialiacoes;
	}

	public ArrayList<EspecializacaoVO> listarTodasEspecializacoesPorMedicoEspecialidade(MedicoVO medico,EspecialidadeVO especialidade) {
			
		ArrayList<EspecializacaoVO> especializacoes = new ArrayList<EspecializacaoVO>();
		dao.existeEspecializacaoPorNome(medico.getNomeMedico(), especialidade.getNomeEspecialidade()); 
		especializacoes = dao.listarEspecializacoesDoMedicoPorEspecialidade(especialidade.getCodigoEspecialidade(), medico.getCodigoMedico());
		
		return especializacoes;
	}

	public List<EspecializacaoVO> existeEspecializacaoPorNome(String nomeMedico, String nomeEspecialidade) {

		ArrayList<EspecializacaoVO> especializacoes = dao.existeEspecializacaoPorNome(nomeMedico, nomeEspecialidade);
		return especializacoes;
	}

	public boolean existeEspecializacao(EspecializacaoVO especializacao) {
		
		return dao.existeEspecializacao(especializacao);
	}

}
