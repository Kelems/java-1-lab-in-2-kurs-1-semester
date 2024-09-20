package com.example.java_1_lab_in_2_kurs_1_semester.form;

public class GeometricProgressionForm {

    private StartTermsForm startTerms;
    private int step;
    private int terms;

    // Геттеры и сеттеры
    public StartTermsForm getStartTerms() {
        return startTerms;
    }
    public int getTerms() {
        return terms;
    }
    public int getStep() {
        return step;
    }
    // сеттеры
    public void setStartTerms(StartTermsForm startTerms) {
        this.startTerms = startTerms;
    }
    public void setStep(int step) {
        this.step = step;
    }
    public void setTerms(int terms) {
        this.terms = terms;
    }
}