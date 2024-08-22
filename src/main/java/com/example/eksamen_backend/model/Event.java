package com.example.eksamen_backend.model;

import com.example.eksamen_backend.enums.DisciplineEnum;
import jakarta.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int duration;
    private int maxParticipants;

    @Enumerated(EnumType.STRING)
    private DisciplineEnum discipline;

    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track;

    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    private TimeSlot timeSlot;

    // Constructors
    public Event() {}

    public Event(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public Event(String name, int duration, int maxParticipants, DisciplineEnum discipline, Track track, TimeSlot timeSlot) {
        this.name = name;
        this.duration = duration;
        this.maxParticipants = maxParticipants;
        this.discipline = discipline;
        this.track = track;
        this.timeSlot = timeSlot;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public DisciplineEnum getDiscipline() {
        return discipline;
    }

    public Track getTrack() {
        return track;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public void setDiscipline(DisciplineEnum discipline) {
        this.discipline = discipline;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}