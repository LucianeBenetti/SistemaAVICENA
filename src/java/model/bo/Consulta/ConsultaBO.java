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
        if (consultaDAO.consultarDataHorario(consultaVO.getDataConsulta(), consultaVO.getHorarioConsulta()) != 0) {
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

    public boolean excluirConsultaPorId(int codigoConsulta) {
        boolean sucesso = consultaDAO.excluirConsultaPorId(codigoConsulta);
        return sucesso;

    }

    public boolean atualizarConsulta(ConsultaVO consultaVO, int codigoConsulta) {
        boolean sucesso = false;
        if (consultaDAO.consultarDataHorario(consultaVO.getDataConsulta(), consultaVO.getHorarioConsulta()) == 0) {
             consultaDAO.atualizarConsulta(consultaVO, codigoConsulta);
            return sucesso = true;
            
        } else {
           return sucesso;
        }

    }

    public List<ConsultaVO> listarConsultasVOPorID(int codigoPaciente) {
        return consultaDAO.consultarPorPaciente(codigoPaciente);
    }

}
