package com.example.Project.Controller;

import com.example.Project.Service.EmailService;
import com.example.Project.dto.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailRestController {
    @Autowired
    EmailService emailSenderServiceIML;

    public EmailRestController(EmailService emailSenderServiceIML) {
        this.emailSenderServiceIML = emailSenderServiceIML;
    }

    @PostMapping("/send-email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage){
        this.emailSenderServiceIML.sendSimpleMessage(emailMessage.getTo(),emailMessage.getSubject(),emailMessage.getMessage());
        return ResponseEntity.ok("Success");
    }
}
