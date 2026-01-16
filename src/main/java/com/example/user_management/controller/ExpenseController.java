package com.example.user_management.controller;

import com.example.user_management.dto.ManagerExpenseRequest;
import com.example.user_management.entity.Expense;
import com.example.user_management.enums.ExpenseStatus;
import com.example.user_management.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // Manager creates expense
    @PostMapping
    public Expense createExpense(@Valid @RequestBody ManagerExpenseRequest request) {
        return expenseService.createExpense(request);
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // Manager-only status update
    @PatchMapping("/{id}/status")
    public Expense updateStatus(
            @PathVariable Long id,
            @RequestParam ExpenseStatus status
    ) {
        return expenseService.updateExpenseStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
