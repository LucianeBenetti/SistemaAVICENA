package model.vo.prontuario;

import model.vo.paciente.PacienteVO;

public class ProntuarioVO {

    private int codigoProntuario;
    private String medicamento;
    private String exame;
    private String Procedimento;
    private String registro;
    private PacienteVO pacienteVO = new PacienteVO();

    public ProntuarioVO() {
    }

    public ProntuarioVO(int codigoProntuario, String medicamento, String exame, String Procedimento, String registro) {
        this.codigoProntuario = codigoProntuario;
        this.medicamento = medicamento;
        this.exame = exame;
        this.Procedimento = Procedimento;
        this.registro = registro;
    }

    public String getProcedimento() {
        return Procedimento;
    }

    public void setProcedimento(String Procedimento) {
        this.Procedimento = Procedimento;
    }

   

    public int getCodigoProntuario() {
        return codigoProntuario;
    }

    public void setCodigoProntuario(int codigoProntuario) {
        this.codigoProntuario = codigoProntuario;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public PacienteVO getPacienteVO() {
        return pacienteVO;
    }

    public void setPacienteVO(PacienteVO pacienteVO) {
        this.pacienteVO = pacienteVO;
    }

    @Override
    public String toString() {
        return "ProntuarioVO{" + "codigoProntuario=" + codigoProntuario + ", medicamento=" + medicamento + ", exame=" + exame + ", registro=" + registro + ", pacienteVO=" + pacienteVO + '}';
    }
    
    
}
