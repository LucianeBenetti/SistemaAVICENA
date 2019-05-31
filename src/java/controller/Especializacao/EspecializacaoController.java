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
