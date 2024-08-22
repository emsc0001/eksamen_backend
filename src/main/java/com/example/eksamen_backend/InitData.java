package com.example.eksamen_backend;

import com.example.eksamen_backend.model.Discipline;
import com.example.eksamen_backend.model.Event;
import com.example.eksamen_backend.model.TimeSlot;
import com.example.eksamen_backend.model.Track;
import com.example.eksamen_backend.repository.DisciplineRepository;
import com.example.eksamen_backend.repository.EventRepository;
import com.example.eksamen_backend.repository.TimeSlotRepository;
import com.example.eksamen_backend.repository.TrackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Collections;

@Configuration
public class InitData {

    @Bean
    CommandLineRunner initializeData(EventRepository eventRepository, DisciplineRepository disciplineRepository, TrackRepository trackRepository, TimeSlotRepository timeSlotRepository) {
        return args -> {
            // Opret nogle dummy data for Discipline, Track, og TimeSlot
            Discipline discipline1 = new Discipline("100m Dash");
            disciplineRepository.save(discipline1);

            Discipline discipline2 = new Discipline("200m Dash");
            disciplineRepository.save(discipline2);

            Track track1 = new Track("Main Track", 8, 400, Collections.singleton(discipline1));
            trackRepository.save(track1);

            Track track2 = new Track("Secondary Track", 6, 200, Collections.singleton(discipline2));
            trackRepository.save(track2);

            TimeSlot timeSlot1 = new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
            timeSlotRepository.save(timeSlot1);

            TimeSlot timeSlot2 = new TimeSlot(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3));
            timeSlotRepository.save(timeSlot2);

            // Opret Events med ovenstående data
            Event event1 = new Event(10, "M", "Adult", 8, discipline1, track1, timeSlot1);
            eventRepository.save(event1);

            Event event2 = new Event(15, "F", "Youth", 12, discipline2, track2, timeSlot2);
            eventRepository.save(event2);

            System.out.println("Dummy data initialized");
        };
    }
}