package controller.Paciente;

import java.util.ArrayList;
import model.bo.Paciente.PacienteBO;
import model.vo.Paciente.PacienteVO;

public class PacienteController {

    PacienteBO pacienteBO = new PacienteBO();

    public int cadastrarPacienteVO(PacienteVO pacienteVO) {

        return pacienteBO.cadastrarPacienteVO(pacienteVO);
    }

    public ArrayList<PacienteVO> listarTodosOsPacientesVO() {

        return pacienteBO.ListarTodosOsPacientesVO();

    }

    public PacienteVO pesquisarPacienteVOPorCpf(String cpfPaciente) {

        return pacienteBO.pesquisarPacienteVOPorCpf(cpfPaciente);
    }

    public Boolean atualizarPacienteVO(PacienteVO pacienteVO) {

        return pacienteBO.atualizarPacienteVO(pacienteVO);
    }

    public boolean excluirPacientePorCpf(String cpfPaciente) {

        return pacienteBO.excluirPacientePorCpf(cpfPaciente);
    }

}
