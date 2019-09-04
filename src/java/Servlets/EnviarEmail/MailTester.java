package Servlets.EnviarEmail;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailTester {
    
  public static void main(String[] args) {
        MailJava mj = new MailJava();
        //configuracoes de envio
        mj.setSmtpHostMail("smtp.gmail.com");
        mj.setSmtpPortMail("587");
        mj.setSmtpAuth("true");
        mj.setSmtpStarttls("true");
        mj.setUserMail("clinicaavicena2@gmail.com");
        mj.setFromNameMail("Clinica AVICENA");
        mj.setPassMail("TesteAvicena");
        mj.setCharsetMail("ISO-8859-1");
        mj.setSubjectMail("JavaMail");
        mj.setBodyMail(htmlMessage());
        mj.setTypeTextMail(MailJava.TYPE_TEXT_HTML);

        //sete quantos destinatarios desejar
        Map<String, String> map = new HashMap<String, String>();
        map.put("luciane.benetti@gmail.com", "email gmail");
        //map.put("destinatario2@msn.com", "email msn");
      //  map.put("destinatario3@ig.com.br", "email ig");

        mj.setToMailsUsers(map);

        //seta quatos anexos desejar
        List<String> files = new ArrayList<String>();
        files.add("D:\\Users\\80130917\\Pictures\\FotoLU.png");
//        files.add("C:\images\hover_next.png");
//        files.add("C:\images\hover_prev.png");

        mj.setFileMails(files);

        try {
            new MailJavaSender().senderMail(mj);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MessagingException e) {

        }
    }

    private static String textMessage() {
        return  "Leia o novo tutorial JavaMail do Programando com Java.n" +
                "Saiba como enviar emails com anexo, em formato texto e html.n" +
                "Envie seu email para mais de um destinatario.";
    }

    private static String htmlMessage() {
        return  "<html> " +
                "<head>" +
                "<title>Email no formato HTML com Javamail!</title> " +
                "</head> " +
                "<body> " +
                "<div style='background-color:orange; width:28%; height:100px;'>" +
                "<ul>  " +
                "<li>Leia o novo tutorial JavaMail do Programando com Java.</li> " +
                "<li>Aprenda como enviar emails com anexos.</li>" +
                " <li>Aprenda como enviar emails em formato texto simples ou html.</li> " +
                "<li>Aprenda como enviar seu email para mais de um destinatario.</li>" +
                "</ul> " +
                "<p>Visite o blog " +
                "<a href='http://mballem.wordpress.com/' target='new'>Programando com Java</a>" +
                "</p>" +
                "</div>" +
                "<div style='background-color:FFFFF; width:28%; height:50px;' align='center'>" +
                "Download do JavaMail<br/>" +
                "<a href='http://www.oracle.com/technetwork/java/javaee/index-138643.html'>" +
                "<img src='http://www.oracleimg.com/admin/images/ocom/hp/oralogo_small.gif'/>" +
                "</a> " +
                "</div>" +
                "</body> " +
                "</html>";
    }
}