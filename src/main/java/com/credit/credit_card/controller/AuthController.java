package com.credit.credit_card.controller;

import com.credit.credit_card.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.credit.credit_card.entity.UserEntity;
import com.credit.credit_card.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody UserEntity user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserEntity user) {
        return authService.login(user.getEmail(), user.getPassword());
    }
}