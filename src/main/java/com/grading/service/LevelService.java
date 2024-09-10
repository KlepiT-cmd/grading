package com.grading.service;

import com.grading.persistence.entity.LevelEntity;
import com.grading.persistence.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LevelService {

    private LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

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
