package com.example.eksamen_backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startTime;
    private String endTime;

    @OneToMany(mappedBy = "timeSlot")
    private List<Event> events;

}