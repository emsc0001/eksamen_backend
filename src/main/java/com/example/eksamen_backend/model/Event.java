package com.example.eksamen_backend.model;

import com.example.eksamen_backend.enums.DisciplineEnum;
import jakarta.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int minimumDuration; // in minutes
    private String participantGender;
    private String participantAgeGroup;
    private int maxParticipants;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track;

    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    private TimeSlot timeSlot;


}