package model.bo.receita;

import java.util.List;
import model.dao.consulta.ConsultaDAO;
import model.dao.receita.ReceitaDAO;
import model.vo.receita.ReceitaVO;

public class ReceitaBO {

    ConsultaDAO consultaDAO = new ConsultaDAO();
    ReceitaDAO receitaDAO = new ReceitaDAO();

    public List<ReceitaVO> buscarReceitaPorConsulta(int codigoConsulta) {
        List<ReceitaVO> receitasVO = receitaDAO.buscarReceitasConsultaPaciente(codigoConsulta);
        return receitasVO;
    }

    public int cadastrarReceitaVO(ReceitaVO receitaVO) {
        int novoId;
        novoId = receitaDAO.cadastrarReceitaVO(receitaVO);
        return novoId;
    }

    public boolean atualizarReceitaVO(ReceitaVO receitaVO, int codigoReceita) {
        boolean atualizacao = false;

        if (receitaDAO.atualizarReceitaVO(receitaVO, codigoReceita)) {

            atualizacao = true;
        }

        return atualizacao;
    }
}
