package controller.Prontuario;
import java.util.ArrayList;
import java.util.List;
import model.bo.Prontuario.ReceitaBO;
import model.dao.Consulta.ConsultaDAO;
import model.vo.Prontuario.ReceitaVO;

public class ReceitaController {

    ReceitaBO receitaBO = new ReceitaBO();
    
    public List<ReceitaVO> buscarReceitasPorConsulta(int codigoConsulta) {
        
       return receitaBO.buscarReceitaPorConsulta(codigoConsulta);
    }

   
    
}
