package com.grading.service;

import com.grading.persistence.entity.ChapterEntity;
import com.grading.persistence.repository.ChapterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChapterService {

    private final ChapterRepository chapterRepository;

    public List<ChapterEntity> getAllChapters() {
        return chapterRepository.findAll();
    }

    public Optional<ChapterEntity> getChapterById(UUID id) {
        return chapterRepository.findById(id);
    }

    public ChapterEntity createChapter(ChapterEntity chapter) {
        return chapterRepository.save(chapter);
    }

    public ChapterEntity updateChapter(UUID id, ChapterEntity chapterDetails) {
        Optional<ChapterEntity> chapterOptional = chapterRepository.findById(id);
        if (chapterOptional.isPresent()) {
            ChapterEntity chapter = chapterOptional.get();
            chapter.setName(chapterDetails.getName());
            chapter.setDescription(chapterDetails.getDescription());
            return chapterRepository.save(chapter);
        } else {
            return null;  // Handle this case properly in the controller
        }
    }

    public void deleteChapter(UUID id) {
        chapterRepository.deleteById(id);
    }
}
