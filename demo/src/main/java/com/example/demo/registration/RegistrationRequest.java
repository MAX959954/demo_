package com.example.demo.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString

public class RegistrationRequest {
    private final String full_name;
    @Getter
    private final String email;
    @Getter
    private final String password;

    public String getFullName() {
        return full_name;
    }
}
