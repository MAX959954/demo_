package com.example.demo.controller.registration;

import com.example.demo.domain.model.AppUser;
import com.example.demo.service.AppUserService;
import com.example.demo.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    private final AppUserService appUserService;
    private final EmailService emailService;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public RegistrationController(AppUserService appUserService, EmailService emailService) {
        this.appUserService = appUserService;
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody AppUser appUser) {
        if (!EMAIL_PATTERN.matcher(appUser.getEmail()).matches()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email address format");
        }

        try {
            String token = appUserService.signUpUser(appUser);
            String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;
            emailService.send(appUser.getEmail(), buildEmail(appUser.getFullName(), link));
            return ResponseEntity.ok(token);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration successful, but email failed: " + e.getMessage());
        }
    }

    private String buildEmail(String name, String link) {
        return "<h1>Confirm your email</h1><p>Click <a href=\"" + link + "\">here</a> to confirm.</p>";
    }
}