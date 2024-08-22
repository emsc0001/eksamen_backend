package com.example.eksamen_backend.model;

import com.example.eksamen_backend.enums.DisciplineEnum;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int lanes;
    private int length;

    @ElementCollection(targetClass = DisciplineEnum.class)
    @Enumerated(EnumType.STRING)
    private List<DisciplineEnum> supportedDisciplines;

    // Constructors
    public Track() {}

    public Track(String name, int lanes, int length) {
        this.name = name;
        this.lanes = lanes;
        this.length = length;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLanes() {
        return lanes;
    }

    public int getLength() {
        return length;
    }

    public List<DisciplineEnum> getSupportedDisciplines() {
        return supportedDisciplines;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanes(int lanes) {
        this.lanes = lanes;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSupportedDisciplines(List<DisciplineEnum> supportedDisciplines) {
        this.supportedDisciplines = supportedDisciplines;
    }
}