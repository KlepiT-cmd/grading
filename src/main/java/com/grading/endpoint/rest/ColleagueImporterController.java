package com.grading.endpoint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grading.service.ColleagueImporterService;

import java.io.IOException;

@RestController
public class ColleagueImporterController {

    @Autowired
    private ColleagueImporterService excelService;

    @PostMapping("/import-excel")
    public String importExcel(@RequestParam("file") MultipartFile file) {
        try {
            excelService.importExcel(file);
            return "Excel file imported successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to import Excel file.";
        }
    }
}