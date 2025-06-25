package com.financial.tracker.controller;

import com.financial.tracker.dto.ExpenseCategoryDto;
import com.financial.tracker.entity.ExpenseCategory;
import com.financial.tracker.service.ExpenseCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ExpenseCategoryController {

    private final ExpenseCategoryService expenseCategoryService;

    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<ExpenseCategory> createCategory(@RequestBody ExpenseCategoryDto expenseCategoryDto) {
        return ResponseEntity.ok(expenseCategoryService.createExpenseCategory(expenseCategoryDto.getName()));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ExpenseCategory>> getAll(){
        return ResponseEntity.ok(expenseCategoryService.getAll());
    }
}
