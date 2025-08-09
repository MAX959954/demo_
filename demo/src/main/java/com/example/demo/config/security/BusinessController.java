package com.example.demo.config.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/connect-business")
public class BusinessController {
    @GetMapping("/status")
    @PreAuthorize("isAuthenticated()")
    public String getBusinessStatus(){
        return  "Business connection status : Pending";
    }
}
