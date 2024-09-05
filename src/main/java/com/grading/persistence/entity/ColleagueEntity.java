package com.grading.persistence.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class ColleagueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private UUID currentGradingLevel;
    private UUID newGradingLevel;

    @ManyToOne
    @JoinColumn(name = "chapter_id", referencedColumnName = "id")
    private ChapterEntity chapter;

    @ManyToOne
    @JoinColumn(name = "teamlead_id", referencedColumnName = "id")
    private ColleagueEntity teamlead;

    @Column(name = "IsCEO")
    private boolean isceo;

    // Getters and setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ChapterEntity getChapter() {
        return chapter;
    }

    public void setChapter(ChapterEntity chapter) {
        this.chapter = chapter;
    }

    public ColleagueEntity getTeamlead() {
        return teamlead;
    }

    public void setTeamlead(ColleagueEntity teamlead) {
        this.teamlead = teamlead;
    }

    public boolean isIsceo() {
        return isceo;
    }

    public void setIsceo(boolean isceo) {
        this.isceo = isceo;
    }
}
