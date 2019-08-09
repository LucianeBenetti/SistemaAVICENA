
package controller.Consulta;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.bo.Consulta.ConsultaBO;
import model.vo.Consulta.ConsultaVO;

public class ConsultaController {
    
ConsultaBO consultaBO = new ConsultaBO();

    public int cadastrarConsultaVO(ConsultaVO consultaVO) {
       return consultaBO.cadastrarConsultaVO(consultaVO);    
    }



//	private String validarConsulta(ConsultaVO consulta) {
//		String validacao = "";
//		if (consulta.getDataConsulta() == null) {
//			validacao = "Data est� nula!";
//		} else {
//			if (consulta.getDataConsulta().equals("") || consulta.getHorarioConsulta().equals("")) {
//				validacao += " - Data  e Horario s�o obrigat�rios. \n";
//			} else {
//				// java.sql.Date
//				Calendar c = Calendar.getInstance();
//				c.setTime(consulta.getDataConsulta());
//				Date dataSQL = new Date(c.getTimeInMillis());
//				java.util.Date hoje = Calendar.getInstance().getTime();
//				if (dataSQL.before(hoje)) {
//					validacao = "Data n�o pode ser inferior ou igual a data atual.";
//				}
//			}
//		}
//		return validacao;
//	}

    public ArrayList<ConsultaVO> listarTodasAsConsultasVO() {
        return consultaBO.listarTodasAsConsultasVO();
       }

//	public void excluirConsulta(ConsultaVO consultaExcluida) {
//		bo.excluirConsulta(consultaExcluida);
//
//	}
//
//	public String atualizarConsulta(ConsultaVO consulta, int codigoConsulta) {
//		String validacao = validarConsulta(consulta);
//		if (validacao == "") {
//
//			if (bo.atualizarConsulta(consulta, codigoConsulta)) {
//				validacao = "Consulta salvo com sucesso!";
//			} else {
//				validacao = "Erro ao salvar consulta!";
//			}
//		}
//		return validacao;
//	}

   

}
