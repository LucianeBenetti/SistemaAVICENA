package controller.especialidade;

import java.util.ArrayList;
import java.util.List;
import model.bo.especialidade.EspecialidadeBO;
import model.vo.especialidade.EspecialidadeVO;

public class EspecialidadeController {

    EspecialidadeBO especialidadeBO = new EspecialidadeBO();

    public int cadastrarEspecialidadeVO(EspecialidadeVO especialidadeVO) {
        return especialidadeBO.cadastrarEspecialidadeVO(especialidadeVO);
    }

    public ArrayList<EspecialidadeVO> listarTodasAsEspecialidadesVO() {
        return especialidadeBO.ListarTodasEspecialidadesVO();

    }

    public ArrayList<EspecialidadeVO> pesquisarEspecialidadePorId(int codigoEspecialidade) {
        return especialidadeBO.pesquisarEspecialidadePorId(codigoEspecialidade);
    }

    public Boolean atualizarEspecialidadeVO(EspecialidadeVO especialidadeVO) {
        return especialidadeBO.atualizarEspecialidadeVO(especialidadeVO);
    }

    public boolean excluirEspecialidadePorId(int codigoEspecialidade) {
        return especialidadeBO.excluirEspecialidadePorId(codigoEspecialidade);
    }

    public EspecialidadeVO pesquisarEspecialidadesVO(EspecialidadeVO especialidadePorNome) {
        return especialidadeBO.pesquisarEspecialidadesVO(especialidadePorNome);
    }

    public List<EspecialidadeVO> exibirEspecialidadePorNome(String nome) {
        return especialidadeBO.exibirEspecialidadePorNome(nome);
    }

}
