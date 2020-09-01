package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.IncomeExpensesMapper;
import com.hj.aftersaleservice.domain.IncomeExpenses;
import com.hj.aftersaleservice.service.IncomeExpensesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IncomeExpensesServiceImpl implements IncomeExpensesService {
    @Resource
    private IncomeExpensesMapper incomeExpensesMapper;

    @Override
    public List<IncomeExpenses> listIncomeDetails(String income_word) {
        return incomeExpensesMapper.listIncomeDetails(income_word);
    }

    @Override
    public List<IncomeExpenses> listExpenseDetails(String expense_word) {
        return incomeExpensesMapper.listExpenseDetails(expense_word);
    }
}
