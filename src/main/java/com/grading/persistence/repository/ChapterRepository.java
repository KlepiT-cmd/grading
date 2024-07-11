package com.grading.persistence.repository;

import com.grading.persistence.entity.ChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChapterRepository extends JpaRepository<ChapterEntity, Long> {
    Optional<ChapterEntity> findByName(String name);
}
