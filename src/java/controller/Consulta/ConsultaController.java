package controller.Consulta;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.bo.Consulta.ConsultaBO;
import model.vo.Consulta.ConsultaVO;
import model.vo.Convenio.ConvenioVO;

public class ConsultaController {

    ConsultaBO consultaBO = new ConsultaBO();

    public int cadastrarConsultaVO(ConsultaVO consultaVO) {
        return consultaBO.cadastrarConsultaVO(consultaVO);
    }

    public ArrayList<ConsultaVO> listarTodasAsConsultasVO() {
        return consultaBO.listarTodasAsConsultasVO();
    }

    public List<ConsultaVO> listarConsultasVOPorID(int codigoPaciente) {
        return consultaBO.listarConsultasVOPorID(codigoPaciente);
    }

    public boolean excluirConsultaPorId(int codigoConsulta) {
        return consultaBO.excluirConsultaPorId(codigoConsulta);
    }

    public boolean atualizarConsultaVO(ConsultaVO consultaVO, int codigoConsulta) {
        return consultaBO.atualizarConsulta(consultaVO, codigoConsulta);
    }

    public List<ConsultaVO> listarConsultasVOPorConvenio(int codigoConvenio) {
        return consultaBO.listarConsultasVOPorConvenio(codigoConvenio);
    }

    public List<ConsultaVO> listarConsultasVOPorMedico(int codigoEspecializacao) {
        return consultaBO.listarConsultasVOPorMedico(codigoEspecializacao);
    }

}
