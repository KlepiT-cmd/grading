package com.grading.persistence.repository;

import com.grading.persistence.entity.GradingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GradingRepository extends JpaRepository<GradingEntity, UUID> {
}
