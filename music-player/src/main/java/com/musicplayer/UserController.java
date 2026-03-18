package com.musicplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // ================= GET ALL USERS =================
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // ================= GET USER BY USERNAME =================
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    // ================= REGISTER NEW USER =================
    @PostMapping("/register")
    public String registerUser(@RequestBody User newUser) {
        return userService.registerUser(newUser);
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public String loginUser(@RequestBody User loginUser) {
        return userService.loginUser(loginUser.getUsername(), loginUser.getPassword());
    }
}