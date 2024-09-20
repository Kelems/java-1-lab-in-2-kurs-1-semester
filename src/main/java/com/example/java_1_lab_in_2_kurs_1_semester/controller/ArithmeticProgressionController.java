package com.example.java_1_lab_in_2_kurs_1_semester.controller;

import com.example.java_1_lab_in_2_kurs_1_semester.entity.ArithmeticProgression;
import com.example.java_1_lab_in_2_kurs_1_semester.entity.StartTerms;
import com.example.java_1_lab_in_2_kurs_1_semester.form.ArithmeticProgressionForm;
import com.example.java_1_lab_in_2_kurs_1_semester.repository.ArithmeticProgressionRepository;
import com.example.java_1_lab_in_2_kurs_1_semester.repository.StartTermsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/arithmetic")
public class ArithmeticProgressionController {

    @Autowired
    private ArithmeticProgressionRepository arithmeticProgressionRepository;

    @Autowired
    private StartTermsRepository startTermsRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<ArithmeticProgression> arithmetic = arithmeticProgressionRepository.findAll();
        model.addAttribute("arithmeticProgressions", arithmetic);
        return "arithmeticList";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("arithmeticProgression", new ArithmeticProgressionForm());
        return "arithmeticForm";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute("arithmeticProgression") ArithmeticProgressionForm form) {
        StartTerms startTerms = new StartTerms();
        startTerms.setStartTerm(form.getStartTerms().getStartTerm());
        startTerms = startTermsRepository.save(startTerms);

        ArithmeticProgression arithmetic = new ArithmeticProgression();
        arithmetic.setStartTerms(startTerms);
        arithmetic.setStep(form.getStep());
        arithmetic.setTerms(form.getTerms());
        arithmeticProgressionRepository.save(arithmetic);
        return "redirect:/arithmetic/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        ArithmeticProgression arithmetic = arithmeticProgressionRepository.findById(id).orElseThrow();
        model.addAttribute("arithmetic", arithmetic);
        return "arithmeticView";
    }
}