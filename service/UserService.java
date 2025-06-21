package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Sign-up method to create a new user
    @Transactional
    public String signUpUser(User user) {
        // Check if user already exists by username or email
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Error: Username already taken!";
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Error: Email already registered!";
        }
     // Determine if this is the first user
        boolean isFirstUser = userRepository.count() == 0;

        // Assign admin role to the first user, otherwise assign a regular role
        user.setRole(isFirstUser ? "ADMIN" : "USER");
        
        // Assign the first user as ADMIN
        if (userRepository.count() == 0) {
            user.setRole("ADMIN");
        } else {
            user.setRole("USER");
        }

        // Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user to the database
        userRepository.save(user);

        return "Sign up successful!";
    }

    // Login method
    public String loginUser(String username, String password) {
        // Find user by username
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return "Login successful!";
        }
        return "Invalid username or password!";
    }

public User getUserByUsername(String username) {
    return userRepository.findByUsername(username);
}

/**
 * Checks if a user with the given email exists.
 * 
 * @param email The email to check for.
 * @return true if a user exists with the given email, false otherwise.
 */
public boolean existsByEmail(String email) {
    return userRepository.findByEmail(email) != null;
}

/**
 * Checks if a user with the given username exists.
 * 
 * @param username The username to check for.
 * @return true if a user exists with the given username, false otherwise.
 */
public boolean existsByUsername(String username) {
    return userRepository.findByUsername(username) != null;
}
}
