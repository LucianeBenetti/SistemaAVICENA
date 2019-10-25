package model.vo.especializacao;

import model.vo.especialidade.EspecialidadeVO;
import model.vo.medico.MedicoVO;

public class EspecializacaoVO {

    private int codigoEspecializacao;
    private EspecialidadeVO especialidadeVO;
    private MedicoVO medicoVO;
    private int anoEspecializacao;

    public EspecializacaoVO() {
    }

    public EspecializacaoVO(int codigoEspecializacao, EspecialidadeVO especialidadeVO, MedicoVO medicoVO, int anoEspecializacao) {
        this.codigoEspecializacao = codigoEspecializacao;
        this.especialidadeVO = especialidadeVO;
        this.medicoVO = medicoVO;
        this.anoEspecializacao = anoEspecializacao;
    }

    public int getCodigoEspecializacao() {
        return codigoEspecializacao;
    }

    public void setCodigoEspecializacao(int codigoEspecializacao) {
        this.codigoEspecializacao = codigoEspecializacao;
    }

    public EspecialidadeVO getEspecialidadeVO() {
        return especialidadeVO;
    }

    public void setEspecialidadeVO(EspecialidadeVO especialidadeVO) {
        this.especialidadeVO = especialidadeVO;
    }

    public MedicoVO getMedicoVO() {
        return medicoVO;
    }

    public void setMedicoVO(MedicoVO medicoVO) {
        this.medicoVO = medicoVO;
    }

    public int getAnoEspecializacao() {
        return anoEspecializacao;
    }

    public void setAnoEspecializacao(int anoEspecializacao) {
        this.anoEspecializacao = anoEspecializacao;
    }

    @Override
    public String toString() {
        return "EspecializacaoVO{" + "codigoEspecializacao=" + codigoEspecializacao + ", especialidadeVO=" + especialidadeVO + ", medicoVO=" + medicoVO + ", anoEspecializacao=" + anoEspecializacao + '}';
    }
    

}
