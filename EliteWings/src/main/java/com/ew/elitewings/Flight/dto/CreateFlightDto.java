package com.ew.elitewings.Flight.dto;
import java.time.LocalDateTime;

import com.ew.elitewings.Flight.entity.FlightEntity.Purpose;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFlightDto {

    @NotNull
    private long celebrity_id;
    
    @NotNull
    private long jet_id;

    @NotBlank
    private String departure_airport;

    @NotBlank
    private String arrival_airport;

    @NotNull
    private LocalDateTime departure_time;

    @NotNull
    private LocalDateTime arrival_time;

    @NotNull
    private Purpose purpose;




}
