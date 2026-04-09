package se.iths.kattis.mailservicegrupp5.service;

import se.iths.kattis.mailservicegrupp5.messaging.EmailSender;
import se.iths.kattis.mailservicegrupp5.model.Email;


public class EmailService {

    private final EmailSender emailSender;

    public EmailService(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void send(Email email) {
        emailSender.send(email);
    }
}
