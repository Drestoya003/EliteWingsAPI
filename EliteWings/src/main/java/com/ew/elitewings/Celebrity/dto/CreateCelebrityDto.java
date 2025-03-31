package com.ew.elitewings.Celebrity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateCelebrityDto {

    @NotBlank // No permite valores vacíos o nulos
    @Size(max = 50) // Limita la longitud a 50 caracteres
    private String name;

    @NotBlank
    @Size(max = 50)
    private String profession;

    @PositiveOrZero // Asegura que el valor sea >= 0
    private double net_worth;

    private boolean suspicious_activity; // No necesita validación especial
}

