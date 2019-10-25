package controller.consulta;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.bo.consulta.ConsultaBO;
import model.vo.consulta.ConsultaVO;

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

    public List<ConsultaVO> listarConsultasVOPorData(Date dataSQLInicial, Date dataSQLFinal) {
        return consultaBO.listarConsultasVOPorData(dataSQLInicial, dataSQLFinal);
    }

    public ConsultaVO consultaPorID(int codigoPaciente) {
        return consultaBO.consultarPorId(codigoPaciente);
    }

}
