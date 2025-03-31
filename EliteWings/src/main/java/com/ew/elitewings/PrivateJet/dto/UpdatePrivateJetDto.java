package com.ew.elitewings.PrivateJet.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdatePrivateJetDto {

    @Size(max = 50)
    private String model;

    @Size(max = 50)
    private String manufacturer;

    @NotNull
    private Integer capacity; 

    private Long celebrityId; 
    // Si se cambia el dueño del jet
}
