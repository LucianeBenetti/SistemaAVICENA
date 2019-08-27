package model.vo.Prontuario;

import model.vo.Consulta.ConsultaVO;
import model.vo.Especializacao.EspecializacaoVO;

public class ReceitaVO {

    private int codigoReceita;
     private ConsultaVO consultaVO;
    private String medicamento;
    private String posologia;
    private String exames;
    private String observacao;

    public ReceitaVO(int codigoReceita, ConsultaVO consultaVO, String medicamento, String posologia, String exames, String observacao) {
        this.codigoReceita = codigoReceita;
        this.consultaVO = consultaVO;
        this.medicamento = medicamento;
        this.posologia = posologia;
        this.exames = exames;
        this.observacao = observacao;
    }

    public ReceitaVO() {
    }

    public int getCodigoReceita() {
        return codigoReceita;
    }

    public void setCodigoReceita(int codigoReceita) {
        this.codigoReceita = codigoReceita;
    }

    public ConsultaVO getConsultaVO() {
        return consultaVO;
    }

    public void setConsultaVO(ConsultaVO consultaVO) {
        this.consultaVO = consultaVO;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public String getExames() {
        return exames;
    }

    public void setExames(String exames) {
        this.exames = exames;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "ReceitaVO{" + "codigoReceita=" + codigoReceita + ", consultaVO=" + consultaVO + ", medicamento=" + medicamento + ", posologia=" + posologia + ", exames=" + exames + ", observacao=" + observacao + '}';
    }

}
