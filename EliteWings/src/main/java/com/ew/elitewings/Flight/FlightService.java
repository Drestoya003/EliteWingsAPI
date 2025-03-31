package com.ew.elitewings.Flight;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ew.elitewings.Flight.dto.CreateFlightDto;
import com.ew.elitewings.Flight.entity.FlightEntity;
import com.ew.elitewings.Flight.repository.FlightRepository;


@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;

    public FlightService(FlightRepository flightRepository, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }

    // Crear una nueva celebridad
    public FlightEntity createFlight(CreateFlightDto dto) {
        FlightEntity celebrityEntity = modelMapper.map(dto, FlightEntity.class);
        return flightRepository.save(celebrityEntity);
    }
    // Eliminar por id
    public void deleteFlight(long id){
        flightRepository.deleteById(id);
    }
    // Encontrar por id
    public FlightEntity getFlightById(long id) {
    return flightRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Celebrity with ID " + id + " not found"));
    }
    // Encontrar vuelos Flagged
    public List<FlightEntity> getFlaggedFlights() {
        return flightRepository.findAll().stream()
                .filter(flight -> flight.getPurpose() == FlightEntity.Purpose.SUSPICIOUS) // Filtrar vuelos sospechosos
                .collect(Collectors.toList()); // Convertir a lista
    }


}
