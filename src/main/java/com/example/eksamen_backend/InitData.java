package com.example.eksamen_backend;

import com.example.eksamen_backend.enums.DisciplineEnum;
import com.example.eksamen_backend.enums.GenderEnum;
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
import java.util.Arrays;

@Configuration
public class InitData {

    @Bean
    CommandLineRunner initialData(DisciplineRepository disciplineRepository,
                                  TrackRepository trackRepository,
                                  TimeSlotRepository timeSlotRepository,
                                  EventRepository eventRepository) {
        return args -> {

            // Create some disciplines
            Discipline sprint = new Discipline("Sprint", 10);
            Discipline relay = new Discipline("Relay", 15);
            Discipline highJump = new Discipline("High Jump", 20);
            disciplineRepository.saveAll(Arrays.asList(sprint, relay, highJump));

            // Create some tracks
            Track track1 = new Track("Track", "Oval", "Synthetic", 400, 8);
            Track track2 = new Track("Track", "Straight", "Grass", 100, 6);
            track1.setDisciplines(Arrays.asList(sprint, relay));
            track2.setDisciplines(Arrays.asList(sprint));
            trackRepository.saveAll(Arrays.asList(track1, track2));

            // Create some time slots
            TimeSlot timeSlot1 = new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusHours(1));
            TimeSlot timeSlot2 = new TimeSlot(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3));
            timeSlotRepository.saveAll(Arrays.asList(timeSlot1, timeSlot2));

            // Create some events without maxParticipants
            Event event1 = new Event("Sprint Event", "Adult", GenderEnum.MALE, 10, DisciplineEnum.SPRINT, track1, timeSlot1);
            Event event2 = new Event("Relay Event", "Youth", GenderEnum.FEMALE, 15, DisciplineEnum.RELAY, track1, timeSlot2);
            eventRepository.saveAll(Arrays.asList(event1, event2));
        };
    }
}
