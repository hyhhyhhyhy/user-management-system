package com.example.user_management.dto;

import com.example.user_management.enums.ExpenseCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ManagerExpenseRequest {

    @NotNull
    private Long userId;

    @Positive
    private Double amount;

    @NotNull
    private ExpenseCategory category;

    @NotNull
    private LocalDate expenseDate;
}
