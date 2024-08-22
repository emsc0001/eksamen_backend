package com.example.eksamen_backend.repository;

import com.example.eksamen_backend.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> { }
