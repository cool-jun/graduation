package com.hj.aftersaleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hj.aftersaleservice.domain.IncomeExpenses;
import com.hj.aftersaleservice.service.IncomeExpensesService;
import com.hj.aftersaleservice.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IncomeExpensesController {
    @Resource
    private IncomeExpensesService incomeExpensesService;

    @RequestMapping(value = "/incomedetails")
    public String listIncomeDetails(@RequestParam(value = "income_word", required = false) String income_word,
                                    @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum,
                                    Model model) {
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<IncomeExpenses> incomeList = incomeExpensesService.listIncomeDetails(income_word);
        PageInfo<IncomeExpenses> incomeExpensesPageInfo = new PageInfo<>(incomeList);

        model.addAttribute("incomeList", incomeExpensesPageInfo);

        return "finance/incomedetails";
    }

    @RequestMapping(value = "/expensedetails")
    public String listExpenseDetails(@RequestParam(value = "expense_word", required = false) String expense_word,
                                     @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum,
                                     Model model) {
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<IncomeExpenses> expenseList = incomeExpensesService.listExpenseDetails(expense_word);
        PageInfo<IncomeExpenses> incomeExpensesPageInfo = new PageInfo<>(expenseList);

        model.addAttribute("expenseList", incomeExpensesPageInfo);

        return "finance/expensedetails";
    }
}
