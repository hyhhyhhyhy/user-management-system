package com.example.user_management.service;

import com.example.user_management.dto.ManagerExpenseRequest;
import com.example.user_management.entity.Expense;
import com.example.user_management.enums.ExpenseStatus;

import java.util.List;

public interface ExpenseService {
    Expense createExpense(ManagerExpenseRequest request);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpenseStatus(Long id, ExpenseStatus status);
    void deleteExpense(Long id);
}
