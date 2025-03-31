package com.ew.elitewings.PrivateJet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ew.elitewings.PrivateJet.entity.PrivateJetEntity;

@Repository
public interface PrivateJetRepository extends JpaRepository<PrivateJetEntity, Long> {
}