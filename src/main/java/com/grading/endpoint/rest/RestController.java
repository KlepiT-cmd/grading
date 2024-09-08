package com.grading.endpoint.rest;

import com.grading.persistence.entity.LevelEntity;
import com.grading.persistence.entity.DocumentsEntity;
import com.grading.persistence.entity.GradingEntity;
import com.grading.service.LevelService;
import com.grading.service.DocumentsService;
import com.grading.service.GradingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/grading")
public class RestController {

    private final LevelService levelService;
    private final  DocumentsService documentsService;
    private final  GradingService gradingService;

public RestController(LevelService levelService, DocumentsService documentsService, GradingService gradingService) {
    this.levelService = levelService;
    this.documentsService = documentsService;
    this.gradingService = gradingService;
    }

    @PostMapping("/levels")
    public ResponseEntity<LevelEntity> createLevel(@RequestBody LevelEntity level) {
        LevelEntity createdLevel = levelService.createLevel(level);
        return new ResponseEntity<>(createdLevel, HttpStatus.CREATED);
    }

    @GetMapping("/levels/{id}")
    public ResponseEntity<LevelEntity> getLevelById(@PathVariable UUID id) {
        Optional<LevelEntity> level = levelService.findById(id);
        return level.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/levels")
    public ResponseEntity<List<LevelEntity>> getAllLevels() {
        List<LevelEntity> levels = levelService.findAll();
        return new ResponseEntity<>(levels, HttpStatus.OK);
    }

    @DeleteMapping("/levels/{id}")
    public ResponseEntity<Void> deleteLevel(@PathVariable UUID id) {
        levelService.deleteLevel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/documents")
    public ResponseEntity<DocumentsEntity> createDocument(@RequestBody DocumentsEntity document) {
        DocumentsEntity createdDocument = documentsService.saveDocument(document);
        return new ResponseEntity<>(createdDocument, HttpStatus.CREATED);
    }

    @GetMapping("/documents/{id}")
    public ResponseEntity<DocumentsEntity> getDocumentById(@PathVariable UUID id) {
        Optional<DocumentsEntity> document = documentsService.findById(id);
        return document.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/documents")
    public ResponseEntity<List<DocumentsEntity>> getAllDocuments() {
        List<DocumentsEntity> documents = documentsService.findAll();
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @DeleteMapping("/documents/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable UUID id) {
        documentsService.deleteDocument(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/gradings")
    public ResponseEntity<GradingEntity> createGrading(@RequestBody GradingEntity grading) {
        GradingEntity createdGrading = gradingService.createGrading(grading);
        return new ResponseEntity<>(createdGrading, HttpStatus.CREATED);
    }

    @GetMapping("/gradings/{id}")
    public ResponseEntity<GradingEntity> getGradingById(@PathVariable UUID id) {
        Optional<GradingEntity> grading = gradingService.findById(id);
        return grading.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/gradings")
    public ResponseEntity<List<GradingEntity>> getAllGradings() {
        List<GradingEntity> gradings = gradingService.findAll();
        return new ResponseEntity<>(gradings, HttpStatus.OK);
    }

    @DeleteMapping("/gradings/{id}")
    public ResponseEntity<Void> deleteGrading(@PathVariable UUID id) {
        gradingService.deleteGrading(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}