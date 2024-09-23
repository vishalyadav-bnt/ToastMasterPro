package com.example.ToastMasterPro.Security.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToastMasterPro.Security.model.User;
import com.example.ToastMasterPro.Security.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    @Autowired
    private UserService userService;

    // @PostMapping
    // public void register(@RequestBody User user) {
    //     userService.registerUser(user);
    // }

    @PostMapping("/login/{username}/{password}")
    public ResponseEntity<User> login(@PathVariable("username") String username,
            @PathVariable("password") String password) {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {

        // Logout handled by Spring Security
    }

    @GetMapping("/getprofile/{id}")
    public User getUser(@PathVariable("id")int id)
    {
        return userService.getUser(id);
    }
}
