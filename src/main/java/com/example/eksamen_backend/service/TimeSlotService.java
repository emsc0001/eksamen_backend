package com.example.eksamen_backend.service;

import com.example.eksamen_backend.exception.ResourceNotFoundException;
import com.example.eksamen_backend.model.TimeSlot;
import com.example.eksamen_backend.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;

    public TimeSlotService(TimeSlotRepository timeSlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
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

    public void deleteTimeSlot(Long timeSlotId) {
        TimeSlot timeSlot = timeSlotRepository.findById(timeSlotId)
                .orElseThrow(() -> new ResourceNotFoundException("TimeSlot not found"));
        timeSlotRepository.delete(timeSlot);
    }
}