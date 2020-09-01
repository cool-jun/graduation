package com.hj.aftersaleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hj.aftersaleservice.domain.StockCheck;
import com.hj.aftersaleservice.service.StockCheckService;
import com.hj.aftersaleservice.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class StockCheckController {
    @Resource
    private StockCheckService stockCheckService;

    @RequestMapping(value = "/stocklist")
    public String listStockCheck(Model model, @RequestParam(value = "keyword", required = false) String keyword,
                                 @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum) {

        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<StockCheck> stockCheckList = stockCheckService.getAllStockCheckList(keyword);
        PageInfo<StockCheck> stockCheckPageInfo = new PageInfo<>(stockCheckList);

        model.addAttribute("stockCheckList", stockCheckPageInfo);

        return "stock/stockchecklist";
    }
}
