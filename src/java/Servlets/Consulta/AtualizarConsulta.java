package Servlets.Consulta;

import controller.Consulta.ConsultaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Consulta.ConsultaVO;
import model.vo.Convenio.ConvenioVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Paciente.PacienteVO;

public class AtualizarConsulta extends HttpServlet {

    ConsultaVO consultaVO;
    ConsultaController consultaController;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        ConvenioVO convenioVO = new ConvenioVO();
        PacienteVO pacienteVO = new PacienteVO();

        String nomeMedico = request.getParameter("nomemedico");
        String nomeEspecialidade = request.getParameter("nomeespecialidade");
        String nomeConvenio = request.getParameter("nomeconvenio");
        String nomepaciente = request.getParameter("nomepaciente");
        int codigoConsulta = new Integer(request.getParameter("codigoconsulta"));
        int codigoConvenio = new Integer(request.getParameter("codigoconvenio"));
        int codigoPaciente = new Integer(request.getParameter("codigopaciente"));
        int codigoEspecializacao = new Integer(request.getParameter("codigoespecializacao"));
        especializacaoVO.setCodigoEspecializacao(codigoEspecializacao);
        convenioVO.setCodigoConvenio(codigoConvenio);
        pacienteVO.setCodigoPaciente(codigoPaciente);

        String dataConsulta = request.getParameter("dataconsulta");
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(formatter.parse(dataConsulta));
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date dataSQL = new Date(c.getTimeInMillis());
        consultaVO = new ConsultaVO();
        consultaVO.setCodigoConsulta(codigoConsulta);
        consultaVO.setAtencaoEspecial(request.getParameter("atencaoespecial"));
        consultaVO.setConvenioVO(convenioVO);
        consultaVO.setDataConsulta(dataSQL);
        consultaVO.setEspecializacaoVO(especializacaoVO);
        consultaVO.setHorarioConsulta(request.getParameter("horarioconsulta"));
        consultaVO.setPacienteVO(pacienteVO);

        consultaController = new ConsultaController();

        boolean atualizada = consultaController.atualizarConsultaVO(consultaVO, codigoConsulta);
        Boolean resultadoDaAtualizacao = false;

        if (atualizada) {

            request.setAttribute("nomepaciente", nomepaciente);
            request.setAttribute("horarioconsulta", consultaVO.getHorarioConsulta());
            request.setAttribute("dataconsulta", dataConsulta);
            request.setAttribute("nomemedico", nomeMedico);
            request.setAttribute("nomeespecialidade", nomeEspecialidade);
            request.setAttribute("nomeconvenio", nomeConvenio);
            request.setAttribute("atençãoespecial", consultaVO.getAtencaoEspecial());

            resultadoDaAtualizacao = true;

            if (consultaVO.getAtencaoEspecial() != null) {

                final String username = "clinicaavicena2@gmail.com";
                final String password = "TesteAvicena";

                Properties prop = new Properties();
                prop.put("mail.smtp.host", "smtp.gmail.com");
                prop.put("mail.smtp.port", "587");
                prop.put("mail.smtp.auth", "true");
                prop.put("mail.smtp.starttls.enable", "true"); //TLS

                Session session = Session.getInstance(prop,
                        new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

                try {

                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress("clinicaavicena2@gmail.com"));
                    message.setRecipients(
                            Message.RecipientType.TO,
                            InternetAddress.parse("luciane.benetti@gmail.com")
                    );
                    message.setSubject("Consulta com atendimento especial");
                    message.setText("Clinica Avicena - Atendimento Médico Humanizado!" +"\n\n\n"
                            + "Por gentileza, atentar para a consulta com atendimento"
                            + " especial, que foi alterada para o dia e horário abaixo: " + "\n\n"
                            + "Nome do Paciente: " + nomepaciente + "\n\n"
                            + "Data da Consulta: " + dataConsulta + "\n\n"
                            + "Horário da consulta: " + consultaVO.getHorarioConsulta() + "\n\n"
                            + "Atenção especial: " + consultaVO.getAtencaoEspecial());

                    Transport.send(message);

                    System.out.println("Done");

                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }

            request.setAttribute("consultaatualizada", resultadoDaAtualizacao);
            request.getRequestDispatcher("Consulta/ResultadoDaAtualizacao.jsp").forward(request, response);

        } else {
            request.setAttribute("consultaatualizada", resultadoDaAtualizacao);
            request.getRequestDispatcher("Consulta/ResultadoDaAtualizacao.jsp").forward(request, response);
        }

    }

}
