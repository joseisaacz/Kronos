/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicWeb;

/**
 *
 * @author jose
 */
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class SendEmail {
    private static final String username="webmaster@sanpablo.go.cr";
    private static final String password="Cristal87";
    private static Properties prop;
    private final Session session;
    private final Message message;
    
    public SendEmail(String text, String subject, String recipient) throws Exception{
    prop=new Properties();
    prop.put("mail.smtp.host", "smtp.gmail.com");
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true"); 
    session= Session.getInstance(prop, new javax.mail.Authenticator() {@Override
    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress("joseisaaczj19@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            message.setSubject(subject);
            message.setText(text);

    
    }
    public void send(){
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
