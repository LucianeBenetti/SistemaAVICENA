package model.bo.Prontuario;

import java.util.ArrayList;
import java.util.List;
import model.dao.Prontuario.ProntuarioDAO;
import model.vo.Consulta.ConsultaVO;
import model.vo.Prontuario.ProntuarioVO;


public class ProntuarioBO {
ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

	public ArrayList<ProntuarioVO> listarTodosOsProntuariosVO() {

		ArrayList<ProntuarioVO> prontuarios = prontuarioDAO.listarTodosOsProntuariosVO();
		return prontuarios;
	}

	public boolean inserir(ProntuarioVO prontuario) {

		int idGerado = prontuarioDAO.inserir(prontuario);

		return idGerado > 0;

	}

	public boolean excluirProntuario(ProntuarioVO prontuarioExcluido) {

		boolean sucesso = prontuarioDAO.delete(prontuarioExcluido.getCodigoProntuario());
		return sucesso;
	}

	public boolean atualizar(ProntuarioVO prontuario, int codigoProntuario) {
		
		return  prontuarioDAO.atualizar(prontuario, codigoProntuario);
	}

	public List<ProntuarioVO> listarProntuariosDoPaciente(ConsultaVO consultaVO) {
            List<ProntuarioVO> prontuarios = new ArrayList<>();
		if(consultaVO != null && consultaVO.getPacienteVO() != null) {
			prontuarios = prontuarioDAO.listarProntuariosDoPaciente(consultaVO.getPacienteVO().getCodigoPaciente());
		}
           
		return prontuarios;
	}
}
