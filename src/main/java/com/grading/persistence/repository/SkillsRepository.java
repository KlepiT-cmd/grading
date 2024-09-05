package com.grading.persistence.repository;

import com.grading.persistence.entity.SkillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SkillsRepository extends JpaRepository<SkillsEntity, UUID> {
}

