package com.example.medicinereport.controller;

import com.example.medicinereport.model.Medicine;
import com.example.medicinereport.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MedicineController {

    @Autowired
    private MedicineRepository repository;

    @GetMapping("/")
    public String getAllMedicine(Model model){
        List<Medicine> medicines = repository.findAll();
        model.addAttribute("medicines", medicines);
        return "index";
    }

    @PostMapping(value = "/add")
    public String saveProduct(@ModelAttribute("medicine") Medicine medicine){
        repository.save(medicine);
        return "redirect:/";
    }
}