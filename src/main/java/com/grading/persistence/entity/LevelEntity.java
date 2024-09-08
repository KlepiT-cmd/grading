package com.grading.persistence.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "LEVEL", schema = "grading")
public class LevelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "LevelName", nullable = false, unique = true)
    private String levelName;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
