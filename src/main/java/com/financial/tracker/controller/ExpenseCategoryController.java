package com.financial.tracker.controller;

import com.financial.tracker.entity.ExpenseCategory;
import com.financial.tracker.service.ExpenseCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class ExpenseCategoryController {

    private final ExpenseCategoryService expenseCategoryService;

    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<ExpenseCategory> createCategory(@RequestBody String name) {
        return ResponseEntity.ok(expenseCategoryService.createExpenseCategory(name));
    }
}
