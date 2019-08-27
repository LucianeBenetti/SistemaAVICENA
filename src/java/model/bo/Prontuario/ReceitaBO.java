package model.bo.Prontuario;

import java.util.ArrayList;
import java.util.List;
import model.dao.Consulta.ConsultaDAO;
import model.dao.Prontuario.ReceitaDAO;
import model.vo.Consulta.ConsultaVO;
import model.vo.Prontuario.ReceitaVO;

public class ReceitaBO {

    ConsultaDAO consultaDAO = new ConsultaDAO();
    ReceitaDAO receitaDAO = new ReceitaDAO();

    public List<ReceitaVO> buscarReceitaPorConsulta(int codigoConsulta) {
        List<ReceitaVO> receitasVO = receitaDAO.buscarReceitasConsultaPaciente(codigoConsulta);
        return receitasVO;
    }

}
