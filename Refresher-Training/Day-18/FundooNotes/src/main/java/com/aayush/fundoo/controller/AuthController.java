package com.aayush.fundoo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aayush.fundoo.cache.TokenCacheService;
import com.aayush.fundoo.dto.LoginRequest;
import com.aayush.fundoo.dto.LoginResponse;
import com.aayush.fundoo.dto.ForgotPasswordRequest;
import com.aayush.fundoo.dto.MessageResponse;
import com.aayush.fundoo.dto.RegisterRequest;
import com.aayush.fundoo.dto.ResetPasswordRequest;
import com.aayush.fundoo.entity.User;
import com.aayush.fundoo.security.JwtService;
import com.aayush.fundoo.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final TokenCacheService tokenCacheService;
    private final JwtService jwtService;

    public AuthController(AuthService authService, TokenCacheService tokenCacheService, JwtService jwtService) {
        // Receives the service that contains authentication business logic.
        this.authService = authService;
        // Used to blacklist a token in Redis on logout.
        this.tokenCacheService = tokenCacheService;
        this.jwtService = jwtService;
    }
    // created registration End-Point
    @PostMapping("/register")
    public ResponseEntity<MessageResponse> register(
            @Valid @RequestBody RegisterRequest request) {
		// Validates registration data and creates a new user account.

        User user = authService.register(request);

        return ResponseEntity.status(201).body(new MessageResponse("User registered successfully with id " + user.getId()));
    }
    
    // created Login End-Point now 
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (
    		@Valid @RequestBody LoginRequest request){
		// Checks user credentials and returns a JWT token when they are correct.
    	
    	String token = authService.login(request);
    	
		return ResponseEntity.ok(new LoginResponse(token));
    }

	@PostMapping("/forgot-password")
	public ResponseEntity<java.util.Map<String, String>> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {
		// Creates a temporary reset token for the supplied email address.
		String token = authService.forgotPassword(request.getEmail());
		return ResponseEntity.ok(java.util.Map.of(
				"message", "Password reset token generated",
				"resetToken", token,
				"note", "For this training project only: use this token with /reset-password. In production it must be sent by email."));
	}

	@PostMapping("/reset-password")
	public ResponseEntity<MessageResponse> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
		// Replaces the password after checking a valid, unexpired reset token.
		authService.resetPassword(request.getToken(), request.getNewPassword());
		return ResponseEntity.ok(new MessageResponse("Password reset successful"));
	}

	// Logs the caller out by blacklisting their current token in Redis, so it's
	// rejected immediately even though it hasn't naturally expired yet.
	@PostMapping("/logout")
	public ResponseEntity<MessageResponse> logout(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			String token = authHeader.substring(7).trim();
			tokenCacheService.blacklistToken(token, jwtService.getExpirationMs());
		}

		return ResponseEntity.ok(new MessageResponse("Logged out successfully"));
	}
}
