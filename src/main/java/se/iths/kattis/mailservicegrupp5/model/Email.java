package se.iths.kattis.mailservicegrupp5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {

    private String recipient;
    private String subject;
    private String message;

}
