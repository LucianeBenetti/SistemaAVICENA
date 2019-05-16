package Servlets.Paciente;

import controller.Paciente.PacienteController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Paciente.PacienteVO;

public class AtualizarPaciente extends HttpServlet {

PacienteVO pacienteVO = new PacienteVO();
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        
        pacienteVO.setNomePaciente(request.getParameter("nomepaciente"));
        pacienteVO.setCelMensagemPaciente(request.getParameter("celularpaciente"));
        pacienteVO.setFoneResidencial(request.getParameter("foneresidencial")); 
        pacienteVO.setFoneComercial(request.getParameter("fonecomercial"));
        pacienteVO.setEmailPaciente(request.getParameter("email"));
        pacienteVO.setCpfPaciente(request.getParameter("cpfpaciente"));
        pacienteVO.setCnpjPaciente(request.getParameter("cnpjpaciente"));
        pacienteVO.setLogradouro(request.getParameter("logradouro"));
        pacienteVO.setNumLogradouro(request.getParameter("numlogradouro"));
        pacienteVO.setComplemento(request.getParameter("complemento"));
        pacienteVO.setBairro(request.getParameter("bairro")); 
        pacienteVO.setCidade(request.getParameter("cidade"));
        pacienteVO.setCep(request.getParameter("uf"));
        pacienteVO.setUf(request.getParameter("cep"));
                                      
        PacienteController pacientecontroller = new PacienteController();
        boolean atualizado = pacientecontroller.atualizarPacienteVO(pacienteVO);
        Boolean resultadoDaAtualizacao = false;
            
            if(atualizado){                
                resultadoDaAtualizacao = true;
                request.setAttribute("atualizacao", resultadoDaAtualizacao);
                request.getRequestDispatcher("Paciente/ResultadoDaAtualizacao.jsp").forward(request, response);
            }else { 
                request.setAttribute("atualizacao", resultadoDaAtualizacao);}             
                request.getRequestDispatcher("Paciente/ResultadoDaAtualizacao.jsp").forward(request, response);
           
    }      
}
