package com.hj.aftersaleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hj.aftersaleservice.domain.Customer;
import com.hj.aftersaleservice.domain.Sale;
import com.hj.aftersaleservice.domain.UserLogin;
import com.hj.aftersaleservice.service.CustomerService;
import com.hj.aftersaleservice.service.SaleService;
import com.hj.aftersaleservice.service.UserLoginService;
import com.hj.aftersaleservice.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class UserLoginController {
    @Resource
    private UserLoginService userLoginService;

    @Resource
    private CustomerService customerService;

    @Resource
    private SaleService saleService;

    @PostMapping(value = "/userlogin")
    public String userLogin(@RequestParam(value = "username") String username, HttpSession session,
                            @RequestParam(value = "password") String password, Model model) {
        UserLogin user = userLoginService.getUserByNameAndPwd(username, password);
        if (user != null) {
            session.setAttribute(Constants.USER_SESSION, user);
            return "user/usermain";
        } else {
            model.addAttribute("userloginerror", Constants.USER_LOGIN_ERROR);
            return "index";
        }
    }

    @RequestMapping(value = "/userlogout")
    public String logout(HttpSession session) {
        if (session.getAttribute(Constants.USER_SESSION) != null) {
            session.removeAttribute(Constants.USER_SESSION);
            return "index";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/tomodifyuserpwd")
    public String toModifyUserPwd() {
        return "user/userpwdmodify";
    }

    @RequestMapping(value = "/modifyuserpwd", method = RequestMethod.POST)
    public String modifyPwd(@RequestParam(value = "password") String password, HttpSession session) {
        Integer user_id = ((UserLogin) session.getAttribute(Constants.USER_SESSION)).getUser_id();
        if (userLoginService.modifyPwd(password, user_id)) {
            return "user/usermain";
        } else {
            return "user/userpwdmodify";
        }
    }

    @RequestMapping(value = "/userinfo")
    public String userInfo(HttpSession session, Model model) {
        String telephone = ((UserLogin) session.getAttribute(Constants.USER_SESSION)).getTelephone();
        Customer c = customerService.getCustomerByTelephone(telephone);
        model.addAttribute("c", c);
        return "user/userinfo";
    }

    @RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
    public void modifyUser(@ModelAttribute Customer customer, HttpServletResponse response, HttpSession session) {
        Integer user_id = ((UserLogin) session.getAttribute(Constants.USER_SESSION)).getUser_id();
        String username = customer.getCustomer_name();
        String telephone = customer.getTelephone();
        UserLogin userLogin = new UserLogin(user_id, username, telephone);

        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            if (customerService.modifyCustomer(customer) && userLoginService.modifyUser(userLogin)) {
                out.print("<script type=\"text/javascript\">alert('修改成功!');window.location.href='userinfo'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('修改失败，请重试!');window.location.href='userinfo'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/purchasehistory")
    public String listPurchaseHistory(@RequestParam(value = "purchase_keyword", required = false) String purchase_keyword,
                                      @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum,
                                      Model model, HttpSession session) {
        String telephone = ((UserLogin) session.getAttribute(Constants.USER_SESSION)).getTelephone();

        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<Sale> buyList = saleService.getPurchaseListByTelephone(telephone, purchase_keyword);
        PageInfo<Sale> salePageInfo = new PageInfo<>(buyList);

        model.addAttribute("buyList", salePageInfo);

        return "user/userpurchasehistory";
    }
}
