package com.example.eksamen_backend.controller;

import com.example.eksamen_backend.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timeslot")
public class TimeSlotController {
    @Autowired
    private TimeSlotService timeSlotService;
}
