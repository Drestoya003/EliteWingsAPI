package com.ew.elitewings.Flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ew.elitewings.Flight.entity.FlightEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
}
