package com.example.eksamen_backend.service;

import com.example.eksamen_backend.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeSlotService {
    @Autowired
    private TimeSlotRepository timeSlotRepository;
}
