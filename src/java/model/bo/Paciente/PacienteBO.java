package model.bo.Paciente;

import java.util.ArrayList;
import model.dao.Paciente.PacienteDAO;
import model.vo.Paciente.PacienteVO;

public class PacienteBO {

    PacienteDAO pacienteDAO = new PacienteDAO();

    public int cadastrarPacienteVO(PacienteVO pacienteVO) {

        int novoId;

        if (pacienteDAO.pesquisarPacienteVOPorCpf(pacienteVO.getCpfPaciente()) != null) {

            novoId = 0;
        } else {
            novoId = pacienteDAO.inserir(pacienteVO);
        }

        return novoId;
    }

    public ArrayList<PacienteVO> ListarTodosOsPacientesVO() {

        return pacienteDAO.listarTodosOsPacientesVO();
    }

    public PacienteVO pesquisarPacienteVOPorCpf(String cpfPaciente) {

        return pacienteDAO.pesquisarPacienteVOPorCpf(cpfPaciente);
    }

    public boolean atualizarPacienteVO(PacienteVO pacienteVO) {
        boolean atualizacao = false;

        if (pacienteDAO.atualizarPacienteVO(pacienteVO)) {

            atualizacao = true;
        }

        return atualizacao;
    }

    public boolean excluirPacientePorCpf(String cpfPaciente) {
        return pacienteDAO.excluir(cpfPaciente);
    }

}
