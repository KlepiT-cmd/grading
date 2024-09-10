package com.grading.persistence.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "GRADING", schema = "grading")
public class GradingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "ColleagueID", referencedColumnName = "id")
    private ColleagueEntity colleague;

    @ManyToOne
    @JoinColumn(name = "GradingLevelId", referencedColumnName = "id")
    private LevelEntity gradingLevel;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ColleagueEntity getColleague() {
        return colleague;
    }

    public void setColleague(ColleagueEntity colleague) {
        this.colleague = colleague;
    }

    public LevelEntity getGradingLevel() {
        return gradingLevel;
    }

    public void setGradingLevel(LevelEntity gradingLevel) {
        this.gradingLevel = gradingLevel;
    }
}
