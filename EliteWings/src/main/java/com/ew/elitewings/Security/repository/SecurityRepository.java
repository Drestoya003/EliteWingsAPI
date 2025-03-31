package com.ew.elitewings.Security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ew.elitewings.Security.entity.SecurityEntity;

@Repository
public interface SecurityRepository extends JpaRepository<SecurityEntity, Long> {
}