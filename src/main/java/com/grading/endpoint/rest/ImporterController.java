package com.grading.endpoint.rest;

import com.grading.service.ImporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class ImporterController {

    @Autowired
    private List<ImporterService> importerServices;

    @PostMapping("/{type}")
    public String importFile(@RequestParam("file") MultipartFile file, @PathVariable String type) {
        try (InputStream inputStream = file.getInputStream()) {
            for (ImporterService importerService : importerServices) {
                if (importerService.supports(type)) {
                    importerService.importData(inputStream);
                    return "Import successfull";
                }
            }
            return "Unsupported import type.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Import failed: " + e.getMessage();
        }
    }
}