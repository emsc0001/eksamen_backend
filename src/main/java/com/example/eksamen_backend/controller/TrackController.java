package com.example.eksamen_backend.controller;

import com.example.eksamen_backend.model.Track;
import com.example.eksamen_backend.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Track>> getAllTracks() {
        try {
            List<Track> tracks = trackRepository.findAll();
            return new ResponseEntity<>(tracks, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
