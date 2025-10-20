package com.agency.digital_agency.controller;

import com.agency.digital_agency.model.User;
import com.agency.digital_agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // Display Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Refers to login.html
    }

    // Display Registration Page
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Refers to register.html
    }

    // Handle Registration Form Submission
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        userService.register(user);
        return "redirect:/login?success"; // Redirect after registration
    }
}
