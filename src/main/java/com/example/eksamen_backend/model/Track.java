package com.example.eksamen_backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String type;
    private String shape;
    private String surface;
    private int length;
    private int Lanes;

    @ManyToMany
    @JoinTable(
            name = "track_discipline",
            joinColumns = @JoinColumn(name = "track_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    private List<Discipline> disciplines;

    public Track(Long id, String type, String shape, String surface, int length, int lanes, List<Discipline> disciplines) {
        this.id = id;
        this.type = type;
        this.shape = shape;
        this.surface = surface;
        this.length = length;
        Lanes = lanes;
        this.disciplines = disciplines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLanes() {
        return Lanes;
    }

    public void setLanes(int lanes) {
        Lanes = lanes;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}
