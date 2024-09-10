package com.grading.service;

import com.grading.persistence.entity.LevelEntity;
import com.grading.persistence.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LevelService {

    @Autowired
    private LevelRepository levelRepository;

    @Transactional
    public LevelEntity createLevel(LevelEntity level) {
        return levelRepository.save(level);
    }

    public Optional<LevelEntity> findByLevelName(String levelName) {
        return levelRepository.findByLevelName(levelName);
    }

    public Optional<LevelEntity> findById(UUID id) {
        return levelRepository.findById(id);
    }

    public void deleteLevel(UUID id) {
    }

    public List<LevelEntity> findAll() {
        return List.of();
    }
}
