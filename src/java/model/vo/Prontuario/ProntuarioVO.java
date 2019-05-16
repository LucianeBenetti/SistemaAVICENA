package model.vo.Prontuario;

import model.vo.Consulta.ConsultaVO;

public class ProntuarioVO {

    private int codigoProntuario;
    private String medicamento;
    private String exame;
    private String registro;
    private ConsultaVO consulta = new ConsultaVO();

    public ProntuarioVO() {
    }

    public ProntuarioVO(int codigoProntuario, String medicamento, String exame, String registro) {
        this.codigoProntuario = codigoProntuario;
        this.medicamento = medicamento;
        this.exame = exame;
        this.registro = registro;
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

    public ConsultaVO getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaVO consulta) {
        this.consulta = consulta;
    }

}
