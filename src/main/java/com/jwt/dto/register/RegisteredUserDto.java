package com.jwt.dto.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredUserDto implements Serializable
{
    private Long id;
    private String name;
    private String username;
    private String role;
    private String jwt;
}
