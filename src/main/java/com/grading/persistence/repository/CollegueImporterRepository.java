package com.grading.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grading.persistence.entity.CollegueImporterEntity;

public interface CollegueImporterRepository extends JpaRepository<CollegueImporterEntity, Long> {
}