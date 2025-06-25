package com.financial.tracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Expense extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Double amount;

    private String description;

    @OneToMany
    @JoinColumn(name = "category_id", nullable = false)
    private ExpenseCategory category;

    private LocalDate expenseDate;
}
