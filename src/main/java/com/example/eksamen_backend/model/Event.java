package com.example.eksamen_backend.model;

import com.example.eksamen_backend.enums.DisciplineEnum;
import com.example.eksamen_backend.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String participantAgeGroup;
    private GenderEnum participantGender;
    private int minimumDuration;
    private DisciplineEnum discipline;

    @ManyToOne
    private Track track;

    @ManyToOne
    private TimeSlot timeSlot;

    // Default constructor
    public Event() {
    }

    // Constructor without maximumParticipants
    public Event(String name, String participantAgeGroup, GenderEnum participantGender, int minimumDuration, DisciplineEnum discipline, Track track, TimeSlot timeSlot) {
        this.name = name;
        this.participantAgeGroup = participantAgeGroup;
        this.participantGender = participantGender;
        this.minimumDuration = minimumDuration;
        this.discipline = discipline;
        this.track = track;
        this.timeSlot = timeSlot;
    }

}
