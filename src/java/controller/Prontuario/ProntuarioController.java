package controller.Prontuario;

import java.util.ArrayList;
import java.util.List;
import model.bo.Prontuario.ProntuarioBO;
import model.vo.Consulta.ConsultaVO;
import model.vo.Prontuario.ProntuarioVO;

public class ProntuarioController {

    ProntuarioBO prontuarioBO = new ProntuarioBO();

    public ArrayList<ProntuarioVO> listarTodosOsProntuariosVO() {

        return prontuarioBO.listarTodosOsProntuariosVO();
    }

    public String salvar(ProntuarioVO prontuario) {

        String validacao = validarProntuario(prontuario);

        if (validacao == "") {

            if (prontuarioBO.inserir(prontuario)) {
                validacao = "Prontuario salvo com sucesso!";
            } else {
                validacao = "Erro ao salvar prontuario!";
            }
        }
        return validacao;
    }

    private String validarProntuario(ProntuarioVO prontuario) {

        String validacao = "";
        if (prontuario.getMedicamento() == null) {
            validacao = "A �rea de medicamentos est� nula!";
        } else {
            if (prontuario.getMedicamento().trim().equals("") || prontuario.getRegistro().trim().equals("")) {
                validacao += " - Medicamentos e Registro s�o obrigat�rios. \n";
            }

        }
        return validacao;
    }

    public void excluirProntuario(ProntuarioVO prontuarioExcluido) {
        prontuarioBO.excluirProntuario(prontuarioExcluido);

    }

    public String atualizarProntuario(ProntuarioVO prontuario, int codigoProntuario) {

        String validacao = validarProntuario(prontuario);
        if (validacao == "") {

            if (prontuarioBO.atualizar(prontuario, codigoProntuario)) {
                validacao = "Prontuario alterado com sucesso!";
            } else {
                validacao = "Erro ao alterar prontuario!";
            }
        }
        return validacao;

    }

    public List<ProntuarioVO> listarTodosOsProntuariosVO(ConsultaVO consultaVO) {
            

        return prontuarioBO.listarProntuariosDoPaciente(consultaVO);
    }

}
