package com.example.eksamen_backend.repository;

import com.example.eksamen_backend.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> { }
