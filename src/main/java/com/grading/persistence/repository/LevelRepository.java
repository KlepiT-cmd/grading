package com.grading.persistence.repository;

import com.grading.persistence.entity.LevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<LevelEntity, Long> {
}

