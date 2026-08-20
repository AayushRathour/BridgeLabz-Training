package com.aayush.fundoo.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.aayush.fundoo.entity.User;
import com.aayush.fundoo.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
// Exposes protected endpoints for the currently logged-in user's details.
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
		// Receives the repository used to look up the current user.
        this.userRepository = userRepository;
    }

    @GetMapping("/me")
    public Map<String, Object> currentUser(Authentication authentication) {
		// Returns safe profile data for the email stored in the JWT.
        User user = userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return Map.of(
                "id", user.getId(),
                "firstName", user.getFirstName(),
                "lastName", user.getLastName(),
                "email", user.getEmail());
    }
}
