package com.example.eksamen_backend.repository;


import com.example.eksamen_backend.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
