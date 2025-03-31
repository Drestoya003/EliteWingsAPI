package com.ew.elitewings.Flight.entity;
import java.time.LocalDateTime;

import com.ew.elitewings.Celebrity.entity.CelebrityEntity;
import com.ew.elitewings.PrivateJet.entity.PrivateJetEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "Flight")

public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long flight_id;

    @ManyToOne
    @JoinColumn(name = "celebrity_id", nullable = false)
    private CelebrityEntity celebrity;

    @ManyToOne()
    @JoinColumn(name = "jet_id", nullable = false)
    private PrivateJetEntity jet ;

    @Column(nullable = false, length = 100)
    private String departure_airport;

    @Column(nullable = false, length = 100)
    private String arrival_airport;

    @Column(nullable = false)
    private LocalDateTime departure_time;

    @Column(nullable = false)
    private LocalDateTime arrival_time;

    public enum Purpose {
        BUSINESS, VACATION, SUSPICIOUS;
    }
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Purpose purpose;
}


