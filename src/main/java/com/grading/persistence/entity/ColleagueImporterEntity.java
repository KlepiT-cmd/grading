package com.grading.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ColleagueImporterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String column1;
    private String column2;
    private String column3;
    private String column4;
    private String column5;
    private String column6;
    private String column7;
    private String column8;

    public void setColumn1(String stringCellValue) {
    }
    public void setColumn2(String stringCellValue) {
    }
    public void setColumn3(String stringCellValue) {
    }
    public void setColumn4(String stringCellValue) {
    }
    public void setColumn5(String stringCellValue) {
    }
    public void setColumn6(String stringCellValue) {
    }
    public void setColumn7(String stringCellValue) {
    }
    public void setColumn8(String stringCellValue) {
    }
    // Getters and Setters
}