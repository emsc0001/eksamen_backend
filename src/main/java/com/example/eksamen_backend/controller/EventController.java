package com.example.eksamen_backend.controller;

import com.example.eksamen_backend.dto.EventDTO;
import com.example.eksamen_backend.enums.DisciplineEnum;
import com.example.eksamen_backend.enums.GenderEnum;
import com.example.eksamen_backend.model.Event;
import com.example.eksamen_backend.model.TimeSlot;
import com.example.eksamen_backend.model.Track;
import com.example.eksamen_backend.repository.TrackRepository;
import com.example.eksamen_backend.service.EventService;
import com.example.eksamen_backend.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;
    private final TrackRepository trackRepository;
    private final TimeSlotService timeSlotService;

    @Autowired
    public EventController(EventService eventService, TrackRepository trackRepository, TimeSlotService timeSlotService) {
        this.eventService = eventService;
        this.trackRepository = trackRepository;
        this.timeSlotService = timeSlotService;
    }


    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody EventDTO eventDTO) {
        try {
            // Fetch the track using the track ID from the eventDTO
            Track track = trackRepository.findById(eventDTO.getTrackId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid track ID"));

            // Convert EventDTO to Event object
            Event event = new Event();
            event.setName(eventDTO.getName());
            event.setParticipantGender(GenderEnum.valueOf(eventDTO.getGender().toUpperCase()));
            event.setDiscipline(DisciplineEnum.valueOf(eventDTO.getDiscipline().toUpperCase()));
            event.setTrack(track);

            // Save the event
            Event createdEvent = eventService.createEvent(event);
            return ResponseEntity.ok(createdEvent);

        } catch (Exception e) {
            // Log the error and return a response with the error message
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating event: " + e.getMessage());
        }
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
