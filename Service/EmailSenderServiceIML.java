package com.example.Project.Service;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Component
public class EmailSenderServiceIML implements EmailService {

    @Bean
    private JavaMailSender  javaMailSender(){
        return new JavaMailSender() {
            @Override
            public void send(SimpleMailMessage simpleMessage) throws MailException {

            }

            @Override
            public void send(SimpleMailMessage... simpleMessages) throws MailException {

            }

            @Override
            public MimeMessage createMimeMessage() {
                return null;
            }

            @Override
            public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
                return null;
            }

            @Override
            public void send(MimeMessage mimeMessage) throws MailException {

            }

            @Override
            public void send(MimeMessage... mimeMessages) throws MailException {

            }

            @Override
            public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {

            }

            @Override
            public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {

            }
        };
    }

//    public void sendSimpleEmail(String toEmail,String body,String subject){
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("98thanhnhu98@gmail.com");
//        message.setTo(toEmail);
//        message.setText(body);
//        message.setSubject(subject);
//        javaMailSender.send(message);
//        System.out.println("mail Send....");
//    }

    private static final String NOREPLY_ADDRESS = "98thanhnhu98@gmail.com";


    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(NOREPLY_ADDRESS);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            javaMailSender().send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }
}
