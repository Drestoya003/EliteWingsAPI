package com.ew.elitewings.Celebrity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ew.elitewings.Celebrity.entity.CelebrityEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CelebrityRepository extends JpaRepository<CelebrityEntity, Long> {
}


