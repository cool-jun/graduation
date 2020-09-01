package com.hj.aftersaleservice.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hj.aftersaleservice.domain.Inbound;
import com.hj.aftersaleservice.domain.StockCheck;
import com.hj.aftersaleservice.service.InboundService;
import com.hj.aftersaleservice.service.StockCheckService;
import com.hj.aftersaleservice.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@Controller
public class InboundController {
    @Resource
    private InboundService inboundService;

    @Resource
    private StockCheckService stockCheckService;

    @RequestMapping(value = "/toinboundadd")
    public String toInboundAdd() {
        return "stock/inboundadd";
    }

    @RequestMapping(value = "/inboundinfolist")
    public String listStockIn(@RequestParam(value = "counterpart", required = false) String counterpart,
                              @RequestParam(value = "operator", required = false) String operator,
                              @RequestParam(value = "inbound_time", required = false) String inbound_time,
                              @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum,
                              Model model) {
        List<Inbound> inboundList;
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        inboundList = inboundService.getAllInboundList(counterpart, operator, inbound_time);
        PageInfo<Inbound> inboundPageInfo = new PageInfo<>(inboundList);

        model.addAttribute("inboundList", inboundPageInfo);
        model.addAttribute("counterpart", counterpart);
        model.addAttribute("operator", operator);
        model.addAttribute("inbound_time", inbound_time);

        return "stock/inboundlist";
    }

    /**
     * 新增入库记录
     */
    @RequestMapping(value = "/inboundinfoadd", method = RequestMethod.POST)
    public void addInbound(@ModelAttribute Inbound inbound, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        StockCheck stockCheck = new StockCheck(inbound.getProduct_name(), inbound.getProduct_spec(), inbound.getAmount());
        try {
            PrintWriter out = response.getWriter();
            if (inboundService.addInboundInfo(inbound) && stockCheckService.addCurrentStock(stockCheck)) {
                out.print("<script type=\"text/javascript\">alert('新增成功!');window.location.href='inboundinfolist'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('新增失败，请重试!');window.location.href='inboundinfolist'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据id删除入库记录
     */
    @RequestMapping(value = "/deleteinbound")
    @ResponseBody
    public Object deleteInbound(@RequestParam String inbound_id) {
        HashMap<String, String> resultMap = new HashMap<>();
        if (inbound_id == null || inbound_id.equals("")) {
            resultMap.put("inboundDeleteResult", "notExist");
        } else {
            try {
                if (inboundService.deleteInboundById(Integer.parseInt(inbound_id))) {
                    resultMap.put("inboundDeleteResult", "deleteSuccess");
                } else {
                    resultMap.put("inboundDeleteResult", "deleteFailure");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping(value = "/toinboundmodify")
    public String toInboundModify(@RequestParam("inbound_id") String inbound_id, Model model) {
        Inbound inboundInfo;
        inboundInfo = inboundService.getInboundById(Integer.parseInt(inbound_id));
        model.addAttribute("inboundInfo", inboundInfo);
        return "stock/inboundmodify";
    }

    /**
     * 修改入库记录
     */
    @RequestMapping(value = "/modifyinbound", method = RequestMethod.POST)
    public void modifyInbound(@ModelAttribute Inbound inbound, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            System.out.println(inbound.toString());
            System.out.println(inbound.getCounterpart());
            System.out.println(inbound.getInbound_way());
            PrintWriter out = response.getWriter();
            if (inboundService.modifyInbound(inbound)) {
                out.print("<script type=\"text/javascript\">alert('修改成功!');window.location.href='inboundinfolist'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('修改失败，请重试!');window.location.href='inboundinfolist'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
