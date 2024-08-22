package com.example.eksamen_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {
    private Long id;
    private String name;
    private String ageGroup;
    private String gender;
    private String discipline;
    private Long trackId;
    private int duration;
}