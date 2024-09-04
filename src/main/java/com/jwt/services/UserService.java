package com.jwt.services;

import com.jwt.dto.register.SaveUserDto;
import com.jwt.persistance.entities.User;

import java.util.Optional;

public interface UserService
{
    User registerOneCustomer(SaveUserDto newUser);
    Optional<User> findOneByUsername(String username);
}
