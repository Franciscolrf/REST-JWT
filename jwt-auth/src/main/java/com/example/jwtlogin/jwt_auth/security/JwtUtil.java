package com.example.jwtlogin.jwt_auth.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Base64;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    // Clave secreta base64-encoded (puedes generar una nueva si gustas)
    private static final String SECRET = "MiClaveJWTsecretaSuperSegura1234567890";
    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    private static final long EXPIRATION_TIME = 60 * 60 * 1000; // 1 hora

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("jwt-auth-app")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    public static String validateTokenAndGetUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
