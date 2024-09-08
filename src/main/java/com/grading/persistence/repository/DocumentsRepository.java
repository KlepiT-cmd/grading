package com.grading.persistence.repository;

import com.grading.persistence.entity.DocumentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentsRepository extends JpaRepository<DocumentsEntity, UUID> {
}
