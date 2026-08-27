package com.aayush.authservice.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aayush.authservice.cache.TokenCacheService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final TokenCacheService tokenCacheService;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            TokenCacheService tokenCacheService) {

        this.jwtService = jwtService;
        this.tokenCacheService = tokenCacheService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        // If Spring Security has already authenticated the request,
        // don't authenticate it again.
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            filterChain.doFilter(request, response);
            return;
        }

        // 1. Read Authorization header
        String authHeader = request.getHeader("Authorization");

        // No JWT → continue.
        // Public endpoints such as /api/auth/login can continue normally.
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        // 2. Extract JWT
        String token = authHeader.substring(7).trim();

        if (token.isEmpty()) {
            sendUnauthorized(response, "Invalid or empty JWT token");
            return;
        }

        // 3. Check Redis blacklist
        if (tokenCacheService.isBlacklisted(token)) {
            sendUnauthorized(response, "Token has been logged out");
            return;
        }

        // 4. Try Redis cache first (subject is now userId string, not email)
        String subject = tokenCacheService
                .getCachedEmail(token)
                .orElse(null);

        // 5. If not cached, validate JWT and extract userId
        if (subject == null) {

            subject = jwtService
                    .validateAndExtractEmail(token)
                    .orElse(null);

            // Invalid / expired JWT
            if (subject == null) {
                sendUnauthorized(response, "Invalid or expired JWT token");
                return;
            }

            // 6. Cache valid token → userId mapping in Redis
            // Pass the JWT lifetime so Redis TTL never outlives the token itself.
            tokenCacheService.cacheEmailForToken(
                    token,
                    subject,
                    System.currentTimeMillis() + jwtService.getExpirationMs()
            );
        }

        // 7. Create Spring Security authentication (principal = userId string)
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        subject,
                        null,
                        Collections.emptyList()
                );

        // 8. Store authentication in SecurityContext
        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

        // 9. Continue request
        filterChain.doFilter(request, response);
    }

    private void sendUnauthorized(
            HttpServletResponse response,
            String message) throws IOException {

        SecurityContextHolder.clearContext();

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write(
                "{\"error\":\"Unauthorized\",\"message\":\""
                        + message
                        + "\"}"
        );
    }
}