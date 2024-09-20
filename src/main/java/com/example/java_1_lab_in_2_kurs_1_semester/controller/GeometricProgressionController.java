package com.example.java_1_lab_in_2_kurs_1_semester.controller;

import com.example.java_1_lab_in_2_kurs_1_semester.entity.ArithmeticProgression;
import com.example.java_1_lab_in_2_kurs_1_semester.entity.GeometricProgression;
import com.example.java_1_lab_in_2_kurs_1_semester.entity.StartTerms;
import com.example.java_1_lab_in_2_kurs_1_semester.form.ArithmeticProgressionForm;
import com.example.java_1_lab_in_2_kurs_1_semester.form.GeometricProgressionForm;
import com.example.java_1_lab_in_2_kurs_1_semester.repository.GeometricProgressionRepository;
import com.example.java_1_lab_in_2_kurs_1_semester.repository.StartTermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/geometric")
public class GeometricProgressionController {

    @Autowired
    private GeometricProgressionRepository geometricProgressionRepository;

    @Autowired
    private StartTermsRepository startTermsRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<GeometricProgression> geometric = geometricProgressionRepository.findAll();
        model.addAttribute("geometricProgressions", geometric);
        return "geometricList";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("geometricProgression", new GeometricProgressionForm());
        return "geometricForm";
    }
    @PostMapping("/add")
    public String addSubmit(@ModelAttribute("geometricProgression") GeometricProgressionForm form) {
        StartTerms startTerms = new StartTerms();
        GeometricProgression geometric = new GeometricProgression();

        startTerms.setStartTerm(form.getStartTerms().getStartTerm());
        startTerms = startTermsRepository.save(startTerms);

        geometric.setStartTerms(startTerms);
        geometric.setStep(form.getStep());
        geometric.setTerms(form.getTerms());
        geometricProgressionRepository.save(geometric);

        return "redirect:/geometric/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        GeometricProgression geometric = geometricProgressionRepository.findById(id).orElseThrow();
        model.addAttribute("geometric", geometric);
        return "geometricView";
    }


}