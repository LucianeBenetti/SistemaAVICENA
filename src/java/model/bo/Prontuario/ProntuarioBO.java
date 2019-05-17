package model.bo.Prontuario;

import java.util.ArrayList;
import java.util.List;
import model.dao.Prontuario.ProntuarioDAO;
import model.vo.Prontuario.ProntuarioVO;


public class ProntuarioBO {
ProntuarioDAO dao = new ProntuarioDAO();

	public List<ProntuarioVO> listarProntuarios() {

		ArrayList<ProntuarioVO> prontuarios = dao.listarTodos();
		return prontuarios;
	}

	public boolean inserir(ProntuarioVO prontuario) {

		int idGerado = dao.inserir(prontuario);

		return idGerado > 0;

	}

	public boolean excluirProntuario(ProntuarioVO prontuarioExcluido) {

		boolean sucesso = dao.delete(prontuarioExcluido.getCodigoProntuario());
		return sucesso;
	}

	public boolean atualizar(ProntuarioVO prontuario, int codigoProntuario) {
		
		return  dao.atualizar(prontuario, codigoProntuario);
	}

	public List<ProntuarioVO> listarProntuariosDoPaciente(int codigoPaciente) {
		return dao.listarProntuariosDoPaciente(codigoPaciente);
	}
}
