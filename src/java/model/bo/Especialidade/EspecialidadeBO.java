package model.bo.Especialidade;

import java.util.ArrayList;
import java.util.List;
import model.dao.Especialidade.EspecialidadeDAO;
import model.dao.Especialidade.EspecialidadeDAO;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especialidade.EspecialidadeVO;

public class EspecialidadeBO {

    EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();

    public int cadastrarEspecialidadeVO(EspecialidadeVO especialidadeVO) {

        int novoId;

        if (especialidadeDAO.pesquisarEspecialidadesVO(especialidadeVO) != null) {

            novoId = 0;
        } else {
            novoId = especialidadeDAO.inserirEspecialidadeVO(especialidadeVO);
        }

        return novoId;
    }

    public ArrayList<EspecialidadeVO> ListarTodasEspecialidadesVO() {

        return especialidadeDAO.listarTodasEspecialidades();
    }

    public EspecialidadeVO pesquisarEspecialidadeVOPorId(int IdEspecialidade) {

        return especialidadeDAO.pesquisarEspecialidadeVOPorId(IdEspecialidade);
    }

    public boolean atualizarEspecialidadeVO(EspecialidadeVO especialidadeVO) {
        boolean atualizacao = false;

        if (especialidadeDAO.atualizarEspecialidadeVO(especialidadeVO)) {

            atualizacao = true;
        }

        return atualizacao;
    }

    public boolean excluirEspecialidadePorId(int codigoEspecialidade) {
        return especialidadeDAO.excluirEspecialidadeVO(codigoEspecialidade);
    }

    public EspecialidadeVO pesquisarEspecialidadesVO(EspecialidadeVO especialidadePorNome) {

        return especialidadeDAO.pesquisarEspecialidadesVO(especialidadePorNome);

    }

    public List<EspecialidadeVO> exibirEspecialidadePorNome(String espNome) {
        ArrayList<EspecialidadeVO> especialidades = especialidadeDAO.pesquisarEspecialidadeNome(espNome);
        return especialidades;
    }

}
