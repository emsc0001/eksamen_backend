package com.example.eksamen_backend;

import com.example.eksamen_backend.model.Event;
import com.example.eksamen_backend.model.Track;
import com.example.eksamen_backend.model.TimeSlot;
import com.example.eksamen_backend.enums.DisciplineEnum;
import com.example.eksamen_backend.repository.EventRepository;
import com.example.eksamen_backend.repository.TrackRepository;
import com.example.eksamen_backend.repository.TimeSlotRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitData {

    @Bean
    CommandLineRunner initialData(EventRepository eventRepository, TrackRepository trackRepository, TimeSlotRepository timeSlotRepository) {
        return args -> {
            // Create sample Track and TimeSlot objects
            Track track = new Track("Track 1", 8, 400);
            trackRepository.save(track);

            TimeSlot timeSlot = new TimeSlot("09:00-10:00");
            timeSlotRepository.save(timeSlot);

            // Create Event objects with Track and TimeSlot
            Event event1 = new Event("Sample Event 1", 60, 100, DisciplineEnum.SWIMMING, track, timeSlot);
            Event event2 = new Event("Sample Event 2", 90, 150, DisciplineEnum.HIGH_JUMP, track, timeSlot);

            eventRepository.save(event1);
            eventRepository.save(event2);
        };
    }
}