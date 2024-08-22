package com.example.eksamen_backend.model;

import jakarta.persistence.*;

@Entity
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timeRange;

    // Constructors, getters, and setters
    public TimeSlot() {}

    public TimeSlot(String timeRange) {
        this.timeRange = timeRange;
    }

    public Long getId() {
        return id;
    }

    public String getTimeRange() {
        return timeRange;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimeRange(String timeRange) {
        this.timeRange = timeRange;
    }
}