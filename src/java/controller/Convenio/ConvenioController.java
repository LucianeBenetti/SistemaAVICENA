
package controller.Convenio;

import java.util.ArrayList;
import model.bo.Convenio.ConvenioBO;
import model.vo.Convenio.ConvenioVO;

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