package com.financial.tracker.service;

import com.financial.tracker.entity.ExpenseCategory;
import com.financial.tracker.repository.ExpenseCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    public ExpenseCategoryService(ExpenseCategoryRepository expenseCategoryRepository) {
        this.expenseCategoryRepository = expenseCategoryRepository;
    }

    public ExpenseCategory createExpenseCategory(String name) {
        if (expenseCategoryRepository.existsByName(name)) {
            throw new RuntimeException("Expense category already exists!");
        }

        ExpenseCategory category = new ExpenseCategory();
        category.setName(name);
        category.setActive(true);

        return expenseCategoryRepository.save(category);
    }

    public List<ExpenseCategory> getAll() {
        return expenseCategoryRepository.findAll();
    }
}
