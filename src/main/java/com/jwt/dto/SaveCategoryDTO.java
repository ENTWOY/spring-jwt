package com.jwt.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCategoryDTO implements Serializable
{
    @NotBlank(message = "Category name cannot be blank!")
    private String name;
}
