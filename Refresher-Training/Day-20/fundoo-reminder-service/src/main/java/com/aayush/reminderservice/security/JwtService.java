package com.aayush.reminderservice.security;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * Validates JWT tokens issued by auth-service and extracts the userId (subject).
 *
 * The JWT subject is the user's Long id stored as a string —
 * this matches the fix applied to auth-service where userId replaces email.
 *
 * Identical to the pattern used in note-service.
 */
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

    /**
     * Parses and verifies the token in a single pass.
     *
     * @param token raw JWT (without "Bearer " prefix)
     * @return Optional containing the userId if the token is valid,
     *         or empty if invalid / expired / tampered
     */
    public Optional<Long> validateAndExtractUserId(String token) {
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

            return Optional.of(Long.parseLong(subject));

        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
