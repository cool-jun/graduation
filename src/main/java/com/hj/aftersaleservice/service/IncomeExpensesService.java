package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.IncomeExpenses;

import java.util.List;

public interface IncomeExpensesService {
    List<IncomeExpenses> listIncomeDetails(String income_word);

    List<IncomeExpenses> listExpenseDetails(String expense_word);
}
