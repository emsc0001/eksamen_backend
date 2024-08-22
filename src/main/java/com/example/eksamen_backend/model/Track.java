package com.example.eksamen_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // e.g., track, field
    private String shape; // e.g., oval, straight
    private String surface; // e.g., sand, grass
    private int length; // in meters
    private int lanes;

    @ManyToMany
    @JoinTable(
            name = "track_discipline",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    private List<Discipline> disciplines;

    // No-argument constructor
    public Track() {}

    // Constructor with parameters
    public Track(String type, String shape, String surface, int length, int lanes) {
        this.type = type;
        this.shape = shape;
        this.surface = surface;
        this.length = length;
        this.lanes = lanes;
    }

    // Getters and Setters

}