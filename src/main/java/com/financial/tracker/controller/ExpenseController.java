package com.financial.tracker.controller;

import com.financial.tracker.dto.ExpenseDto;
import com.financial.tracker.entity.Expense;
import com.financial.tracker.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createExpense(@RequestBody ExpenseDto expenseDto) {
        return ResponseEntity.ok(expenseService.createExpense(expenseDto));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ExpenseDto>> getAll() {
        return ResponseEntity.ok(expenseService.getAll());
    }
}
