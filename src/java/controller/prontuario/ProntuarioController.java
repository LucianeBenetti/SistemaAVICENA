package controller.prontuario;

import java.util.ArrayList;
import java.util.List;
import model.bo.prontuario.ProntuarioBO;
import model.vo.prontuario.ProntuarioVO;

public class ProntuarioController {

    ProntuarioBO prontuarioBO = new ProntuarioBO();

    public ArrayList<ProntuarioVO> listarTodosOsProntuariosVO() {
        return prontuarioBO.listarTodosOsProntuariosVO();
    }

    public List<ProntuarioVO> listarProntuarioPorPaciente(int codigoPaciente) {
        return prontuarioBO.listarProntuariosPorPaciente(codigoPaciente);
    }

    public int cadastrarProntuarioVO(ProntuarioVO prontuarioVO) {
        return prontuarioBO.cadastrarProntuario(prontuarioVO);
    }

    public boolean atualizarProntuarioVO(ProntuarioVO prontuarioVO, int codigoProntuario) {
        return prontuarioBO.atualizarProntuario(prontuarioVO, codigoProntuario);
    }

    public boolean excluirProntuarioPorId(int codigoProntuario) {
        return prontuarioBO.excluirProntuarioPorId(codigoProntuario);
    }

}
