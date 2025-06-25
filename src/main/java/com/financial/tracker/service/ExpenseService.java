package com.financial.tracker.service;

import com.financial.tracker.dto.ExpenseDto;
import com.financial.tracker.entity.Expense;
import com.financial.tracker.entity.ExpenseCategory;
import com.financial.tracker.repository.ExpenseCategoryRepository;
import com.financial.tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseCategoryRepository expenseCategoryRepository, ExpenseRepository expenseRepository) {
        this.expenseCategoryRepository = expenseCategoryRepository;
        this.expenseRepository = expenseRepository;
    }

    public Expense createExpense(ExpenseDto expenseDto) {
        ExpenseCategory category = expenseCategoryRepository.findById(expenseDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category Not Found!"));

        Expense expense = new Expense();
        expense.setCategory(category);
        expense.setDescription(expenseDto.getDescription());
        expense.setAmount(expenseDto.getAmount());
        expense.setExpenseDate(expenseDto.getExpenseDate());
        return expenseRepository.save(expense);
    }

    public List<ExpenseDto> getAll() {
        List<Expense> expenseList = expenseRepository.findAll();

        return expenseList.stream().map(expense -> {
                    ExpenseDto expenseDto = new ExpenseDto();
                    expenseDto.setDescription(expense.getDescription());
                    expenseDto.setExpenseDate(expense.getExpenseDate());
                    expenseDto.setAmount(expense.getAmount());
                    expenseDto.setCategoryId(expense.getCategory().getId());
                    return expenseDto;
                }
        ).toList();

    }
}
