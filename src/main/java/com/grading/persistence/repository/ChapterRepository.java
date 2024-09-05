package com.grading.persistence.repository;

import com.grading.persistence.entity.ChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ChapterRepository extends JpaRepository<ChapterEntity, UUID> {
    Optional<ChapterEntity> findByName(String name);
}
