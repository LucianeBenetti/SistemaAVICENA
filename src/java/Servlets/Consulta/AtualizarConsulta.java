package Servlets.Consulta;

import controller.Consulta.ConsultaController;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Consulta.ConsultaVO;
import model.vo.Convenio.ConvenioVO;
import model.vo.Especializacao.EspecializacaoVO;
import model.vo.Paciente.PacienteVO;

public class AtualizarConsulta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ConsultaVO consultaVO;
        ConsultaController consultaController;
        Object usuarioValidado = request.getSession().getAttribute("perfil");
        EspecializacaoVO especializacaoVO = new EspecializacaoVO();
        ConvenioVO convenioVO = new ConvenioVO();
        PacienteVO pacienteVO = new PacienteVO();

        String nomeMedico = request.getParameter("nomemedico");
        String nomeEspecialidade = request.getParameter("nomeespecialidade");
        String nomeConvenio = request.getParameter("nomeconvenio");
        String nomepaciente = request.getParameter("nomepaciente");
        String horarioConsulta = request.getParameter("horarioconsulta");
        int codigoConsulta = new Integer(request.getParameter("codigoconsulta"));
        int codigoConvenio = new Integer(request.getParameter("codigoconvenio"));
        int codigoPaciente = new Integer(request.getParameter("codigopaciente"));
        int codigoEspecializacao = new Integer(request.getParameter("codigoespecializacao"));
        especializacaoVO.setCodigoEspecializacao(codigoEspecializacao);
        convenioVO.setCodigoConvenio(codigoConvenio);
        pacienteVO.setCodigoPaciente(codigoPaciente);
        String atencaoEspecial = request.getParameter("atencaoespecial");

        String dataConsulta = request.getParameter("dataconsulta");
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(formatter.parse(dataConsulta));
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date dataSQL = new Date(c.getTimeInMillis());
        java.util.Date hoje = Calendar.getInstance().getTime();

        consultaVO = new ConsultaVO();
        consultaVO.setCodigoConsulta(codigoConsulta);
        consultaVO.setConvenioVO(convenioVO);
        consultaVO.setAtencaoEspecial(atencaoEspecial);
        consultaVO.setDataConsulta(dataSQL);
        consultaVO.setEspecializacaoVO(especializacaoVO);
        consultaVO.setHorarioConsulta(horarioConsulta);
        consultaVO.setPacienteVO(pacienteVO);
        consultaVO.setValorConsulta(request.getParameter("valorconsulta"));

        consultaController = new ConsultaController();
        Boolean resultadoDaAtualizacao = false;
        boolean atualizada = false;

        if (dataSQL.after(hoje)) {
            atualizada = consultaController.atualizarConsultaVO(consultaVO, codigoConsulta);

            if (atualizada) {

                request.setAttribute("nomepaciente", nomepaciente);
                request.setAttribute("horarioconsulta", horarioConsulta);
                request.setAttribute("dataconsulta", dataConsulta);
                request.setAttribute("nomemedico", nomeMedico);
                request.setAttribute("nomeespecialidade", nomeEspecialidade);
                request.setAttribute("nomeconvenio", nomeConvenio);
                request.setAttribute("atencaoespecial", atencaoEspecial);
                request.setAttribute("valorconsulta", consultaVO.getValorConsulta());
                resultadoDaAtualizacao = true;
                request.setAttribute("resultadotransacao", resultadoDaAtualizacao);
                if (usuarioValidado.equals("admin")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
                } else if (usuarioValidado.equals("atendente")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("resultadotransacao", resultadoDaAtualizacao);
                if (usuarioValidado.equals("admin")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
                } else if (usuarioValidado.equals("atendente")) {
                    request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
                }
            }
        }
        if (!atencaoEspecial.equals("null") && atencaoEspecial != null && !atencaoEspecial.isEmpty()) {

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

                message.setFrom(new InternetAddress("clinicaavicena2@gmail.com", "Clinica AVICENA"));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse("luciane.benetti@gmail.com")
                );
                message.setSubject("Consulta com atendimento especial");

                // Cria o objeto que recebe o texto do corpo do email
                MimeBodyPart textPart = new MimeBodyPart();
                textPart.setText("Clinica Avicena - Atendimento Médico Humanizado!" + "\n\n\n"
                        + "Por gentileza, atentar para a consulta com atendimento"
                        + " especial, foi alterada para o dia e horário abaixo: " + "\n\n"
                        + "Nome do Paciente: " + nomepaciente + "\n\n"
                        + "Data da Consulta: " + dataConsulta + "\n\n"
                        + "Horário da consulta: " + horarioConsulta + "\n\n"
                        + "Atenção especial: " + atencaoEspecial);

                //seta quatos anexos desejar
                List<String> files = new ArrayList<String>();
                files.add("C:\\SENAC\\coracao.png");
//        files.add("C:\images\hover_next.png");
//        files.add("C:\images\hover_prev.png");

                Multipart mps = new MimeMultipart();
                for (int i = 0; i < files.size(); i++) {

                    // Cria um novo objeto para cada arquivo, e anexa o arquivo
                    MimeBodyPart attachFilePart = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(
                            files.get(i)
                    );
                    attachFilePart.setDataHandler(new DataHandler(fds));
                    attachFilePart.setFileName(fds.getName());

                    //adiciona os anexos da mensagem
                    mps.addBodyPart(attachFilePart, i);

                }

                //adiciona o corpo texto da mensagem
                mps.addBodyPart(textPart);
                //adiciona a mensagem o conteudo texto e anexo
                message.setContent(mps);

                Transport.send(message);

                System.out.println("Done");

            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("resultadotransacao", resultadoDaAtualizacao);
        if (usuarioValidado.equals("admin")) {
            request.getRequestDispatcher("WEB-INF/PaginaInicialAdmin.jsp").forward(request, response);
        } else if (usuarioValidado.equals("atendente")) {
            request.getRequestDispatcher("WEB-INF/PaginaInicialAtendente.jsp").forward(request, response);
        }
    }

}
