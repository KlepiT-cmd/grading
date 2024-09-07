package com.grading.service;

import com.grading.persistence.entity.ChapterEntity;
import com.grading.persistence.repository.ChapterRepository;
import org.springframework.stereotype.Service;

@Service
public class ChapterService extends RestService<ChapterEntity> {

    private final ChapterRepository repository;

    public ChapterService(ChapterRepository repository) {
        this.repository = repository;
    }

    @Override
    protected ChapterEntity mapRowToEntity(Row row) {
        ChapterEntity skills = new ChapterEntity();
        skills.setSkillName(row.getCell(0).getStringCellValue());
        skills.setChapterId(row.getCell(1).getStringCellValue());
        skills.setIsCommon(row.getCell(2).getStringCellValue());
        skills.setIsSoftSkill(row.getCell(4).getStringCellValue());
        return skills;
    }

    @Override
    protected void saveEntity(ChapterEntity entity) {
        repository.save(entity);
    }

    @Override
    public boolean supports(String type) {
        return "skills".equalsIgnoreCase(type);
    }
}