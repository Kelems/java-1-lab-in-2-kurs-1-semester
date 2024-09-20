package com.example.java_1_lab_in_2_kurs_1_semester.repository;

import com.example.java_1_lab_in_2_kurs_1_semester.entity.ArithmeticProgression;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArithmeticProgressionRepository extends JpaRepository<ArithmeticProgression, Long> {
}