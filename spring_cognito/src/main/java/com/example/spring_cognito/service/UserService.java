package com.example.spring_cognito.service;

import com.example.spring_cognito.model.User;
import com.example.spring_cognito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to save user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Method to find user by username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Method to find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Other methods as needed

}
