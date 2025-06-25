package com.financial.tracker.service;

import com.financial.tracker.dto.GoalTrackingDto;
import com.financial.tracker.entity.GoalTracking;
import com.financial.tracker.repository.GoalTrackingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GoalTrackingService {

    private final GoalTrackingRepository goalTrackingRepository;

    public GoalTrackingService(GoalTrackingRepository goalTrackingRepository) {
        this.goalTrackingRepository = goalTrackingRepository;
    }

    public GoalTracking createGoalTracking(String name, Double targetAmount, LocalDate deadLine) {
        GoalTracking goalTracking = new GoalTracking();
        goalTracking.setName(name);
        goalTracking.setTargetAmount(targetAmount);
        goalTracking.setDeadline(deadLine);
        goalTracking.setActive(true);
        return goalTrackingRepository.save(goalTracking);
    }

    public List<GoalTrackingDto> getAll() {
        List<GoalTracking> goalTrackingList = goalTrackingRepository.findAll();
        return goalTrackingList.stream().map(goalTracking -> {
            GoalTrackingDto goalTrackingDto = new GoalTrackingDto();
            goalTrackingDto.setName(goalTracking.getName());
            goalTrackingDto.setTargetAmount(goalTracking.getTargetAmount());
            goalTrackingDto.setDeadLine(goalTracking.getDeadline());
            return goalTrackingDto;
        }).toList();
    }
}
