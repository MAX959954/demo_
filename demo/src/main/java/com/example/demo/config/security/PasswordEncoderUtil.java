package com.example.demo.config.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    public static BCryptPasswordEncoder createEncoder() {
        return new BCryptPasswordEncoder();
    }
}