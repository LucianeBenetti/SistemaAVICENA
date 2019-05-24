
package model.bo.Consulta;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.dao.Consulta.ConsultaDAO;
import model.vo.Consulta.ConsultaVO;


public class ConsultaBO { 
    
   ConsultaDAO dao = new ConsultaDAO();

	public boolean inserir(ConsultaVO consulta) {

		Calendar c = Calendar.getInstance();
		c.setTime(consulta.getDataConsulta());
		Date dataSQL = new Date(c.getTimeInMillis());
		if (dao.consultarDataHorario(dataSQL, consulta.getHorarioConsulta()) == null) {

			JOptionPane.showMessageDialog(null, "Consulta j� cadastrada! Tente novamente.");
			
		} else {
			int idGerado = dao.inserirConsulta(consulta);
			return idGerado > 0;
		}
		return false;
	}

	public ArrayList<ConsultaVO> listarTodasAsConsultasVO() {
		ArrayList<ConsultaVO> consultas = dao.listarTodasAsConsultasVO();
		return consultas;
	}

	public boolean excluirConsulta(ConsultaVO consultaExcluida) {
		boolean sucesso = dao.delete(consultaExcluida.getCodigoConsulta());
		return sucesso;

	}

	public boolean atualizarConsulta(ConsultaVO consulta, int codigoConsulta) {

		return dao.atualizar(consulta, codigoConsulta);
	}

	public ConsultaVO consultarDataHorario(Date dataSQL, String horarioConsulta) {
		// TODO Auto-generated method stub
		return dao.consultarDataHorario(dataSQL, horarioConsulta);
	}

}