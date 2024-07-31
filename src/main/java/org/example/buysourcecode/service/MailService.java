package org.example.buysourcecode.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface MailService {

    void sendEmail(String yourName, String yourEmail, String emailSubject, String content);
    void sendWelcomeEmail(String yourName, String yourEmail);

}
