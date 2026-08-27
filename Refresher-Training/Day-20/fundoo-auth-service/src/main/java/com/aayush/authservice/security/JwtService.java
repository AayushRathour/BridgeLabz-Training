package com.aayush.authservice.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    // Creates the secret key used to sign and verify JWT
    private SecretKey getKey() {

        return Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8)
        );
    }

    // Generates JWT after successful login
    public String generateToken(String email) {

        return Jwts.builder()

                // Store email inside JWT
                .subject(email)
                // Token creation time
                .issuedAt(new Date())
                // Token expiry time
                .expiration(
                        new Date(
                                System.currentTimeMillis() + expiration))
                .signWith(getKey())

                // Convert JWT object to String
                .compact();
    }

    // Extract email from JWT
    public String extractEmail(String token) {

        return Jwts.parser()

                // Verify JWT signature
                .verifyWith(getKey())
                .build()
                // Parse and verify JWT
                .parseSignedClaims(token)
                // Get JWT payload
                .getPayload()
                .getSubject();
    }

    // Check whether JWT is valid
    public boolean isTokenValid(String token) {
        try {

            extractEmail(token);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    // Verifies the signature once and returns the email only if it's valid -
    // avoids parsing the same token twice like isTokenValid() + extractEmail() would.
    // Used by the filter on a Redis cache miss.
    public Optional<String> validateAndExtractEmail(String token) {
        try {
            String email = Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
            return Optional.of(email);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // Exposes the configured token lifetime so callers (e.g. logout) can size a Redis TTL correctly
    public long getExpirationMs() {
        return expiration;
    }
}
