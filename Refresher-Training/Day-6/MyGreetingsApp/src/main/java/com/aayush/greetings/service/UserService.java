package com.aayush.greetings.service;

import org.springframework.stereotype.Service;

import com.aayush.greetings.model.User;
import com.aayush.greetings.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /** returns the logged-in User (so we have their id), or null if credentials are wrong */
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public boolean register(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            return false;
        }
        userRepository.addUser(user);
        return true;
    }
}
