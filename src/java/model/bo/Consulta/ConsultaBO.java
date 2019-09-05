package model.bo.Consulta;

import Servlets.Consulta.CadastrarConsulta;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.Consulta.ConsultaDAO;
import model.vo.Consulta.ConsultaVO;

public class ConsultaBO {
    
    ConsultaDAO consultaDAO = new ConsultaDAO();
    
    public int cadastrarConsultaVO(ConsultaVO consultaVO) {
        Date data = (Date) consultaVO.getDataConsulta();
        consultaVO.setDataConsulta(data);
        Calendar c = Calendar.getInstance();
        c.setTime(consultaVO.getDataConsulta());
        Date dataSQL = new Date(c.getTimeInMillis());
        java.util.Date hoje = Calendar.getInstance().getTime();
        
        int novoId;
        if (consultaDAO.consultarDataHorario(dataSQL, consultaVO.getHorarioConsulta()) != 0 || dataSQL.before(hoje)) {
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
        
        Date data = (Date) consultaVO.getDataConsulta();
        consultaVO.setDataConsulta(data);
        Calendar c = Calendar.getInstance();
        c.setTime(consultaVO.getDataConsulta());
        Date dataSQL = new Date(c.getTimeInMillis());
        java.util.Date hoje = Calendar.getInstance().getTime();
        
        if (consultaDAO.consultarDataHorario(dataSQL, consultaVO.getHorarioConsulta()) == 0) {
            consultaDAO.atualizarConsulta(consultaVO, codigoConsulta);
            return sucesso = true;
            
        } else {
            return sucesso;
        }
        
    }
    
    public List<ConsultaVO> listarConsultasVOPorID(int codigoPaciente) {
        return consultaDAO.consultarPorPaciente(codigoPaciente);
    }
    
    public List<ConsultaVO> listarConsultasVOPorConvenio(int codigoConvenio) {
        return consultaDAO.listarConsultasVOPorConvenio(codigoConvenio);
    }
    
    public List<ConsultaVO> listarConsultasVOPorMedico(int codigoEspecializacao) {
        return consultaDAO.listarConsultasVOPorMedico(codigoEspecializacao);
    }
    
    public List<ConsultaVO> listarConsultasVOPorData(Date dataSQLInicial, Date dataSQLFinal) {
        return consultaDAO.listarConsultasVOPorData(dataSQLInicial, dataSQLFinal);
    }
    
    public ConsultaVO consultarPorId(int codigoPaciente) {
        return consultaDAO.consultarPorId(codigoPaciente);
    }
    
}
