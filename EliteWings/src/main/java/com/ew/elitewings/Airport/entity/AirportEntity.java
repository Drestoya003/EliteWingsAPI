package com.ew.elitewings.Airport.entity;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "Airport")
public class AirportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long airport_id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String location;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private String owners = "Sofia and Natalia the best owners";
}
