package com.ew.elitewings.PrivateJet.entity;

import com.ew.elitewings.Celebrity.entity.CelebrityEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table( name = "Private_Jet")
public class PrivateJetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long jet_id;

    @Column(nullable = false, length = 50)
    private String model;

    @Column(nullable = false, length = 50)
    private int capacity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "celebrity_id", nullable = false)
    private CelebrityEntity owner;
}
