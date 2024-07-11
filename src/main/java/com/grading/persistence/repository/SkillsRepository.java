package com.grading.persistence.repository;

import com.grading.persistence.entity.SkillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<SkillsEntity, Long> {
}

