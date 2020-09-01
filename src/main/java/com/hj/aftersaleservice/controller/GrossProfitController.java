package com.hj.aftersaleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hj.aftersaleservice.domain.GrossProfit;
import com.hj.aftersaleservice.service.GrossProfitService;
import com.hj.aftersaleservice.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class GrossProfitController {
    @Resource
    private GrossProfitService grossProfitService;

    @RequestMapping(value = "/listgrossprofit")
    public String listAllGrossProfit(@RequestParam(value = "profit_word", required = false) String profit_word,
                                     @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum,
                                     Model model) {
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<GrossProfit> grossProfitList = grossProfitService.listAllGrossProfit(profit_word);
        PageInfo<GrossProfit> grossProfitPageInfo = new PageInfo<>(grossProfitList);

        model.addAttribute("grossProfitList", grossProfitPageInfo);

        return "finance/grossprofit";
    }
}
