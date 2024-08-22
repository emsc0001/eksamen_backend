package com.example.eksamen_backend.service;

import com.example.eksamen_backend.model.Event;
import com.example.eksamen_backend.model.Track;
import com.example.eksamen_backend.repository.EventRepository;
import com.example.eksamen_backend.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    private final TrackRepository trackRepository;

    public EventService(EventRepository eventRepository, TrackRepository trackRepository) {
        this.eventRepository = eventRepository;
        this.trackRepository = trackRepository;
    }

    public Event createEvent(Event event) {
        Track track = trackRepository.findById(event.getTrack().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid track ID"));

        if (!track.getDisciplines().contains(event.getDiscipline())) {
            throw new IllegalArgumentException("Track is not compatible with the chosen discipline.");
        }

        if (isTimeSlotOverlapping(event)) {
            throw new IllegalArgumentException("The selected time slot overlaps with another event on the same track.");
        }

        return eventRepository.save(event);
    }

    private boolean isTimeSlotOverlapping(Event event) {
        List<Event> eventsOnSameTrack = eventRepository.findAll(); // Adjust to fetch only events on the same track
        for (Event existingEvent : eventsOnSameTrack) {
            if (existingEvent.getTrack().equals(event.getTrack()) &&
                    existingEvent.getTimeSlot().getStartTime().isBefore(event.getTimeSlot().getEndTime()) &&
                    existingEvent.getTimeSlot().getEndTime().isAfter(event.getTimeSlot().getStartTime())) {
                return true;
            }
        }
        return false;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
