package com.hj.aftersaleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hj.aftersaleservice.domain.Outbound;
import com.hj.aftersaleservice.service.OutboundService;
import com.hj.aftersaleservice.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class OutboundController {
    @Resource
    private OutboundService outboundService;

    @RequestMapping(value = "/outboundlist")
    public String listOutbound(@RequestParam(value = "outbound_keyword", required = false) String outbound_keyword,
                               @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum,
                               Model model) {
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<Outbound> outboundList = outboundService.getAllOutboundList(outbound_keyword);
        PageInfo<Outbound> outboundPageInfo = new PageInfo<>(outboundList);

        model.addAttribute("outboundList", outboundPageInfo);

        return "stock/outbound";
    }
}
