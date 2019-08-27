package model.dao.Prontuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.ConexaoComBanco;
import model.dao.Consulta.ConsultaDAO;
import model.dao.Especializacao.EspecializacaoDAO;
import model.vo.Consulta.ConsultaVO;
import model.vo.Convenio.ConvenioVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Paciente.PacienteVO;
import model.vo.Prontuario.ReceitaVO;

public class ReceitaDAO {

    private EspecializacaoDAO especializacaoDAO = new EspecializacaoDAO();
    private ConsultaDAO consultaDAO = new ConsultaDAO();

    public List<ReceitaVO> buscarReceitasConsultaPaciente(int codigoConsulta) {

        List<ReceitaVO> listaReceitas = new ArrayList<ReceitaVO>();
        String query = " SELECT * from receita where codigoConsulta = ?";

        Connection conn = ConexaoComBanco.getConnection();
        PreparedStatement prepStmt = ConexaoComBanco.getPreparedStatement(conn, query);
        try {
            prepStmt.setInt(1, codigoConsulta);
            ResultSet result = prepStmt.executeQuery();

            while (result.next()) {
                ReceitaVO receitaVO = new ReceitaVO();
                receitaVO.setCodigoReceita(result.getInt(1));
                ConsultaVO consultaVO = consultaDAO.consultarPorId(codigoConsulta);
                receitaVO.setConsultaVO(consultaVO);
                receitaVO.setMedicamento(result.getString(3));
                receitaVO.setPosologia(result.getString(4));
                receitaVO.setExames(result.getString(5));
                receitaVO.setObservacao(result.getString(6));
                listaReceitas.add(receitaVO);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ConexaoComBanco.closePreparedStatement(prepStmt);
            ConexaoComBanco.closeConnection(conn);
        }
        return listaReceitas;
    }
}
