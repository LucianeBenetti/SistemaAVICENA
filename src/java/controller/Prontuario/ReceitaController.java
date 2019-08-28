package controller.Prontuario;
import java.util.ArrayList;
import java.util.List;
import model.bo.Prontuario.ReceitaBO;
import model.vo.Prontuario.ReceitaVO;

public class ReceitaController {

    ReceitaBO receitaBO = new ReceitaBO();
    
    public List<ReceitaVO> buscarReceitasPorConsulta(int codigoConsulta) {
        
       return receitaBO.buscarReceitaPorConsulta(codigoConsulta);
    }

    public int cadastrarReceitaVO(ReceitaVO receitaVO) {
        return receitaBO.cadastrarReceitaVO (receitaVO);
    }

    public boolean atualizarReceitaVO(ReceitaVO receitaVO, int codigoReceita) {
        return receitaBO.atualizarReceitaVO (receitaVO, codigoReceita);
    }

   
    
}
