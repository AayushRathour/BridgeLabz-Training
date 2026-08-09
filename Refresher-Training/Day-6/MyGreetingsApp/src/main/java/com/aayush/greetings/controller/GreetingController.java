package com.aayush.greetings.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {

    // Simple in-memory history (Stage 2 extension) - not persisted, resets on restart
    private final List<String> history = new ArrayList<>();

    // Stage 1: show the form
    @GetMapping("/greeting")
    public String showForm() {
        return "greetingForm";
    }

    // Stage 1: handle the form submission
    @PostMapping("/greeting")
    public String submitForm(@RequestParam("name") String name, Model model) {
        String message = "Hello, " + name + "! Welcome to Spring MVC.";
        history.add(name);
        model.addAttribute("message", message);
        model.addAttribute("history", history);
        return "greetingResult";
    }

    // Stage 2: path-variable version, e.g. /greeting/Aayush
    @GetMapping("/greeting/{name}")
    public String greetByPath(@PathVariable String name, Model model) {
        String message = "Hello, " + name + "! Welcome to Spring MVC.";
        history.add(name);
        model.addAttribute("message", message);
        model.addAttribute("history", history);
        return "greetingResult";
    }
}
