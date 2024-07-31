package org.example.buysourcecode.service.impl;


import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;

import org.example.buysourcecode.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${email.api.token}")
    private String emailApiToken;

    @Value("${email.my-name}")
    private String myName;

    @Value("${email.my-gmail}")
    private String myGmail;

    @Override
    public void sendEmail(String yourName, String yourGmail, String emailSubject, String content) {

        Email email = new Email();

        email.setFrom(myName, myGmail);
        email.addRecipient(yourName, yourGmail);

        email.setSubject(emailSubject);

        email.setHtml(content);

        MailerSend ms = new MailerSend();

        ms.setToken(emailApiToken);

        try {

            MailerSendResponse response = ms.emails().send(email);
            System.out.println(response.messageId);
        } catch (MailerSendException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sendWelcomeEmail(String yourName, String yourEmail) {
        try{
        Resource resource = resourceLoader.getResource("classpath:templates/welcome_email_template.html");
        String verifyEmailTemplate = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
            verifyEmailTemplate = verifyEmailTemplate.replace("{your-name}", yourName);
        sendEmail(yourName, yourEmail, "WELCOME TO SOURCEUIT.TECH", verifyEmailTemplate);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
