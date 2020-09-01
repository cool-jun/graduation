package com.hj.aftersaleservice.controller;

import com.hj.aftersaleservice.domain.Manager;
import com.hj.aftersaleservice.service.ManagerService;
import com.hj.aftersaleservice.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class ManagerController {
    @Resource
    private ManagerService managerService;

    @PostMapping(value = "/adminlogin")
    public String managerLogin(@RequestParam(value = "jobNumber") String jobNumber, HttpSession session,
                               @RequestParam(value = "password") String password, Model model) {
        Manager admin = managerService.getManagerByNameAndPwd(jobNumber, password);
        if (admin != null) {
            session.setAttribute(Constants.ADMIN_SESSION, admin);
            return "main";
        } else {
            model.addAttribute("adminloginerror", Constants.ADMIN_LOGIN_ERROR);
            return "adminlogin";
        }
    }

    @RequestMapping(value = "/adminlogout")
    public String logout(HttpSession session) {
        if (session.getAttribute(Constants.ADMIN_SESSION) != null) {
            session.removeAttribute(Constants.ADMIN_SESSION);
            return "adminlogin";
        } else {
            return "error";
        }
    }
}
