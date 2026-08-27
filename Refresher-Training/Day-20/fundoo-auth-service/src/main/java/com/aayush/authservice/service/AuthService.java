package com.aayush.authservice.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.aayush.authservice.dto.LoginRequest;
import com.aayush.authservice.dto.RegisterRequest;
import com.aayush.authservice.entity.User;
import com.aayush.authservice.mapper.UserMapper;
import com.aayush.authservice.repository.UserRepository;
import com.aayush.authservice.security.JwtService;

@Service
public class AuthService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final long resetTokenExpirationMs;
	private final UserMapper userMapper;
	
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
			@Value("${jwt.reset-token-expiration-ms}") long resetTokenExpirationMs, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.resetTokenExpirationMs = resetTokenExpirationMs;
		this.userMapper = userMapper;
	}

    // method written for user registration 
	@Transactional
	public User register(RegisterRequest request) {
		// Checks email uniqueness, encrypts the password, and saves a new user.

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");
        }

		User user = userMapper.toEntity(request);

        // Encrypt password
        user.setPassword(passwordEncoder.encode(request.getPassword()));
		return userRepository.save(user);
    }
	
    // method for login
	
	public String login(LoginRequest request) {
		// Validates credentials and generates a JWT for a successful login.

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

	    // Embed userId (not email) so note-service and reminder-service can extract it as a Long
	    String token = jwtService.generateToken(String.valueOf(user.getId()));

	    return token;
	}

	
	// Method for forgot password
	public String forgotPassword(String email) {
		// Stores a short-lived random token that can be used to reset a password.
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
		String token = UUID.randomUUID().toString();
		user.setResetToken(token);
		user.setResetTokenExpiry(System.currentTimeMillis() + resetTokenExpirationMs);
		userRepository.save(user);
		return token;
	}

	// for reseting password
	public void resetPassword(String token, String newPassword) {
		// Validates the reset token and saves the encrypted replacement password.
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
