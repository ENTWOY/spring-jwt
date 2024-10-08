package com.jwt.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveProductDTO implements Serializable
{
    @NotBlank(message = "Name cannot be blank!")
    private String name;

    @DecimalMin(value = "0.01", message = "Price must be greater than 0!")
    private BigDecimal price;

    // id de la category >= 1
    @Min(value = 1, message = "Category cannot be null!")
    private Long categoryId;
}
