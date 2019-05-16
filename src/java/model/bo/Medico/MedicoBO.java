package model.bo.Medico;

import java.util.ArrayList;
import model.dao.Medico.MedicoDAO;
import model.vo.Medico.MedicoVO;

public class MedicoBO {

    MedicoDAO medicoDAO = new MedicoDAO();
    
    public ArrayList<MedicoVO> ListarTodosOsMedicoVO() {
        
         return medicoDAO.listarTodosOsMedicos();
    }

    public int cadastrarMedicoVO(MedicoVO medicoVO) {

        int novoId;

        if (medicoDAO.pesquisarMedicoVOPorCpf(medicoVO.getCpfMedico()) != null) {

            novoId = 0;
        } else {
            novoId = medicoDAO.inserir(medicoVO);
        }

        return novoId;
    }

     public MedicoVO pesquisarMedicoVOPorCpf(String cpfMedico) {

        return medicoDAO.pesquisarMedicoVOPorCpf(cpfMedico);
    }

    public boolean atualizarMedicoVO(MedicoVO medicoVO) {
        boolean atualizacao = false;

        if (medicoDAO.atualizarMedicoVO(medicoVO)) {

            atualizacao = true;
        }

        return atualizacao;
    }

    public boolean excluirMedicoPorCpf(String cpfMedico) {
        return medicoDAO.excluir(cpfMedico);
    }

}
