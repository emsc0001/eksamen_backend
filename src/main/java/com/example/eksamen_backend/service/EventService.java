package com.example.eksamen_backend.service;

import com.example.eksamen_backend.model.Event;
import com.example.eksamen_backend.repository.EventRepository;
import com.example.eksamen_backend.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository;
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    public EventService(EventRepository eventRepository, TimeSlotRepository timeSlotRepository) {
        this.eventRepository = eventRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

}