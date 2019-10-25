package model.bo.prontuario;

import java.util.ArrayList;
import java.util.List;
import model.dao.prontuario.ProntuarioDAO;
import model.vo.prontuario.ProntuarioVO;

public class ProntuarioBO {

    ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

    public ArrayList<ProntuarioVO> listarTodosOsProntuariosVO() {

        ArrayList<ProntuarioVO> prontuarios = prontuarioDAO.listarTodosOsProntuariosVO();
        return prontuarios;
    }

    public List<ProntuarioVO> listarProntuariosPorPaciente(int codigoPaciente) {
        return prontuarioDAO.consultarProntuarioVOPorId(codigoPaciente);
    }

    public int cadastrarProntuario(ProntuarioVO prontuarioVO) {
        int novoId;
        novoId = prontuarioDAO.cadastrarProntuario(prontuarioVO);
        return novoId;
    }

    public boolean atualizarProntuario(ProntuarioVO prontuarioVO, int codigoProntuario) {
        boolean atualizacao = false;

        if (prontuarioDAO.atualizarProntuarioVO(prontuarioVO, codigoProntuario)) {

            atualizacao = true;
        }

        return atualizacao;
    }

    public boolean excluirProntuarioPorId(int codigoProntuario) {
        boolean sucesso = prontuarioDAO.excluirProntuarioPorId(codigoProntuario);
        return sucesso;
    }
}
