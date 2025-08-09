package com.example.demo.config.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personal-office")
public class PersonalOfficeController {
    @GetMapping("/dashboard")
    @PreAuthorize("isAuthenticated()")
    public String getDashboard(){
        return "Welcome to your personal office!";
    }
}

