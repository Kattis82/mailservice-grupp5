package se.iths.kattis.mailservicegrupp5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.iths.kattis.mailservicegrupp5.messaging.EmailSender;
import se.iths.kattis.mailservicegrupp5.service.EmailService;

@Configuration
public class EmailConfig {


    // skapa bean för EmailSender
    @Bean
    public EmailSender emailSender() {
        return new EmailSender();
    }

    // skapa bean för EmailService, injicerar EmailSender
    @Bean
    public EmailService emailService(EmailSender emailSender) {
        return new EmailService(emailSender);
    }
}
