package com.application.controller;

import com.application.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
    private final AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("")
    public ResponseEntity<String> authorizeUser(@RequestParam String login, @RequestParam String password) {

        authorizationService.authorizeUser(login, password);

        return new ResponseEntity<>("Authorized", HttpStatus.OK);
    }

}
