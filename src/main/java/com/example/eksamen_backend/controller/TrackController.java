package com.example.eksamen_backend.controller;

import com.example.eksamen_backend.model.Track;
import com.example.eksamen_backend.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackController {

    @Autowired
    private TrackService trackService;

    // Allow CORS for this specific endpoint from http://localhost:5173
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public ResponseEntity<List<Track>> getAllTracks() {
        List<Track> tracks = trackService.getAllTracks();
        if (tracks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tracks);
    }
}
