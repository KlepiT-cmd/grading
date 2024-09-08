package com.grading.persistence.repository;

import com.grading.persistence.entity.LevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LevelRepository extends JpaRepository<LevelEntity, UUID> {
    Optional<LevelEntity> findByLevelName(String levelName);
}