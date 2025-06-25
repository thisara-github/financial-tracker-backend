package com.financial.tracker.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GoalTrackingDto {

    private String name;

    private Double targetAmount;

    private LocalDate deadLine;
}
