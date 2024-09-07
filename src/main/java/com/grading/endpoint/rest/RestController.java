package com.grading.endpoint.rest;

import com.grading.persistence.entity.ChapterEntity;
import com.grading.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/chapters")
public class RestController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping
    public ResponseEntity<List<ChapterEntity>> getAllChapters() {
        List<ChapterEntity> chapters = chapterService.getAllChapters();
        return ResponseEntity.ok(chapters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapterEntity> getChapterById(@PathVariable UUID id) {
        Optional<ChapterEntity> chapter = chapterService.getChapterById(id);
        return chapter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ChapterEntity> createChapter(@RequestBody ChapterEntity chapter) {
        ChapterEntity createdChapter = chapterService.createChapter(chapter);
        return ResponseEntity.ok(createdChapter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChapterEntity> updateChapter(@PathVariable UUID id, @RequestBody ChapterEntity chapterDetails) {
        ChapterEntity updatedChapter = chapterService.updateChapter(id, chapterDetails);
        if (updatedChapter != null) {
            return ResponseEntity.ok(updatedChapter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapter(@PathVariable UUID id) {
        chapterService.deleteChapter(id);
        return ResponseEntity.noContent().build();
    }
}
