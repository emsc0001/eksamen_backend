package com.example.eksamen_backend.repository;

import com.example.eksamen_backend.model.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<Timeslot, Long> { }
