package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.IncomeExpenses;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IncomeExpensesMapper {
    List<IncomeExpenses> listIncomeDetails(@Param(value = "income_word") String income_word);

    List<IncomeExpenses> listExpenseDetails(@Param(value = "expense_word") String expense_word);
}
