package com.example.eksamen_backend.controller;

import com.example.eksamen_backend.dto.EventDTO;
import com.example.eksamen_backend.enums.DisciplineEnum;
import com.example.eksamen_backend.enums.GenderEnum;
import com.example.eksamen_backend.model.Event;
import com.example.eksamen_backend.model.Track;
import com.example.eksamen_backend.repository.TrackRepository;
import com.example.eksamen_backend.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;
    private final TrackRepository trackRepository;

    @Autowired
    public EventController(EventService eventService, TrackRepository trackRepository) {
        this.eventService = eventService;
        this.trackRepository = trackRepository;
    }


    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventDTO eventDTO) {
        // Fetch the track using the track ID from the eventDTO
        Track track = trackRepository.findById(eventDTO.getTrackId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid track ID"));

        // Convert EventDTO to Event object
        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setParticipantAgeGroup(eventDTO.getAgeGroup());
        event.setParticipantGender(GenderEnum.valueOf(eventDTO.getGender()));
        event.setDiscipline(DisciplineEnum.valueOf(eventDTO.getDiscipline()));
        event.setTrack(track);

        // Save the event
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.ok(createdEvent);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.updateEvent(id, eventDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
