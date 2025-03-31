package com.ew.elitewings.Security.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSecurityDto {

    @NotNull(message = "El ID del vuelo es obligatorio")
    private Long flightId;

    @NotBlank(message = "El campo reported_by no puede estar vacío")
    @Size(max = 100, message = "El campo reported_by no puede superar los 100 caracteres")
    private String reportedBy;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 100, message = "La descripción no puede superar los 100 caracteres")
    private String description;

    private boolean isResolved = false; // Por defecto en falso
}

