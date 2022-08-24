//package com.example.Project.Service;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//import java.util.Properties;
//
//public class javaMail {
//    @Bean
//    public JavaMailSender getJavaMailSender(){
//        JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
//        emailSender.setHost("smtp.gmail.com");
//        emailSender.setPort(587);
//
//        emailSender.setUsername("98thanhnhu98@gmail.com");
//        emailSender.setPassword("ufiklakxrbobfslm");
//
//        Properties props = emailSender.getJavaMailProperties();
//        props.put("mail.transport.protocol", "smtp");
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.debug", "true");
//        return emailSender;
//    }
//
//}
