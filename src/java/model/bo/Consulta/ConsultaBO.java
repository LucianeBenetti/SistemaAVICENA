
package model.bo.Consulta;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.dao.Consulta.ConsultaDAO;
import model.vo.Consulta.ConsultaVO;


public class ConsultaBO { 
    
   ConsultaDAO consultaDAO = new ConsultaDAO();
   
    public int cadastrarConsultaVO(ConsultaVO consultaVO) {
        int novoId; 
            if (consultaDAO.consultarDataHorario(consultaVO.getDataConsulta(), consultaVO.getHorarioConsulta()) == null) {
                novoId = 0;
            } else {
                novoId = consultaDAO.cadastrarConsulta(consultaVO);
            }
		return novoId;
	}

	public ArrayList<ConsultaVO> listarTodasAsConsultasVO() {
		ArrayList<ConsultaVO> consultas = consultaDAO.listarTodasAsConsultasVO();
		return consultas;
	}

	public boolean excluirConsulta(ConsultaVO consultaExcluida) {
		boolean sucesso = consultaDAO.delete(consultaExcluida.getCodigoConsulta());
		return sucesso;

	}

	public boolean atualizarConsulta(ConsultaVO consulta, int codigoConsulta) {

		return consultaDAO.atualizar(consulta, codigoConsulta);
	}

	public ConsultaVO consultarDataHorario(String data, String horarioConsulta) {
		// TODO Auto-generated method stub
		return consultaDAO.consultarDataHorario(data, horarioConsulta);
	}

    public List<ConsultaVO> listarConsultasVOPorID(int codigoPaciente) {
        return consultaDAO.consultarPorPaciente(codigoPaciente);
    }

     

}