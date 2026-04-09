package se.iths.kattis.mailservicegrupp5.messaging;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import se.iths.kattis.mailservicegrupp5.model.Email;

import java.util.Properties;


public class EmailSender {

    private static final String FROM = System.getenv("MAIL_USERNAME");
    private static final String APP_PASSWORD = System.getenv("MAIL_APP_PASSWORD");


    public void send(Email email) {

        // inställningar specifika för gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, APP_PASSWORD);
            }
        });
        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(FROM));
            mimeMessage.setRecipient(jakarta.mail.Message.RecipientType.TO,
                    new InternetAddress(email.getRecipient()));
            mimeMessage.setSubject(email.getSubject());
            mimeMessage.setText(email.getMessage());
            Transport.send(mimeMessage);

            System.out.println("Mail sent");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
