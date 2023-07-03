package com.application.controller;

import com.application.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	private final RegistrationService registrationService;

	public RegistrationController(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	@PostMapping("")
	public ResponseEntity<String> registerUser(@RequestParam String login, @RequestParam String password) {

		registrationService.authorizeUser(login, password);

		return new ResponseEntity<>("Created", HttpStatus.CREATED);
	}

}
