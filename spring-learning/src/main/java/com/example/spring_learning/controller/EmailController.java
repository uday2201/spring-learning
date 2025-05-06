package com.example.spring_learning.controller;

import com.example.spring_learning.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String message) {
        emailService.sendSimpleEmail(to, subject, message);
        return "Email sent successfully!";
    }

    @GetMapping("/send-html")
    public String sendHtmlEmail(@RequestParam String to, @RequestParam String subject) throws MessagingException {
        String htmlContent = "<h1>Welcome to Spring Boot Email Service</h1><p>This is an HTML email!</p>";
        emailService.sendHtmlEmail(to, subject, htmlContent);
        return "HTML Email sent successfully!";
    }
}
