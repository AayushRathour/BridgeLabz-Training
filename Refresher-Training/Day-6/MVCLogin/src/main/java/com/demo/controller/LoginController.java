package com.demo.controller;

import com.demo.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    // Display Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Display Register Page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // Handle Registration
    @PostMapping("/register")
    public String register(@ModelAttribute User user, Model model) {

        model.addAttribute("message",
                "Registration Successful: " + user.getUsername());

        return "success";
    }

    // Handle Login
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {

        if ("admin".equals(user.getUsername())
                && "1234".equals(user.getPassword())) {

            model.addAttribute("message", "Login Successful!");
            return "success";

        } else {

            model.addAttribute("message",
                    "Invalid Username or Password");

            return "login";
        }
    }
}