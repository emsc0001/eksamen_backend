package com.example.eksamen_backend.controller;

import com.example.eksamen_backend.model.TimeSlot;
import com.example.eksamen_backend.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/timeslots")
public class TimeSlotController {
    private final TimeSlotService timeSlotService;

    @Autowired
    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    @GetMapping("/{id}")
    public TimeSlot getTimeSlotById(@PathVariable Long id) {
        return timeSlotService.getTimeSlotById(id);
    }

    @PostMapping
    public TimeSlot createTimeSlot(@RequestBody TimeSlot timeSlot) {
        return timeSlotService.createTimeSlot(timeSlot);
    }

    @PostMapping("/{id}/events")
    public TimeSlot addEventsToTimeSlot(@PathVariable Long id, @RequestBody Set<Long> eventIds) {
        return timeSlotService.addEventsToTimeSlot(id, eventIds);
    }

    @DeleteMapping("/{id}/events/{eventId}")
    public TimeSlot removeEventFromTimeSlot(@PathVariable Long id, @PathVariable Long eventId) {
        return timeSlotService.removeEventFromTimeSlot(id, eventId);
    }

    @DeleteMapping("/{id}")
    public void deleteTimeSlot(@PathVariable Long id) {
        timeSlotService.deleteTimeSlot(id);
    }

    @GetMapping
    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotService.getAllTimeSlots();
    }

    @PostMapping("/{timeSlotId}/events")
    public ResponseEntity<?> linkEventToTimeSlot(@PathVariable Long timeSlotId, @RequestBody Long eventId) {
        try {
            timeSlotService.linkEventToTimeSlot(timeSlotId, eventId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to link event to time slot: " + e.getMessage());
        }
    }
}
