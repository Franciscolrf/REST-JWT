package com.example.jwtlogin.jwt_auth.controller;

import com.example.jwtlogin.jwt_auth.model.AuthRequest;
import com.example.jwtlogin.jwt_auth.security.JwtUtil;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Usuario simulado en memoria
    private final String hardcodedUsername = "admin";
    private final String hardcodedPasswordHash = passwordEncoder.encode("1234"); // Hash de "1234"

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        if (request.getUsername().equals(hardcodedUsername) &&
            passwordEncoder.matches(request.getPassword(), hardcodedPasswordHash)) {

            String token = JwtUtil.generateToken(request.getUsername());
            return ResponseEntity.ok().body("Bearer " + token);
        } else {
            return ResponseEntity.status(401).body("Usuario o contraseña incorrectos.");
        }
    }

    @GetMapping("/hello")
    public String hello(Principal principal) {
        return "¡Hola " + principal.getName() + ", accediste con un JWT válido!";
    }
}
