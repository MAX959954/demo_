package com.example.demo.config.security;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private String password;

    public LoginRequest(){

    }

}
