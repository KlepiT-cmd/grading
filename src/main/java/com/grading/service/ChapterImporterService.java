package com.grading.service;

import com.grading.persistence.entity.ChapterEntity;
import com.grading.persistence.repository.ChapterRepository;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterImporterService extends ExcelImporterService<ChapterEntity> {

    @Autowired
    private ChapterRepository repository;

    @Override
    protected ChapterEntity mapRowToEntity(Row row) {
        ChapterEntity chapter = new ChapterEntity();
        chapter.setChapterName(row.getCell(0).getStringCellValue());
        return chapter;
    }

    @Override
    protected void saveEntity(ChapterEntity entity) {
        repository.save(entity);
    }

    @Override
    public boolean supports(String type) {
        return "chapter".equalsIgnoreCase(type);
    }
}

