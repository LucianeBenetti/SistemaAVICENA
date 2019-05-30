package model.bo.Especializaco;

import java.util.ArrayList;
import java.util.List;
import model.dao.Especializacao.EspecializacaoDAO;
import model.vo.Especialidade.EspecialidadeVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Medico.MedicoVO;

public class EspecializacaoBO {

    EspecializacaoDAO especializacaoDAO = new EspecializacaoDAO();

    public int cadastrarEspecializacaoVO(EspecializacaoVO especializacaoVO) {
        int novoId;
        if (especializacaoDAO.pesquisarEspecializacoesVO(especializacaoVO) != true) {
            novoId = 0;
        } else {
            novoId = especializacaoDAO.inserirEspecializacaoVO(especializacaoVO);
        }
        
        System.out.println("BO " + novoId);
        return novoId;
    }

    public boolean excluirEspecializacaoPorId(int codigoEspecializacao) {
        return especializacaoDAO.excluirEspecializacaoVO(codigoEspecializacao);
    }

    public EspecializacaoVO atualizar(EspecializacaoVO especializacao, int codigoEspecializacao) {
        EspecializacaoVO especializacaoBuscada = especializacaoDAO.atualizarEspecializacao(especializacao, especializacao.getCodigoEspecializacao());
        return especializacaoBuscada;
    }

    public ArrayList<EspecializacaoVO> listarTodasAsEspecializacoesVO() {
        ArrayList<EspecializacaoVO> especialiacoes = especializacaoDAO.listarTodasAsEspecializacoesVO();
        return especialiacoes;
    }

    public List<EspecializacaoVO> pesquisarEspecializacaoPorIdDoMedico(int codigoMedico) {
        ArrayList<EspecializacaoVO> especializacoes = especializacaoDAO.pesquisarEspecializacaoPorIdDoMedico(codigoMedico);
        return especializacoes;
    }

    public boolean pesquisarEspecializacoesVO(EspecializacaoVO especializacao) {
        return especializacaoDAO.pesquisarEspecializacoesVO(especializacao);
    }
    
}
