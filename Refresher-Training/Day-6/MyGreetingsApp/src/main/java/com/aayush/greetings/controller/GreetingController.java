package com.aayush.greetings.controller;

import com.aayush.greetings.model.Greeting;
import com.aayush.greetings.model.User;
import com.aayush.greetings.service.GreetingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    // READ - list all greetings for the logged-in user
    @GetMapping
    public String list(HttpSession session, Model model) {
        User user = currentUser(session);
        model.addAttribute("greetings", greetingService.list(user.getId()));
        model.addAttribute("user", user);
        return "greetingList";
    }

    // CREATE - show blank form
    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greetingForm";
    }

    // CREATE or UPDATE - id=0 means new, non-zero means editing
    @PostMapping("/save")
    public String save(@ModelAttribute Greeting greeting, HttpSession session) {
        User user = currentUser(session);
        greeting.setUserId(user.getId());
        if (greeting.getId() == 0) {
            greetingService.add(greeting);
        } else {
            greetingService.update(greeting);
        }
        return "redirect:/greetings";
    }

    // UPDATE - show pre-filled form
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") int id, HttpSession session, Model model) {
        User user = currentUser(session);
        model.addAttribute("greeting", greetingService.get(id, user.getId()));
        return "greetingForm";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, HttpSession session) {
        User user = currentUser(session);
        greetingService.delete(id, user.getId());
        return "redirect:/greetings";
    }

    private User currentUser(HttpSession session) {
        return (User) session.getAttribute("loggedInUser");
    }
}
