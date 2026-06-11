package com.jobportal.controller;

import com.jobportal.dto.RegisterRequest;
import com.jobportal.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public String registerUser(
            @RequestBody RegisterRequest request
    ) {
        return authService.register(request);
    }
}