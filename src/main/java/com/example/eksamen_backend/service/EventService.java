package com.example.eksamen_backend.service;

import com.example.eksamen_backend.dto.EventDTO;
import com.example.eksamen_backend.enums.DisciplineEnum;
import com.example.eksamen_backend.enums.GenderEnum;
import com.example.eksamen_backend.model.Event;
import com.example.eksamen_backend.model.Track;
import com.example.eksamen_backend.repository.EventRepository;
import com.example.eksamen_backend.repository.TrackRepository;
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

        // Save the event to the database
        return eventRepository.save(event);
    }


    public Event updateEvent(Long id, EventDTO eventDTO) {
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        // Update the fields accordingly
        existingEvent.setName(eventDTO.getName());
        existingEvent.setParticipantAgeGroup(eventDTO.getAgeGroup());
        existingEvent.setParticipantGender(GenderEnum.valueOf(eventDTO.getGender()));
        existingEvent.setDiscipline(DisciplineEnum.valueOf(eventDTO.getDiscipline()));
        existingEvent.setTrack(trackRepository.findById(eventDTO.getTrackId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid track ID")));

        return eventRepository.save(existingEvent);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
