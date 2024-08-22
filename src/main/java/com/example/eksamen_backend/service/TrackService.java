package com.example.eksamen_backend.service;

import com.example.eksamen_backend.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {
    @Autowired
    private TrackRepository trackRepository;
}
