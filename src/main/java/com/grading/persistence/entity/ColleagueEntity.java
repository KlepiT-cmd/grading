package com.grading.persistence.entity;

import javax.persistence.*;

@Entity
public class ColleagueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private ChapterEntity chapter;

    @ManyToOne
    @JoinColumn(name = "teamlead_id")
    private ColleagueEntity teamlead;

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
