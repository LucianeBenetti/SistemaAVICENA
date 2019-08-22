package controller.Prontuario;

import java.util.ArrayList;
import java.util.List;
import model.bo.Prontuario.ProntuarioBO;
import model.vo.Consulta.ConsultaVO;
import model.vo.Paciente.PacienteVO;
import model.vo.Prontuario.ProntuarioVO;

public class ProntuarioController {
    
    ProntuarioBO prontuarioBO = new ProntuarioBO();
    
    public ArrayList<ProntuarioVO> listarTodosOsProntuariosVO() {
        
        return prontuarioBO.listarTodosOsProntuariosVO();
    }
    
    public void excluirProntuario(ProntuarioVO prontuarioExcluido) {
        prontuarioBO.excluirProntuario(prontuarioExcluido);
        
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
    
}
