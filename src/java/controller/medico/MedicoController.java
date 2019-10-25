package controller.medico;

import java.util.ArrayList;
import model.bo.medico.MedicoBO;
import model.vo.medico.MedicoVO;

public class MedicoController {

    MedicoBO medicoBO = new MedicoBO();

    public int cadastrarMedicoVO(MedicoVO medicoVO) {
        return medicoBO.cadastrarMedicoVO(medicoVO);
    }

    public MedicoVO pesquisarMedicoVOPorCpf(String cpfMedico) {
        return medicoBO.pesquisarMedicoVOPorCpf(cpfMedico);
    }

    public Boolean atualizarMedicoVO(MedicoVO medicoVO) {
        return medicoBO.atualizarMedicoVO(medicoVO);
    }

    public boolean excluirMedicoPorCpf(String cpfMedico) {
        return medicoBO.excluirMedicoPorCpf(cpfMedico);
    }

    public ArrayList<MedicoVO> listarTodosOsMedicosVO() {
        return medicoBO.ListarTodosOsMedicoVO();
    }

}
