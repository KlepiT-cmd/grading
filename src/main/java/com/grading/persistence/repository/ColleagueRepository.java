package com.grading.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grading.persistence.entity.ColleagueEntity;

import java.util.Optional;
import java.util.UUID;

public interface ColleagueRepository extends JpaRepository<ColleagueEntity, UUID> {
    Optional<ColleagueEntity> findByFirstNameAndLastName(String firstName, String lastName);
}