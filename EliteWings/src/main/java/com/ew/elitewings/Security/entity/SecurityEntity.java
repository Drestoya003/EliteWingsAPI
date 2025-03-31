package com.ew.elitewings.Security.entity;

import com.ew.elitewings.Flight.entity.FlightEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Security")
public class SecurityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long security_id;

    @ManyToOne()
    @JoinColumn(name = "flight_id", nullable = false)
    private FlightEntity flight;

    @Column(nullable = false, length = 100)
    private String reported_by;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false)
    private boolean is_resolved = false;

}
