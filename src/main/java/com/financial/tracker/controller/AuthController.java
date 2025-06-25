package com.financial.tracker.controller;

import com.financial.tracker.dto.LoginRequest;
import com.financial.tracker.dto.RegisterRequest;
import com.financial.tracker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam RegisterRequest request) {
        userService.registerUser(request);
        return ResponseEntity.ok("User Registered Successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam LoginRequest request) {
        userService.validateUser(request.getUsername(), request.getPassword());
        return ResponseEntity.ok("User Login Successful");
    }
}
