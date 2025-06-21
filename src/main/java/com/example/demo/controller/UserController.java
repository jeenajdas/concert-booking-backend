package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Get current user details
    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile() {
        // Retrieve the username of the currently authenticated user
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findByUsername(username)
                          .map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    // Update user details (e.g., password)
    @PutMapping("/profile")
    public ResponseEntity<User> updateUserProfile(@RequestBody User updatedUser) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findByUsername(username)
                          .map(user -> {
                              // Manually update user details
                              user.setUsername(updatedUser.getUsername());
                              user.setPassword(updatedUser.getPassword());  // Assume password is hashed
                              userService.save(user);
                              return ResponseEntity.ok(user);
                          })
                          .orElse(ResponseEntity.notFound().build());
    }
}
