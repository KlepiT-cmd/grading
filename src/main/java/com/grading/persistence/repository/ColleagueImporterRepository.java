package com.grading.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grading.persistence.entity.ColleagueImporterEntity;

public interface ColleagueImporterRepository extends JpaRepository<ColleagueImporterEntity, Long> {
}