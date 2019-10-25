package model.bo.convenio;

import java.util.ArrayList;
import model.dao.convenio.ConvenioDAO;
import model.vo.convenio.ConvenioVO;

public class ConvenioBO {

    ConvenioDAO convenioDAO = new ConvenioDAO();

    public int cadastrarConvenioVO(ConvenioVO convenioVO) {

        int novoId;

        if (convenioDAO.pesquisarConvenioVOPorCnpj(convenioVO.getCnpjConvenio()) != null) {

            novoId = 0;
        } else {
            novoId = convenioDAO.inserir(convenioVO);
        }

        return novoId;
    }

    public ArrayList<ConvenioVO> ListarTodosOsConveniosVO() {

        return convenioDAO.listarTodosOsConveniosVO();
    }

    public ConvenioVO pesquisarConvenioVOPorCnpj(String cpfConvenio) {

        return convenioDAO.pesquisarConvenioVOPorCnpj(cpfConvenio);
    }

    public boolean atualizarConvenioVO(ConvenioVO convenioVO) {
        boolean atualizacao = false;

        if (convenioDAO.atualizarConvenioVO(convenioVO)) {

            atualizacao = true;
        }

        return atualizacao;
    }

    public boolean excluirConvenioPorCnpj(String cpfConvenio) {
        return convenioDAO.excluir(cpfConvenio);
    }

}
