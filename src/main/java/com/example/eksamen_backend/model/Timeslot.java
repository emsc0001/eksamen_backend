package com.example.eksamen_backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToMany
    @JoinTable(
            name = "timeslot_event",
            joinColumns = @JoinColumn(name = "timeslot_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    private List<Event> events;

    public Timeslot(Long id, LocalDate date, LocalTime startTime, LocalTime endTime, List<Event> events) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
