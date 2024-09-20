package com.example.java_1_lab_in_2_kurs_1_semester.entity;

import jakarta.persistence.*;

@Entity
public class ArithmeticProgression {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long arithmeticProgressionId;

    @ManyToOne
    @JoinColumn(name = "term_id", nullable = false)
    private StartTerms startTerms;

    private int step;
    private int terms;

    // Геттеры
    public Long getArithmeticProgressionId() {
        return arithmeticProgressionId;
    }

    public StartTerms getStartTerms() {
        return startTerms;
    }

    public int getStep() {
        return step;
    }

    public int getTerms() {
        return terms;
    }

    // Сеттеры

    public void setStartTerms(StartTerms startTerms) {
        this.startTerms = startTerms;
    }
    public void setStep(int step) {
        this.step = step;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }
}