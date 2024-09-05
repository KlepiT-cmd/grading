package com.grading.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ChapterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String setChapterName;

    public void setChapterName(String stringCellValue) {
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSetChapterName() {
        return setChapterName;
    }

    public void setChapterName(String setChapterName) {
        this.setChapterName = setChapterName;
    }
}
