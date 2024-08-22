package com.example.eksamen_backend.dto;

public class EventDTO {
    private String name;
    private Long trackId;
    private Long timeSlotId;
    private int duration;
    private int maxParticipants;
    private String discipline;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    public Long getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
