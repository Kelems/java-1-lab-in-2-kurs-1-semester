package com.example.java_1_lab_in_2_kurs_1_semester.entity;

import jakarta.persistence.*;

@Entity
public class StartTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;

    private int startTerm;
    private String startName;

    // Геттеры и сеттеры
    public Long getTermId() {
        return termId;
    }

    public int getStartTerm() {
        return startTerm;
    }
    public String getStartName() {
        return startName;
    }

    public void setStartTerm(int startTerm) {
        this.startTerm = startTerm;
    }
    public void setStartName(String startName) {
        this.startName = startName;
    }
}