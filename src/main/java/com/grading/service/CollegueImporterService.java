package com.grading.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.grading.persistence.repository.CollegueImporterRepository;
import com.grading.persistence.entity.CollegueImporterEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollegueImporterService {

    @Autowired
    private CollegueImporterRepository repository;

    public void importExcel(MultipartFile file) throws IOException {
        List<CollegueImporterEntity> entities = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            if (row.getRowNum() == 0) { // Skip header row
                continue;
            }

            CollegueImporterEntity entity = new CollegueImporterEntity();
            entity.setColumn1(row.getCell(0).getStringCellValue());
            entity.setColumn2(row.getCell(1).getStringCellValue());
            entity.setColumn3(row.getCell(2).getStringCellValue());
            entity.setColumn4(row.getCell(3).getStringCellValue());
            entity.setColumn5(row.getCell(4).getStringCellValue());
            entity.setColumn6(row.getCell(5).getStringCellValue());
            entity.setColumn7(row.getCell(6).getStringCellValue());
            entity.setColumn8(row.getCell(7).getStringCellValue());

            entities.add(entity);
        }

        repository.saveAll(entities);
        workbook.close();
    }
}