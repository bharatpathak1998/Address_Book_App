package com.example.addressbookapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(String toEmail, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bharatpathak099@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
    }
}