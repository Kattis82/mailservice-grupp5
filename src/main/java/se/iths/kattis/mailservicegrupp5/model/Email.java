package se.iths.kattis.mailservicegrupp5.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {

    private String recipient;
    private String subject;
    private String message;

}
