package com.ew.elitewings.Airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ew.elitewings.Airport.entity.AirportEntity;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {
}


