package com.ew.elitewings.Celebrity.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Celebrity")

public class CelebrityEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long celebrity_id;

        @Column(nullable = false, length = 50)
        private String name;

        @Column(nullable = false, length = 50)
        private String profession;

        @Column()
        private double net_worth;

        @Column()
        private boolean suspicious_activity = false;

}


