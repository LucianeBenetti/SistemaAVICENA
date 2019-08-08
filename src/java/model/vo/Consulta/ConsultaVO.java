package model.vo.Consulta;

import java.util.Date;
import model.vo.Convenio.ConvenioVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Paciente.PacienteVO;

public class ConsultaVO {

    private int codigoConsulta;
    private EspecializacaoVO especializacaoVO;
    private PacienteVO pacienteVO;
    private ConvenioVO convenioVO;
    private Date dataConsulta;
    private String horarioConsulta;
    private String atencaoEspecial;

    public ConsultaVO() {
    }

    public ConsultaVO(int codigoConsulta, EspecializacaoVO especializacaoVO, PacienteVO pacienteVO, ConvenioVO convenioVO, Date dataConsulta, String horarioConsulta, String atencaoEspecial) {
        this.codigoConsulta = codigoConsulta;
        this.especializacaoVO = especializacaoVO;
        this.pacienteVO = pacienteVO;
        this.convenioVO = convenioVO;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.atencaoEspecial = atencaoEspecial;
    }

    public int getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(int codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public EspecializacaoVO getEspecializacaoVO() {
        return especializacaoVO;
    }

    public void setEspecializacaoVO(EspecializacaoVO especializacaoVO) {
        this.especializacaoVO = especializacaoVO;
    }

    public PacienteVO getPacienteVO() {
        return pacienteVO;
    }

    public void setPacienteVO(PacienteVO pacienteVO) {
        this.pacienteVO = pacienteVO;
    }

    public ConvenioVO getConvenioVO() {
        return convenioVO;
    }

    public void setConvenioVO(ConvenioVO convenioVO) {
        this.convenioVO = convenioVO;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public String getAtencaoEspecial() {
        return atencaoEspecial;
    }

    public void setAtencaoEspecial(String atencaoEspecial) {
        this.atencaoEspecial = atencaoEspecial;
    }

    @Override
    public String toString() {
        return "ConsultaVO{" + "codigoConsulta=" + codigoConsulta + ", especializacaoVO=" + especializacaoVO + ", pacienteVO=" + pacienteVO + ", convenioVO=" + convenioVO + ", dataConsulta=" + dataConsulta + ", horarioConsulta=" + horarioConsulta + ", atencaoEspecial=" + atencaoEspecial + '}';
    }

    
}
