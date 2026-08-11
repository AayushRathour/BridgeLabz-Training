package com.aayush.greetings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aayush.greetings.model.User;
import com.aayush.greetings.service.UserService;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Model model) {

        User user = new User(username, password);
        boolean created = userService.register(user);

        if (!created) {
            model.addAttribute("error", "That username is already taken.");
            return "register";
        }

        return "redirect:/login";
    }
}
