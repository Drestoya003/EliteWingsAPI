package com.ew.elitewings.Flight;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ew.elitewings.Flight.dto.CreateFlightDto;
import com.ew.elitewings.Flight.entity.FlightEntity;



@RestController
@RequestMapping("/flights")
@Tag(name = "flights", description = "gestion de flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // Crear un nuevo flight
    @Operation(summary = "Registrar un nuevo flight")
    @PostMapping
    public ResponseEntity<FlightEntity> createFlight(@Validated @RequestBody CreateFlightDto dto) {
        FlightEntity createdCelebrity = flightService.createFlight(dto);
        return ResponseEntity.status(201).body(createdCelebrity);
    }

    // Obtener un vuelo por id
    @Operation(summary = "Obtener detalles de un vuelo en especifico")
    @GetMapping("/{id}")
    public FlightEntity getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    // Eliminar un vuelo por ID
    @Operation(summary = "Eliminar un flight")
    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }

    @Operation(summary = "Traer todos los flights sospechosos")
    @GetMapping("/suspicious")
    public List<FlightEntity> getFlaggedFlights() {
        return flightService.getFlaggedFlights();
    }
}
