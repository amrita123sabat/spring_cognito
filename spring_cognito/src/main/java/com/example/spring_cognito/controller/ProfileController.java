package com.example.spring_cognito.controller;
import com.example.spring_cognito.model.User;
import com.example.spring_cognito.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    private final UserProfileService userProfileService;

    @Autowired
    public ProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @GetMapping("/profile")
    public String showProfilePage(@AuthenticationPrincipal User user, Model model) {
        // Get the currently logged-in user from the security context
        // Assuming User implements UserDetails for authentication

        // Retrieve user profile data from the service
        User userProfile = userProfileService.getUserByEmail(user.getEmail());

        // Add user profile data to the model to be displayed on the profile page
        model.addAttribute("userProfile", userProfile);

        // Return the profile page template
        return "profile"; // Assuming you have a profile.html Thymeleaf template
    }
}
