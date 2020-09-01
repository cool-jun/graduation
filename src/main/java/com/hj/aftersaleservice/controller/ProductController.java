package com.hj.aftersaleservice.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hj.aftersaleservice.domain.DataDictionary;
import com.hj.aftersaleservice.domain.Product;
import com.hj.aftersaleservice.domain.StockCheck;
import com.hj.aftersaleservice.service.DataDictionaryService;
import com.hj.aftersaleservice.service.ProductService;
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
import java.util.Map;

@Controller
public class ProductController {
    @Resource
    private ProductService productService;

    @Resource
    private DataDictionaryService dataDictionaryService;
    
    @Resource
    private StockCheckService stockCheckService;

    /**
     * 根据条件查询产品信息
     */
    @RequestMapping("/productinfolist")
    public String listProduct(Model model,
                              @RequestParam(value = "product_name", required = false) String product_name,
                              @RequestParam(value = "product_type", required = false) String product_type,
                              @RequestParam(value = "product_brand", required = false) String product_brand,
                              @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum) {
        List<Product> productList;
        List<DataDictionary> productTypeList;
        List<DataDictionary> productBrandList;

        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        productList = productService.getAllProductList(product_name, product_type, product_brand);
        PageInfo<Product> productPageInfo = new PageInfo<>(productList);

        productTypeList = dataDictionaryService.getDataDictionaryList("product_type");
        productBrandList = dataDictionaryService.getDataDictionaryList("brand_type");

        model.addAttribute("productList", productPageInfo);
        model.addAttribute("productTypeList", productTypeList);
        model.addAttribute("productBrandList", productBrandList);
        model.addAttribute("product_name", product_name);
        model.addAttribute("product_type", product_type);
        model.addAttribute("product_brand", product_brand);

        return "product/productlist";
    }

    @RequestMapping("/toaddproduct")
    public String toAddCustomerInfo() {
        return "product/productadd";
    }

    /**
     * 根据id删除产品信息
     */
    @RequestMapping("/deleteproduct")
    @ResponseBody
    public Object deleteProduct(@RequestParam String product_id) {
        HashMap<String, String> resultMap = new HashMap<>();
        if (product_id == null || product_id.equals("")) {
            resultMap.put("productDeleteResult", "notExist");
        } else {
            try {
                if (productService.deleteProductById(Integer.parseInt(product_id))) {
                    resultMap.put("productDeleteResult", "deleteSuccess");
                } else {
                    resultMap.put("productDeleteResult", "deleteFailure");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return JSONArray.toJSONString(resultMap);
    }

    /**
     * 根据id查看产品信息
     */
    @RequestMapping(value = "/showproduct", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object showProduct(@RequestParam String product_id) {
        Product product = productService.showProductById(Integer.parseInt(product_id));
        Map<String, Object> map = new HashMap<>();
        map.put("show_product", product);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/toproductmodify")
    public String toCustomerModify(@RequestParam("product_id") String product_id, Model model) {
        Product productInfo;
        productInfo = productService.getProductById(Integer.parseInt(product_id));
        model.addAttribute("productInfo", productInfo);
        return "product/productmodify";
    }

    /**
     * 修改产品信息
     */
    @RequestMapping(value = "/modifyproduct", method = RequestMethod.POST)
    public void modifyProduct(@ModelAttribute Product product, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            if (productService.modifyProduct(product)) {
                out.print("<script type=\"text/javascript\">alert('修改成功!');window.location.href='productinfolist'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('修改失败，请重试!');window.location.href='productinfolist'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增产品信息
     */
    @RequestMapping(value = "productinfoadd", method = RequestMethod.POST)
    public void addProduct(@ModelAttribute Product product, HttpServletResponse response) {
        StockCheck stockCheck = new StockCheck(product.getProduct_name(), product.getProduct_spec());
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            if (productService.addProductInfo(product) && stockCheckService.addStockCheckInfo(stockCheck)) {
                out.print("<script type=\"text/javascript\">alert('新增成功!');window.location.href='productinfolist'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('新增失败，请重试!');window.location.href='toaddproduct'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
