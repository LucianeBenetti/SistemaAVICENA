package model.bo.Receita;

import java.util.ArrayList;
import java.util.List;
import model.dao.Consulta.ConsultaDAO;
import model.dao.Receita.ReceitaDAO;
import model.vo.Consulta.ConsultaVO;
import model.vo.Receita.ReceitaVO;

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
