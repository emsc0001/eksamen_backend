package com.example.eksamen_backend.controller;

import com.example.eksamen_backend.model.Event;
import com.example.eksamen_backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Allow CORS for this specific endpoint from http://localhost:5173
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        if (events.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(events);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.status(201).body(createdEvent);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
