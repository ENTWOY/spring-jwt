package com.jwt.services.impl;

import com.jwt.dto.register.SaveUserDto;
import com.jwt.exceptions.InvalidPasswordException;
import com.jwt.persistance.entities.User;
import com.jwt.persistance.entities.util.Role;
import com.jwt.persistance.repositories.UserRepository;
import com.jwt.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerOneCustomer(SaveUserDto newUser) {

        // valida que las contrasenas ingresadas por el user (al registrarse) sean correctas y coincidan
        validatePassword(newUser);

        User user = new User();
        user.setName(newUser.getName());
        user.setUsername(newUser.getUsername());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setRole(Role.CUSTOMER);

        // guarda el nuevo usuario (clase entity) en DB
        return userRepository.save(user);
    }

    private void validatePassword(SaveUserDto newUser) {

        // verifica que campos password y repeatedPassword contengan texto
        if (!StringUtils.hasText(newUser.getPassword()) || !StringUtils.hasText(newUser.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords do not match");
        }

        // verifica que campos password y repeatedPassword coincidan
        if (!newUser.getPassword().equals(newUser.getRepeatedPassword())) {
            throw new InvalidPasswordException("Passwords do not match");
        }
    }

    @Override
    public Optional<User> findOneByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}