package com.aayush.authservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.aayush.authservice.entity.User;
import com.aayush.authservice.dto.UserResponse;
import com.aayush.authservice.mapper.UserMapper;
import com.aayush.authservice.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
// Exposes protected endpoints for the currently logged-in user's details.
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserController(UserRepository userRepository, UserMapper userMapper) {
		// Receives the repository used to look up the current user.
        this.userRepository = userRepository;
		this.userMapper = userMapper;
    }

    @GetMapping("/me")
    public UserResponse currentUser(Authentication authentication) {
		// Returns safe profile data for the email stored in the JWT.
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return userMapper.toResponse(user);
    }
}
