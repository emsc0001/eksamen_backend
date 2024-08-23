package com.example.eksamen_backend.service;

import com.example.eksamen_backend.exception.ResourceNotFoundException;
import com.example.eksamen_backend.model.Event;
import com.example.eksamen_backend.model.TimeSlot;
import com.example.eksamen_backend.repository.EventRepository;
import com.example.eksamen_backend.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;
    private final EventRepository eventRepository;

    public TimeSlotService(TimeSlotRepository timeSlotRepository, EventRepository eventRepository) {
        this.timeSlotRepository = timeSlotRepository;
        this.eventRepository = eventRepository;
    }

    public TimeSlot createTimeSlot(TimeSlot timeSlot) {
        // Add logic to prevent double booking
        List<TimeSlot> overlappingSlots = timeSlotRepository.findAll().stream()
                .filter(slot -> slot.getStartTime().isBefore(timeSlot.getEndTime()) &&
                        slot.getEndTime().isAfter(timeSlot.getStartTime()))
                .collect(Collectors.toList());

        if (!overlappingSlots.isEmpty()) {
            throw new IllegalArgumentException("The selected time slot overlaps with another time slot.");
        }
        return timeSlotRepository.save(timeSlot);
    }

    public List<TimeSlot> getAllTimeSlots() {
        return timeSlotRepository.findAll();
    }

    public TimeSlot getTimeSlotById(Long id) {
        return timeSlotRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TimeSlot not found"));
    }

    public TimeSlot addEventsToTimeSlot(Long timeSlotId, Set<Long> eventIds) {
        TimeSlot timeSlot = getTimeSlotById(timeSlotId);
        Set<Event> events = eventIds.stream()
                .map(eventId -> eventRepository.findById(eventId)
                        .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + eventId)))
                .collect(Collectors.toSet());

        timeSlot.getEvents().addAll(events);
        return timeSlotRepository.save(timeSlot);
    }

    public TimeSlot removeEventFromTimeSlot(Long timeSlotId, Long eventId) {
        TimeSlot timeSlot = getTimeSlotById(timeSlotId);
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + eventId));

        timeSlot.getEvents().remove(event);
        return timeSlotRepository.save(timeSlot);
    }

    public void deleteTimeSlot(Long timeSlotId) {
        TimeSlot timeSlot = timeSlotRepository.findById(timeSlotId)
                .orElseThrow(() -> new ResourceNotFoundException("TimeSlot not found"));
        timeSlotRepository.delete(timeSlot);
    }

    public void linkEventToTimeSlot(Long timeSlotId, Long eventId) {
        TimeSlot timeSlot = getTimeSlotById(timeSlotId);
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with ID: " + eventId));

        timeSlot.addEvent(event);
        timeSlotRepository.save(timeSlot);
    }
}
