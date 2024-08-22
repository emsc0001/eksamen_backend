package com.example.eksamen_backend.model;

import jakarta.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int minimumDuration;
    private String participantGender;
    private String participantAgeGroup;
    private int maximumParticipants;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track;

    @ManyToOne
    @JoinColumn(name = "timeslot_id")
    private TimeSlot timeSlot;

    // Constructors, getters, and setters
    public Event() {}

    public Event(int minimumDuration, String participantGender, String participantAgeGroup, int maximumParticipants, Discipline discipline, Track track, TimeSlot timeSlot) {
        this.minimumDuration = minimumDuration;
        this.participantGender = participantGender;
        this.participantAgeGroup = participantAgeGroup;
        this.maximumParticipants = maximumParticipants;
        this.discipline = discipline;
        this.track = track;
        this.timeSlot = timeSlot;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMinimumDuration() {
        return minimumDuration;
    }

    public void setMinimumDuration(int minimumDuration) {
        this.minimumDuration = minimumDuration;
    }

    public String getParticipantGender() {
        return participantGender;
    }

    public void setParticipantGender(String participantGender) {
        this.participantGender = participantGender;
    }

    public String getParticipantAgeGroup() {
        return participantAgeGroup;
    }

    public void setParticipantAgeGroup(String participantAgeGroup) {
        this.participantAgeGroup = participantAgeGroup;
    }

    public int getMaximumParticipants() {
        return maximumParticipants;
    }

    public void setMaximumParticipants(int maximumParticipants) {
        this.maximumParticipants = maximumParticipants;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}