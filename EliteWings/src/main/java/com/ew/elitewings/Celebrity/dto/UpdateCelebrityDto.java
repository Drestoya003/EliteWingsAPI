package com.ew.elitewings.Celebrity.dto;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateCelebrityDto { // No se usa extend CreateCelebrityDto
    //La idea es solo actualizar el campo que se envia, ya que no existe partial type

    @Size(max = 50) // No es obligatorio, pero si se envía, debe tener máximo 50 caracteres
    private String name;

    @Size(max = 50)
    private String profession;

    @PositiveOrZero // Si se envía, debe ser >= 0
    private Double net_worth;

    private Boolean suspicious_activity; // No necesita validación porque es Boolean
}
