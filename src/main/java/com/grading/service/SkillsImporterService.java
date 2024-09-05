package com.grading.service;

import com.grading.persistence.entity.SkillsEntity;
import com.grading.persistence.repository.SkillsRepository;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

@Service
public class SkillsImporterService extends ExcelImporterService<SkillsEntity> {

    private final SkillsRepository repository;

    public SkillsImporterService(SkillsRepository repository) {
        this.repository = repository;
    }

    @Override
    protected SkillsEntity mapRowToEntity(Row row) {
        SkillsEntity skills = new SkillsEntity();
        skills.setSkillName(row.getCell(0).getStringCellValue());
        skills.setChapterId(row.getCell(1).getStringCellValue());
        skills.setIsCommon(row.getCell(2).getStringCellValue());
        skills.setIsSoftSkill(row.getCell(4).getStringCellValue());
        return skills;
    }

    @Override
    protected void saveEntity(SkillsEntity entity) {
        repository.save(entity);
    }

    @Override
    public boolean supports(String type) {
        return "skills".equalsIgnoreCase(type);
    }
}
