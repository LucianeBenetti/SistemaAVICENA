package controller.Especializacao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.bo.Especializaco.EspecializacaoBO;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class EspecializacaoController {

    EspecializacaoBO especializacaoBO = new EspecializacaoBO();

    public int cadastrarEspecializacaoVO(EspecializacaoVO especializacaoVO) {

        return especializacaoBO.cadastrarEspecializacaoVO(especializacaoVO);
    }

    public ArrayList<EspecialidadeVO> consultarEspecialidade(String nomeEspecializacao, String nomeMedico) {

        return null;
    }

    public boolean excluirEspecializacaoPorId(int codigoEspecializacao) {

     return especializacaoBO.excluirEspecializacaoPorId(codigoEspecializacao);

    }

    public EspecializacaoVO atualizar(EspecializacaoVO especializacao, int codigoEspecializacao) {
        EspecializacaoVO especializacaoBuscada = especializacaoBO.atualizar(especializacao, codigoEspecializacao);

        return especializacaoBuscada;

    }

    public ArrayList<EspecializacaoVO> listarEspecializacoesPorMedicoEspecialidade(MedicoVO medico,
            EspecialidadeVO especialidade) {
        return especializacaoBO.listarTodasEspecializacoesPorMedicoEspecialidade(medico, especialidade);
    }

    public ArrayList<EspecializacaoVO> listarTodasAsEspecializacoesVO() {

        return especializacaoBO.listarTodasAsEspecializacoesVO();
    }

    public List<EspecializacaoVO> existeEspecializacaoPorNome(String nomeMedico, String nomeEspecialidade) {
        return especializacaoBO.existeEspecializacaoPorNome(nomeMedico, nomeEspecialidade);

    }

    public boolean pesquisarEspecializacoesVO(EspecializacaoVO especializacao) {

        return especializacaoBO.pesquisarEspecializacoesVO(especializacao);
    }

}
