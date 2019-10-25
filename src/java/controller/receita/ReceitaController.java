package controller.receita;

import java.util.List;
import model.bo.receita.ReceitaBO;
import model.vo.receita.ReceitaVO;

public class ReceitaController {

    ReceitaBO receitaBO = new ReceitaBO();

    public List<ReceitaVO> buscarReceitasPorConsulta(int codigoConsulta) {
        return receitaBO.buscarReceitaPorConsulta(codigoConsulta);
    }

    public int cadastrarReceitaVO(ReceitaVO receitaVO) {
        return receitaBO.cadastrarReceitaVO(receitaVO);
    }

    public boolean atualizarReceitaVO(ReceitaVO receitaVO, int codigoReceita) {
        return receitaBO.atualizarReceitaVO(receitaVO, codigoReceita);
    }

}
