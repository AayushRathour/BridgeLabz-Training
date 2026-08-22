package com.aayush.fundoo.security;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.aayush.fundoo.cache.TokenCacheService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final TokenCacheService tokenCacheService;

    public JwtAuthenticationFilter(JwtService jwtService, TokenCacheService tokenCacheService) {

        // Used to validate and read JWT tokens
        this.jwtService = jwtService;
        // Used to skip re-verifying a token we already checked recently, and to reject logged-out tokens
        this.tokenCacheService = tokenCacheService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        // Read Authorization header
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
            return;
        }

        // Remove "Bearer " from the beginning
        String token = authHeader.substring(7).trim();

        // Logged-out tokens are rejected immediately - checked before any JWT parsing
        if (tokenCacheService.isBlacklisted(token)) {
            filterChain.doFilter(request, response);
            return;
        }

        // Redis cache hit -> reuse the already-verified email, skip JWT signature parsing entirely
        Optional<String> cachedEmail = tokenCacheService.getCachedEmail(token);

        String email;
        if (cachedEmail.isPresent()) {
            email = cachedEmail.get();
        } else {
            // Cache miss -> fall back to the slower path: verify signature + expiry
            Optional<String> validatedEmail = jwtService.validateAndExtractEmail(token);
            if (validatedEmail.isEmpty()) {
                filterChain.doFilter(request, response);
                return;
            }
            email = validatedEmail.get();
            tokenCacheService.cacheEmailForToken(token, email); // remember it for next time
        }

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        email,
                        null,
                        Collections.emptyList()
                );

        // Store authenticated user in Spring Security context
        SecurityContextHolder
                .getContext()
                .setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}