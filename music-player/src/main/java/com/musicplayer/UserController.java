package com.musicplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ================= GET ALL USERS =================
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ================= GET USER BY USERNAME =================
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    // ================= REGISTER NEW USER =================
    @PostMapping("/register")
    public String registerUser(@RequestBody User newUser) {
        // Check if username or email already exists
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            return "Username already taken";
        }
        if (userRepository.findByEmail(newUser.getEmail()) != null) {
            return "Email already used";
        }
        userRepository.save(newUser);
        return "Registration successful";
    }

    // ================= LOGIN USER (simplified) =================
    @PostMapping("/login")
    public String loginUser(@RequestBody User loginUser) {
        User user = userRepository.findByUsername(loginUser.getUsername());
        if (user == null) {
            return "User does not exist";
        }
        if (!user.getPassword().equals(loginUser.getPassword())) {
            return "Incorrect password";
        }
        return "Login successful";
    }
}