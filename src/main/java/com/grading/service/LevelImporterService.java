package com.grading.service;

import com.grading.persistence.entity.LevelEntity;
import com.grading.persistence.repository.LevelRepository;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

@Service
public class LevelImporterService extends ExcelImporterService<LevelEntity> {

    private final LevelRepository repository;

    public LevelImporterService(LevelRepository repository) {
        this.repository = repository;
    }

    @Override
    protected LevelEntity mapRowToEntity(Row row) {
        LevelEntity level = new LevelEntity();
        level.setName(row.getCell(0).getStringCellValue());
        return level;
    }

    @Override
    protected void saveEntity(LevelEntity entity) {
        repository.save(entity);
    }

    @Override
    public boolean supports(String type) {
        return "level".equalsIgnoreCase(type);
    }
}

