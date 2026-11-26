package com.AE.ERPbackend.UserLogin;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService authService;

    public UserController(UserService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserDTO request) {
        if (authService.login(request.getUsername(), request.getPassword())) {
            return ResponseEntity.ok(Map.of("message", "Login successful", "username", request.getUsername().trim()));
        }
        return ResponseEntity.status(401).body(Map.of("message", "Invalid username or password"));
    }

    // REGISTER API
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDTO request) {

        UserEntity user = authService.register(
                request.getUsername(),
                request.getPassword());

        return ResponseEntity.ok(
                Map.of(
                        "message", "Registration successful",
                        "username", user.getUsername()));
    }
}
