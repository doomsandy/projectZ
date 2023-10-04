package com.application.controller;

import com.application.entity.User;
import com.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserRepository repository;

    @PostMapping("/register")
    User registerUser(@RequestParam String login, @RequestParam String password) {
        return repository.save(new User(2, login, password, User.Role.USER));
    }

    @PostMapping("/exists")
    Boolean emailExists(@RequestParam String login) {
        return repository.existsByLogin(login);
    }

}
