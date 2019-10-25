package model.bo.especializaco;

import java.util.ArrayList;
import java.util.List;
import model.dao.especializacao.EspecializacaoDAO;
import model.vo.especializacao.EspecializacaoVO;

public class EspecializacaoBO {

    EspecializacaoDAO especializacaoDAO = new EspecializacaoDAO();

    public int cadastrarEspecializacaoVO(EspecializacaoVO especializacaoVO) {
        int novoId;
//        if (especializacaoDAO.pesquisarEspecializacoesVO(especializacaoVO) != true) {
//            novoId = 0;
//        } else {
        novoId = especializacaoDAO.inserirEspecializacaoVO(especializacaoVO);
        //  }
        return novoId;
    }

    public boolean excluirEspecializacaoPorId(int codigoEspecializacao) {
        return especializacaoDAO.excluirEspecializacaoVO(codigoEspecializacao);
    }

    public ArrayList<EspecializacaoVO> listarTodasAsEspecializacoesVO() {
        ArrayList<EspecializacaoVO> especialiacoes = especializacaoDAO.listarTodasEspecializacoesVO();
        return especialiacoes;
    }

    public List<EspecializacaoVO> pesquisarEspecializacaoPorIdDoMedico(int codigoMedico) {
        ArrayList<EspecializacaoVO> especializacoes = especializacaoDAO.listarEspecializacoesDoMedicoPorEspecialidade(codigoMedico);
        return especializacoes;
    }

    public boolean pesquisarEspecializacoesVO(EspecializacaoVO especializacao) {
        return especializacaoDAO.existeEspecializacaoVO(especializacao);
    }

    public EspecializacaoVO atualizarEspecializacaoVO(EspecializacaoVO especializacao, int codigoEspecializacao) {
        EspecializacaoVO especializacaoAtualizada = especializacaoDAO.atualizarEspecializacaoVO(especializacao, especializacao.getCodigoEspecializacao());

        return especializacaoAtualizada;

    }

}
