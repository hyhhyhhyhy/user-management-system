package com.example.user_management.service.impl;

import com.example.user_management.dto.ManagerExpenseRequest;
import com.example.user_management.entity.Expense;
import com.example.user_management.entity.User;
import com.example.user_management.enums.ExpenseStatus;
import com.example.user_management.exception.ResourceNotFoundException;
import com.example.user_management.repository.ExpenseRepository;
import com.example.user_management.repository.UserRepository;
import com.example.user_management.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository,
                              UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Expense createExpense(ManagerExpenseRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Expense expense = Expense.builder()
                .amount(request.getAmount())
                .category(request.getCategory())
                .expenseDate(request.getExpenseDate())
                .status(ExpenseStatus.NOT_APPROVED)
                .user(user)
                .build();

        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
    }

    @Override
    public Expense updateExpenseStatus(Long id, ExpenseStatus status) {
        Expense expense = getExpenseById(id);
        expense.setStatus(status);
        return expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.delete(getExpenseById(id));
    }
}
