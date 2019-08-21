package model.bo.Prontuario;

import java.util.ArrayList;
import java.util.List;
import model.dao.Prontuario.ProntuarioDAO;
import model.vo.Consulta.ConsultaVO;
import model.vo.Paciente.PacienteVO;
import model.vo.Prontuario.ProntuarioVO;

public class ProntuarioBO {

    ProntuarioDAO prontuarioDAO = new ProntuarioDAO();

    public ArrayList<ProntuarioVO> listarTodosOsProntuariosVO() {

        ArrayList<ProntuarioVO> prontuarios = prontuarioDAO.listarTodosOsProntuariosVO();
        return prontuarios;
    }

    public boolean excluirProntuario(ProntuarioVO prontuarioExcluido) {

        boolean sucesso = prontuarioDAO.delete(prontuarioExcluido.getCodigoProntuario());
        return sucesso;
    }

   

    public ProntuarioVO listarProntuariosPorPaciente(PacienteVO pacienteVO) {
        ProntuarioVO prontuarioVO = new ProntuarioVO();

        if (pacienteVO != null) {
            prontuarioVO = prontuarioDAO.listarProntuariosPorPaciente(pacienteVO.getCodigoPaciente());
        }
        return prontuarioVO;
    }

    public int cadastrarProntuario(ProntuarioVO prontuarioVO) {
        int novoId;
     
        if (prontuarioDAO.consultarProntuarioVOPorId(prontuarioVO.getPacienteVO().getCodigoPaciente()) == null) {
          return novoId=0;
        } else {
            novoId = prontuarioDAO.cadastrarProntuario(prontuarioVO);
        }

        return novoId;
    }

}
