package com.example.eksamen_backend.controller;

import com.example.eksamen_backend.model.Track;
import com.example.eksamen_backend.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackController {
    @Autowired
    private TrackRepository trackRepository;

    @GetMapping
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
}
