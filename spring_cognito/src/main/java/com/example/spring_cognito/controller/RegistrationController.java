package com.example.spring_cognito.controller;

import com.example.spring_cognito.model.User;
import com.example.spring_cognito.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final UserProfileService userProfileService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserProfileService userProfileService, BCryptPasswordEncoder passwordEncoder) {
        this.userProfileService = userProfileService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {
        // Encrypt the password before saving
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userProfileService.saveUser(user);
        return "redirect:/login";
    }
}
