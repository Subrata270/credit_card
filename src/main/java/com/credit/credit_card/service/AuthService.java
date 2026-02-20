package com.credit.credit_card.service;

import com.credit.credit_card.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.credit.credit_card.entity.UserEntity;
import com.credit.credit_card.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(UserEntity user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists!";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "User registered successfully!";
    }

    public String login(String email, String password) {

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid password!";
        }

        return jwtService.generateToken(user.getEmail());
    }
}