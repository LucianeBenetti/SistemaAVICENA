package controller.convenio;

import java.util.ArrayList;
import model.bo.convenio.ConvenioBO;
import model.vo.convenio.ConvenioVO;

public class ConvenioController {

    ConvenioBO convenioBO = new ConvenioBO();

    public int cadastrarConvenioVO(ConvenioVO convenioVO) {
        return convenioBO.cadastrarConvenioVO(convenioVO);
    }

    public ArrayList<ConvenioVO> listarTodosOsConveniosVO() {
        return convenioBO.ListarTodosOsConveniosVO();

    }

    public ConvenioVO pesquisarConvenioVOPorCnpj(String cpfConvenio) {
        return convenioBO.pesquisarConvenioVOPorCnpj(cpfConvenio);
    }

    public Boolean atualizarConvenioVO(ConvenioVO convenioVO) {
        return convenioBO.atualizarConvenioVO(convenioVO);
    }

    public boolean excluirConvenioPorCnpj(String cpfConvenio) {
        return convenioBO.excluirConvenioPorCnpj(cpfConvenio);
    }

}
