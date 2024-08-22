package com.example.eksamen_backend;

import com.example.eksamen_backend.model.Discipline;
import com.example.eksamen_backend.model.Track;
import com.example.eksamen_backend.repository.DisciplineRepository;
import com.example.eksamen_backend.repository.TrackRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class InitData {

    @Bean
    CommandLineRunner initDatabase(TrackRepository trackRepository, DisciplineRepository disciplineRepository) {
        return args -> {
            Discipline discipline1 = new Discipline("100 meters");
            Discipline discipline2 = new Discipline("200 meters");
            disciplineRepository.save(discipline1);
            disciplineRepository.save(discipline2);

            Set<Discipline> disciplines = new HashSet<>();
            disciplines.add(discipline1);
            disciplines.add(discipline2);

            trackRepository.save(new Track("Track A", 8, 400, disciplines));
            trackRepository.save(new Track("Track B", 6, 200, disciplines));
        };
    }
}
