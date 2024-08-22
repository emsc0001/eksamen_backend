package com.example.eksamen_backend.service;

import com.example.eksamen_backend.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService {
    @Autowired
    private DisciplineRepository disciplineRepository;
}
