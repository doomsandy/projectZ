package com.application.service;

import com.application.exception.AuthorizationException;
import com.application.repository.UserRepository;
import com.application.entity.User;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
    private final UserRepository repository;

    public AuthorizationService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public void authorizeUser(String login, String password) {

        int hashPassword = password.hashCode();

        User user = repository.findByLogin(login);

        if (user == null) {
            throw new AuthorizationException("Ошибка авторизации: пользователь: " + login + " не найден");
        } else if (!(user.getPassword() == hashPassword)) {
            throw new AuthorizationException("Ошибка авторизации: неверный пароль");
        }

    }
}
