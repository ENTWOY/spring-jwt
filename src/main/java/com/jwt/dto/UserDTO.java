package com.jwt.dto;

import com.jwt.persistance.entities.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO
{
    private String name;
    private String username;
    private Role role;
}
