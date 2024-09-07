package com.grading.persistence.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class SkillsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String skillName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "colleague_id")
    private ColleagueEntity colleague;

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setChapterId(String stringCellValue) {
    }

    public void setIsCommon(String stringCellValue) {
    }

    public void setIsSoftSkill(String stringCellValue) {
    }

    public ColleagueEntity getColleague() {
        return colleague;
    }

    public void setColleague(ColleagueEntity colleague) {
        this.colleague = colleague;
    }
}

