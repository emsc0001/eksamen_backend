package com.example.eksamen_backend.model;

import jakarta.persistence.*;

@Entity
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer approxDuration;

    public Discipline() {}

    public Discipline(String name, Integer approxDuration) {
        this.name = name;
        this.approxDuration = approxDuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getApproxDuration() {
        return approxDuration;
    }

    public void setApproxDuration(Integer approxDuration) {
        this.approxDuration = approxDuration;
    }
}
