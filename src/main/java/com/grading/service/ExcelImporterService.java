package com.grading.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.IOException;
import java.io.InputStream;

public abstract class ExcelImporterService <T> implements ImporterService {

    @Override
    public void importData(InputStream inputStream) throws IOException {
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet =workbook.getSheetAt(0);
        for (Row row : sheet) {
            T entity = mapRowToEntity(row);
            saveEntity(entity);
        }
    }

    protected abstract T mapRowToEntity(Row row);

    protected abstract void saveEntity(T entity);
}
