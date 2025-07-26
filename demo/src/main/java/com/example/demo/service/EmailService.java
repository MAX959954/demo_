package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.mail.MailException;

@Service
@Slf4j
public class EmailService {

    private final JavaMailSenderImpl mailSender;
    private static final String SENDER = "veselmaks2504@gmail.com"; // Verified SendGrid address

    public EmailService(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void send(String to, String emailContent) {
        if (!StringUtils.hasText(to) || !StringUtils.hasText(emailContent)) {
            log.error("Invalid email parameters: to={}, emailContent={}", to, emailContent);
            throw new IllegalArgumentException("Email 'to' and 'emailContent' must not be empty");
        }

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(SENDER);
            message.setTo(to);
            message.setSubject("Confirm your email");
            message.setText(emailContent);
            mailSender.send(message);
            log.info("Email sent successfully to {}", to);
        } catch (MailException e) {
            log.error("Failed to send email to {}: {}", to, e.getMessage(), e);
            throw new IllegalStateException("Failed to send email to " + to, e);
        }
    }
}