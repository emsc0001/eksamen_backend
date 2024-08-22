package com.example.eksamen_backend.controller;

import com.example.eksamen_backend.model.Discipline;
import com.example.eksamen_backend.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    // Allow CORS for this specific endpoint from http://localhost:5173
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public ResponseEntity<List<Discipline>> getAllDisciplines() {
        List<Discipline> disciplines = disciplineService.getAllDisciplines();
        if (disciplines.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(disciplines);
    }
}
