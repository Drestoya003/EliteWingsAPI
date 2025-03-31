package com.ew.elitewings.PrivateJet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreatePrivateJetDto {

    @NotBlank
    @Size(max = 50)
    private String model;

    @Positive
    private int capacity;

    @NotNull
    private long owner;







}
