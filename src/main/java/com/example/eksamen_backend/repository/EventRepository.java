package com.example.eksamen_backend.repository;

import com.example.eksamen_backend.model.Event;
import com.example.eksamen_backend.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByTimeSlot(TimeSlot timeSlot);
}
