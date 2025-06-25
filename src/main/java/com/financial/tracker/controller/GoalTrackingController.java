package com.financial.tracker.controller;

import com.financial.tracker.dto.GoalTrackingDto;
import com.financial.tracker.service.GoalTrackingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goal-tracking")
public class GoalTrackingController {

    private final GoalTrackingService goalTrackingService;

    public GoalTrackingController(GoalTrackingService goalTrackingService) {
        this.goalTrackingService = goalTrackingService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createGoalTracking(@RequestBody GoalTrackingDto trackingDto) {
        return ResponseEntity.ok(goalTrackingService.createGoalTracking(trackingDto.getName(), trackingDto.getTargetAmount(), trackingDto.getDeadLine()));
    }

    @GetMapping("getAll")
    public ResponseEntity<List<GoalTrackingDto>> getAllGoalTracking() {
        return ResponseEntity.ok(goalTrackingService.getAll());
    }
}
