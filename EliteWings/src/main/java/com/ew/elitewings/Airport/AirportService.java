package com.ew.elitewings.Airport;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ew.elitewings.Airport.entity.AirportEntity;
import com.ew.elitewings.Airport.repository.AirportRepository;

@Service
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public AirportEntity getAirportById(long id) {
    return airportRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Celebrity with ID " + id + " not found"));
    }

    public List <AirportEntity> getAirports() {
    return airportRepository.findAll();
    }
}
