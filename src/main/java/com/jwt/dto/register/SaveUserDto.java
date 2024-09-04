package com.jwt.dto.register;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserDto implements Serializable
{
    @Size(min = 5)
    private String name;

    @Size(min = 5)
    private String username;

    @Size(min = 8)
    private String password;

    @Size(min = 8)
    private String repeatedPassword;
}
