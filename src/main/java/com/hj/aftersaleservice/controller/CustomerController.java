package com.hj.aftersaleservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hj.aftersaleservice.domain.Customer;
import com.hj.aftersaleservice.utils.Constants;
import com.hj.aftersaleservice.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {
    @Resource
    private CustomerService customerService;

    /**
     * 根据条件查询所有客户信息
     */
    @RequestMapping("/customerinfolist")
    public String listCustomer(Model model,
                               @RequestParam(value = "customer_name", required = false) String customer_name,
                               @RequestParam(value = "telephone", required = false) String telephone,
                               @RequestParam(value = "area", required = false) String area,
                               @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum) {
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<Customer> customerList = customerService.getAllCustomerList(customer_name, telephone, area);
        PageInfo<Customer> customerPageInfo = new PageInfo<>(customerList);

        model.addAttribute("customerList", customerPageInfo);
        model.addAttribute("customer_name", customer_name);
        model.addAttribute("telephone", telephone);
        model.addAttribute("area", area);

        return "customer/customerlist";
    }

    @RequestMapping("/toaddcustomer")
    public String toAddCustomerInfo() {
        return "customer/customeradd";
    }

    /**
     * 根据id删除客户信息
     */
    @RequestMapping("/deletecustomer")
    @ResponseBody
    public Object deleteCustomer(@RequestParam String customer_id) {
        HashMap<String, String> resultMap = new HashMap<>();
        if (customer_id == null || customer_id.equals("")) {
            resultMap.put("deleteResult", "notExist");
        } else {
            try {
                if (customerService.deleteCustomerById(Integer.parseInt(customer_id))) {
                    resultMap.put("deleteResult", "deleteSuccess");
                } else {
                    resultMap.put("deleteResult", "deleteFailure");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSONArray.toJSONString(resultMap);
    }

    /**
     * 根据id查看客户信息
     */
    @RequestMapping(value = "/showcustomer", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object showCustomer(@RequestParam String customer_id) {
        Customer customer = customerService.showCustomerById(Integer.parseInt(customer_id));
        Map<String, Object> map = new HashMap<>();
        map.put("show_customer", customer);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/tocustomermodify")
    public String toCustomerModify(@RequestParam("customer_id") String customer_id, Model model) {
        Customer customerInfo;
        customerInfo = customerService.getCustomerById(Integer.parseInt(customer_id));
        model.addAttribute("customerInfo", customerInfo);
        return "customer/customermodify";
    }

    /**
     * 修改客户信息
     */
    @RequestMapping(value = "/modifycustomer", method = RequestMethod.POST)
    public void modifyCustomer(@ModelAttribute Customer customer, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            if (customerService.modifyCustomer(customer)) {
                out.print("<script type=\"text/javascript\">alert('修改成功!');window.location.href='customerinfolist'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('修改失败，请重试!');window.location.href='toaddcustomer'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增客户信息
     */
    @RequestMapping(value = "/customerinfoadd", method = RequestMethod.POST)
    public void addCustomer(@ModelAttribute Customer customer, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            if (customerService.addCustomerInfo(customer)) {
                out.print("<script type=\"text/javascript\">alert('新增成功!');window.location.href='customerinfolist'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('新增失败，请重试!');window.location.href='customerinfolist'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
