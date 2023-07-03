package com.application.service;

import com.application.exception.RegistrationException;
import com.application.repository.UserRepository;
import com.application.entity.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserRepository repository;

    public RegistrationService(UserRepository userRepository) {
        this.repository = userRepository;
    }
    public void authorizeUser(String login, String password) {

        if (login == null || password == null) {
            throw new RegistrationException("Ошибка авторизации: логин и/или пароль равен null");
        }

        int hashPassword = password.hashCode();

        repository.save(new User(login, hashPassword));

    }
}
