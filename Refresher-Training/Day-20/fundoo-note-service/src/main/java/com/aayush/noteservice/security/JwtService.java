package com.aayush.noteservice.security;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final String secret;

    public JwtService(
            @Value("${jwt.secret}") String secret) {

        this.secret = secret;
    }

    private SecretKey getKey() {

        return Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
    }

    public Optional<Long> validateAndExtractUserId(
            String token) {

        try {

            Claims claims = Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            String subject = claims.getSubject();

            if (subject == null || subject.isBlank()) {
                return Optional.empty();
            }

            return Optional.of(
                    Long.parseLong(subject)
            );

        } catch (Exception exception) {

            return Optional.empty();
        }
    }
}