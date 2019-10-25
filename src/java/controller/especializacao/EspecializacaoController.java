package controller.especializacao;

import java.util.ArrayList;
import java.util.List;
import model.bo.especializaco.EspecializacaoBO;
import model.vo.especialidade.EspecialidadeVO;
import model.vo.especializacao.EspecializacaoVO;

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

    public EspecializacaoVO atualizarEspecializacaoVO(EspecializacaoVO especializacao, int codigoEspecializacao) {
        return especializacaoBO.atualizarEspecializacaoVO(especializacao, codigoEspecializacao);
    }

    public ArrayList<EspecializacaoVO> listarTodasAsEspecializacoesVO() {
        return especializacaoBO.listarTodasAsEspecializacoesVO();
    }

    public List<EspecializacaoVO> pesquisarEspecializacaoPorIdDoMedico(int codigoMedico) {
        return especializacaoBO.pesquisarEspecializacaoPorIdDoMedico(codigoMedico);
    }

    public boolean pesquisarEspecializacoesVO(EspecializacaoVO especializacao) {
        return especializacaoBO.pesquisarEspecializacoesVO(especializacao);
    }

}
