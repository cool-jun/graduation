package com.hj.aftersaleservice.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hj.aftersaleservice.domain.*;
import com.hj.aftersaleservice.service.*;
import com.hj.aftersaleservice.utils.Constants;
import com.hj.aftersaleservice.utils.OrderNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SaleController {
    @Resource
    private CustomerService customerService;

    @Resource
    private UserLoginService userLoginService;

    @Resource
    private ProductService productService;

    @Resource
    private SaleService saleService;

    @Resource
    private OutboundService outboundService;

    @Resource
    private StockCheckService stockCheckService;

    @RequestMapping("/tosaleadd")
    public String toSaleAdd() {
        return "sale/saleadd";
    }

    @RequestMapping("/tomain")
    public String toMain() {
        return "main";
    }

    /**
     * 根据条件查询销售记录
     */
    @RequestMapping(value = "/saleinfolist")
    public String listSale(Model model, @RequestParam(value = "keywords", required = false) String keywords,
                           @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum) {
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<Sale> saleList = saleService.getAllSaleList(keywords);
        PageInfo<Sale> salePageInfo = new PageInfo<>(saleList);

        model.addAttribute("saleList", salePageInfo);
        model.addAttribute("keywords", keywords);

        return "sale/salelist";
    }

    /**
     * 销售记录及客户记录增加
     */
    @RequestMapping(value = "/addsale", method = RequestMethod.POST)
    public void addSale(@RequestParam("customer_name") String customer_name,
                        @RequestParam("telephone") String telephone,
                        @RequestParam("address") String address,
                        @RequestParam("area") String area,
                        @RequestParam("product_name") String product_name,
                        @RequestParam("product_spec") String product_spec,
                        @RequestParam("price") String sale_price,
                        @RequestParam("number") String number,
                        @RequestParam("money") String sale_money,
                        @RequestParam("sale_type") String sale_type,
                        @RequestParam("service_status") String service_status,
                        @RequestParam("sponsor") String sponsor,
                        @RequestParam("sale_person") String sale_person,
                        @RequestParam("sale_date") String sale_date,
                        HttpServletResponse response) {
        BigDecimal price = new BigDecimal(sale_price);
        BigDecimal money = new BigDecimal(sale_money);
        price = price.setScale(2, BigDecimal.ROUND_DOWN);
        money = money.setScale(2, BigDecimal.ROUND_DOWN);

        //生成唯一的16位订单号
        String sale_number = OrderNumber.getOrderIdByUUID();

        Customer customer = new Customer(customer_name, telephone, address, area, sale_type, service_status, sponsor);
        Sale sale = new Sale(customer_name, telephone, address, area, service_status, sponsor, sale_number, sale_type,
                product_name, price, Integer.parseInt(number), money, sale_person, sale_date, product_spec);
        Outbound outbound = new Outbound(customer_name, product_name, product_spec, price, Integer.parseInt(number),
                money, sale_person, sale_date);
        StockCheck stockCheck = new StockCheck(product_name, product_spec, Integer.parseInt(number));
        UserLogin userLogin = new UserLogin(customer_name, telephone, telephone);

        if (customerService.getCustomerByTelephone(telephone) == null) {
            customerService.addCustomerInfo(customer);
            if (userLoginService.addUserLogin(userLogin)) {
                System.out.println("success!");
            }
        }
        outboundService.addOutboundInfo(outbound);
        stockCheckService.loseCurrentStock(stockCheck);

        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            if (saleService.addSaleInfo(sale)) {
                out.print("<script type=\"text/javascript\">alert('新增成功!');window.location.href='saleinfolist'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('新增失败，请重试!');window.location.href='tosaleadd'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ajax获取产品名称列表
     */
    @RequestMapping(value = "/getproductnamelist", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProductNameList() {
        return productService.getProductNameList();
    }

    /**
     * 根据名称获取规格/型号列表
     */
    @RequestMapping(value = "/getproductspeclist", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getProductSpecList(@RequestParam String product_name) {
        return productService.getProductSpecList(product_name);
    }

    /**
     * ajax根据产品获取价格
     */
    @RequestMapping(value = "/getpricebyproduct", method = RequestMethod.GET)
    @ResponseBody
    public BigDecimal getPriceByProduct(@RequestParam(value = "product_name") String product_name,
                                        @RequestParam(value = "product_spec") String product_spec) {
        return productService.getPriceByProduct(product_name, product_spec);
    }

    /**
     * 根据id获得销售记录
     */
    @RequestMapping(value = "/showsale", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object showSale(@RequestParam(value = "sale_id") String sale_id) {
        Sale sale = saleService.getSaleById(Integer.parseInt(sale_id));
        Map<String, Object> map = new HashMap<>();
        map.put("sale_show", sale);
        return JSONArray.toJSONString(map);
    }

    /**
     * 根据id删除销售信息
     */
    @RequestMapping(value = "/deletesale", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteProduct(@RequestParam String sale_id) {
        HashMap<String, String> resultMap = new HashMap<>();
        if (sale_id == null || sale_id.equals("")) {
            resultMap.put("saleDeleteResult", "notExist");
        } else {
            try {
                if (saleService.deleteSaleById(Integer.parseInt(sale_id))) {
                    resultMap.put("saleDeleteResult", "deleteSuccess");
                } else {
                    resultMap.put("saleDeleteResult", "deleteFailure");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSONArray.toJSONString(resultMap);
    }

    @RequestMapping("/tosalemodify")
    public String toCustomerModify(@RequestParam("sale_id") String sale_id, Model model) {
        Sale saleInfo;
        saleInfo = saleService.getSaleById(Integer.parseInt(sale_id));
        model.addAttribute("saleInfo", saleInfo);
        return "sale/salemodify";
    }

    /**
     * 修改销售信息
     */
    @RequestMapping(value = "/modifysale", method = RequestMethod.POST)
    public void modifyProduct(@ModelAttribute Sale sale, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        Customer customer = new Customer(sale.getCustomer_name(), sale.getTelephone(), sale.getAddress(),
                sale.getArea(), sale.getSale_type(), sale.getService_status(), sale.getSponsor());
        try {
            PrintWriter out = response.getWriter();
            if (saleService.modifySale(sale) || customerService.modifyCustomer(customer)) {
                out.print("<script type=\"text/javascript\">alert('修改成功!');window.location.href='saleinfolist'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('修改失败，请重试!');window.location.href='saleinfolist'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
