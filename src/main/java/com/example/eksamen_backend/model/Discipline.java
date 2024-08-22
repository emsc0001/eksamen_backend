package com.example.eksamen_backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}
