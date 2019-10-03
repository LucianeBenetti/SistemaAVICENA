package model.vo.Receita;

import model.vo.Consulta.ConsultaVO;
import model.vo.Especializacao.EspecializacaoVO;

public class ReceitaVO {

    private int codigoReceita;
    private ConsultaVO consultaVO;
    private String medicamento;
    private String exame;
    private String observacao;

    public ReceitaVO(int codigoReceita, ConsultaVO consultaVO, String medicamento, String exame, String observacao) {
        this.codigoReceita = codigoReceita;
        this.consultaVO = consultaVO;
        this.medicamento = medicamento;
        this.exame = exame;
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

  
    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "ReceitaVO{" + "codigoReceita=" + codigoReceita + ", consultaVO=" + consultaVO + ", medicamento=" + medicamento + ", exame=" + exame + ", observacao=" + observacao + '}';
    }

}
