package se.iths.kattis.mailservicegrupp5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.iths.kattis.mailservicegrupp5.messaging.EmailSender;
import se.iths.kattis.mailservicegrupp5.service.EmailService;

@Configuration
public class EmailConfig {

    // Skapa bean för EmailSender
    @Bean
    public EmailSender emailSender() {
        return new EmailSender(); // använder default-konstruktorn
    }

    // Skapa bean för EmailService och injicera EmailSender
    @Bean
    public EmailService emailService(EmailSender emailSender) {
        return new EmailService(emailSender);
    }
}
