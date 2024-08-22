package com.example.eksamen_backend.controller;

import com.example.eksamen_backend.model.Discipline;
import com.example.eksamen_backend.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @GetMapping
    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }
}
