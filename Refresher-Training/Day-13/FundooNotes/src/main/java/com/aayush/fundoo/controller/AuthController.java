package com.aayush.fundoo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aayush.fundoo.dto.LoginRequest;
import com.aayush.fundoo.dto.LoginResponse;
import com.aayush.fundoo.dto.ForgotPasswordRequest;
import com.aayush.fundoo.dto.MessageResponse;
import com.aayush.fundoo.dto.RegisterRequest;
import com.aayush.fundoo.dto.ResetPasswordRequest;
import com.aayush.fundoo.entity.User;
import com.aayush.fundoo.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    // created registration End-Point
    @PostMapping("/register")
    public ResponseEntity<MessageResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        User user = authService.register(request);

        return ResponseEntity.status(201).body(new MessageResponse("User registered successfully with id " + user.getId()));
    }
    
    // created Login End-Point now 
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (
    		@Valid @RequestBody LoginRequest request){
    	
    	String token = authService.login(request);
    	
		return ResponseEntity.ok(new LoginResponse(token));
    }

	@PostMapping("/forgot-password")
	public ResponseEntity<java.util.Map<String, String>> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {
		String token = authService.forgotPassword(request.getEmail());
		return ResponseEntity.ok(java.util.Map.of(
				"message", "Password reset token generated",
				"resetToken", token,
				"note", "For this training project only: use this token with /reset-password. In production it must be sent by email."));
	}

	@PostMapping("/reset-password")
	public ResponseEntity<MessageResponse> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
		authService.resetPassword(request.getToken(), request.getNewPassword());
		return ResponseEntity.ok(new MessageResponse("Password reset successful"));
	}
}
