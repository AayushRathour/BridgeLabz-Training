package com.aayush.fundoo.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	private JwtService jwtService;

	public JwtAuthenticationFilter(JwtService jwtService) {
		super();
		this.jwtService = jwtService;
	}
	@Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, java.io.IOException {
		
		// Get the Authorization header from the request
		String authHeader =request.getHeader("Authorization");
		
	// If Authorization header does not exist
        // continue the request without authentication
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
			
		}
		// Remove "Bearer " and keep only the JWT
		String token = authHeader.substring(7).trim();
		 // Check whether the JWT is valid
		if(jwtService.isTokenValid(token)) {
			
			String email = jwtService.extractEmail(token);
			
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, null, null);
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);
	}
	

}
