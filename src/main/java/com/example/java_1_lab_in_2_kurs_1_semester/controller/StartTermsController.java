package com.example.java_1_lab_in_2_kurs_1_semester.controller;

import com.example.java_1_lab_in_2_kurs_1_semester.entity.StartTerms;
import com.example.java_1_lab_in_2_kurs_1_semester.form.StartTermsForm;
import com.example.java_1_lab_in_2_kurs_1_semester.repository.StartTermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/startTerms")
public class StartTermsController {

    @Autowired
    private StartTermsRepository startTermsRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<StartTerms> startTermsList = startTermsRepository.findAll();
        model.addAttribute("startTermsList", startTermsList);
        return "startTermsList";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("startTerms", new StartTermsForm());
        return "startTermsForm";
    }
    @PostMapping("/add")
    public String addSubmit(@ModelAttribute("startTerm") StartTermsForm form) {
        StartTerms startTerms = new StartTerms();
        startTerms.setStartTerm(form.getStartTerm());
        startTerms.setStartName(form.getStartName());
        startTermsRepository.save(startTerms);

        return "redirect:/startTerms/list";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        StartTerms startTerms = startTermsRepository.findById(id).orElseThrow();
        model.addAttribute("startTerms", startTerms);
        return "startTermsView";
    }
}