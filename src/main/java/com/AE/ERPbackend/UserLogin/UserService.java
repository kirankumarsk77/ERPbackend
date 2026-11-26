
package com.AE.ERPbackend.UserLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // LOGIN
    public boolean login(String username, String password) {

        if (username == null || password == null) {
            return false;
        }

        UserEntity user = userRepository
                .findByUsername(username.trim())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (user == null || !user.isEnabled()) {
            return false;
        }

        return passwordEncoder.matches(
                password,
                user.getPassword());
    }

    // REGISTER
    public UserEntity register(String username, String password) {

        if (username == null || username.isBlank()
                || password == null || password.isBlank()) {
            throw new IllegalArgumentException(
                    "Username and password are required");
        }

        if (userRepository.findByUsername(username.trim()).isPresent()) {
            throw new IllegalArgumentException(
                    "Username already exists");
        }

        UserEntity user = new UserEntity();

        user.setUsername(username.trim());

        // BCrypt password hashing
        user.setPassword(passwordEncoder.encode(password));

        user.setRole("USER");
        user.setEnabled(true);

        return userRepository.save(user);
    }
}
