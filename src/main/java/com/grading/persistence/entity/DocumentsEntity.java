package com.grading.persistence.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "DOCUMENTS", schema = "grading")
public class DocumentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "DocumentData", nullable = false, unique = true)
    private String documentData;

    @Column(name = "Year", nullable = false)
    private int year;

    @ManyToOne
    @JoinColumn(name = "ColleagueId", referencedColumnName = "id")
    private ColleagueEntity colleague;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDocumentData() {
        return documentData;
    }

    public void setDocumentData(String documentData) {
        this.documentData = documentData;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ColleagueEntity getColleague() {
        return colleague;
    }

    public void setColleague(ColleagueEntity colleague) {
        this.colleague = colleague;
    }
}
