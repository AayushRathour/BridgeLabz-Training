package com.aayush.fundoo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.aayush.fundoo.dto.LoginRequest;
import com.aayush.fundoo.dto.RegisterRequest;
import com.aayush.fundoo.entity.User;
import com.aayush.fundoo.repository.UserRepository;
import com.aayush.fundoo.security.JwtService;

@Service
public class AuthService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final long resetTokenExpirationMs;
	
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
    		@Value("${jwt.reset-token-expiration-ms}") long resetTokenExpirationMs) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.resetTokenExpirationMs = resetTokenExpirationMs;
	}

    // method written for user registration 
	@Transactional
	public User register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");
        }

        User user = new User();

        user.setFirstName(request.getFirstname());
        user.setLastName(request.getLastname());
        user.setEmail(request.getEmail());

        // Encrypt password
        user.setPassword(passwordEncoder.encode(request.getPassword()));
		return userRepository.save(user);
    }
	
    // method for login
	
	public String login(LoginRequest request) {

	    User user = userRepository
	            .findByEmail(request.getEmail())
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password"));

	    boolean passwordMatches = passwordEncoder.matches(
	            request.getPassword(),
	            user.getPassword()
	    );

	    if (!passwordMatches) {
	        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
	    }

	    String token = jwtService.generateToken(user.getEmail());

	    return token;
	}

	@Transactional
	public String forgotPassword(String email) {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
		String token = UUID.randomUUID().toString();
		user.setResetToken(token);
		user.setResetTokenExpiry(System.currentTimeMillis() + resetTokenExpirationMs);
		userRepository.save(user);
		return token;
	}

	@Transactional
	public void resetPassword(String token, String newPassword) {
		User user = userRepository.findByResetToken(token)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid reset token"));
		if (user.getResetTokenExpiry() == null || user.getResetTokenExpiry() < System.currentTimeMillis()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reset token has expired");
		}
		user.setPassword(passwordEncoder.encode(newPassword));
		user.setResetToken(null);
		user.setResetTokenExpiry(null);
		userRepository.save(user);
	}
	
}
