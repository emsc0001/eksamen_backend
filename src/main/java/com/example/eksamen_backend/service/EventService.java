package com.example.eksamen_backend.service;

import com.example.eksamen_backend.model.Event;
import com.example.eksamen_backend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event eventDetails) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        event.setName(eventDetails.getName());
        event.setDiscipline(eventDetails.getDiscipline());
        event.setTrack(eventDetails.getTrack());
        event.setDuration(eventDetails.getDuration());
        event.setMaxParticipants(eventDetails.getMaxParticipants());

        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        eventRepository.delete(event);
    }
}
