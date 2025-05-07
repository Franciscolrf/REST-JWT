package com.example.jwtlogin.jwt_auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/secure")
    public String secureEndpoint() {
        return " Acceso concedido al recurso protegido.";
    }
}
