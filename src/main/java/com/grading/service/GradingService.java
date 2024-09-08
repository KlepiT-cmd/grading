package com.grading.service;

import com.grading.persistence.entity.GradingEntity;
import com.grading.persistence.repository.GradingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GradingService {

    @Autowired
    private GradingRepository gradingRepository;

    @Transactional
    public GradingEntity createGrading(GradingEntity grading) {
        return gradingRepository.save(grading);
    }

    public Optional<GradingEntity> findById(UUID id) {
        return gradingRepository.findById(id);
    }

    public void deleteGrading(UUID id) {
    }

    public List<GradingEntity> findAll() {
        return List.of();
    }
}
