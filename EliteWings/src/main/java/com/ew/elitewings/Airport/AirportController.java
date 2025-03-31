package com.ew.elitewings.Airport;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ew.elitewings.Airport.entity.AirportEntity;

@RestController
@RequestMapping("/airports")
@Tag(name = "Airports", description = "gestión de airports")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    // Obtener un aeropuerto por ID
    @Operation(summary = "Obtener datos de aeropuierto por id")
    @GetMapping("/{id}")
    public AirportEntity getPrivateJetById(@PathVariable Long id) {
        return airportService.getAirportById(id);
    }
    //Obtener todos los aeropuertos
    @Operation(summary = "Obtener datos de todos los aeropuertos")
    @GetMapping()
    public List<AirportEntity> getAirports() {
        return airportService.getAirports();
    }


}
