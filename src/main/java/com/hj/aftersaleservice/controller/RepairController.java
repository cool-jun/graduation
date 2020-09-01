package com.hj.aftersaleservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hj.aftersaleservice.domain.Repair;
import com.hj.aftersaleservice.domain.UserLogin;
import com.hj.aftersaleservice.service.RepairService;
import com.hj.aftersaleservice.utils.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class RepairController {
    @Resource
    private RepairService repairService;

    @RequestMapping(value = "/toaddrepair")
    public String toAddRepair() {
        return "repair/repairing";
    }

    @RequestMapping(value = "/repairing", method = RequestMethod.POST)
    public void addRepairByCustomer(@ModelAttribute Repair repair, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            if (repairService.addRepairByCustomer(repair)) {
                out.print("<script type=\"text/javascript\">alert('申请报修成功!');window.location.href='userrepairlist'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('申请报修失败，请重试!');window.location.href='toaddrepair'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/repairhandle")
    public String repairHandle(@RequestParam(value = "repairKeyword", required = false) String repairKeyword,
                               @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum,
                               Model model) {
        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<Repair> repairList = repairService.getAllRepairList(repairKeyword);
        PageInfo<Repair> repairPageInfo = new PageInfo<>(repairList);

        model.addAttribute("repairList", repairPageInfo);
        model.addAttribute("repairKeyword", repairKeyword);

        return "repair/repairhandle";
    }

    @RequestMapping(value = "/userrepairlist")
    public String userRepairList(@RequestParam(value = "userRepairKeyword", required = false) String userRepairKeyword,
                                 @RequestParam(defaultValue = "1", required = false, value = "pageNum") int pageNum,
                                 Model model, HttpSession session) {
        String cTelephone = ((UserLogin)session.getAttribute(Constants.USER_SESSION)).getTelephone();

        PageHelper.startPage(pageNum, Constants.PAGE_SIZE);
        List<Repair> userRepairList = repairService.getUserRepairList(userRepairKeyword, cTelephone);
        PageInfo<Repair> repairPageInfo = new PageInfo<>(userRepairList);

        model.addAttribute("userRepairList", repairPageInfo);
        model.addAttribute("userRepairKeyword", userRepairKeyword);

        return "repair/userrepairlist";
    }

    @RequestMapping(value = "/torepairremark")
    public String toRepairRemark(@RequestParam(value = "repair_id") String repair_id, Model model) {
        Repair repair = repairService.getRepairById(Integer.parseInt(repair_id));
        model.addAttribute("repair", repair);
        return "repair/userremark";
    }

    @RequestMapping(value = "/torepairhandle")
    public String toRepairHandle(@RequestParam(value = "repair_id") String repair_id, Model model) {
        Repair repair = repairService.getRepairById(Integer.parseInt(repair_id));
        model.addAttribute("adminrepair", repair);
        return "repair/adminhandling";
    }

    @RequestMapping(value = "/updateuserremark", method = RequestMethod.POST)
    public void updateUserRemark(@RequestParam(value = "repair_id") String repair_id,
                                   @RequestParam(value = "cRemark") String cRemark, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            if (repairService.updateUserRemark(Integer.parseInt(repair_id), cRemark)) {
                out.print("<script type=\"text/javascript\">alert('评价成功!');window.location.href='userrepairlist'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('评价失败，请重试!');window.location.href='torepairremark'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/handleuserrepair", method = RequestMethod.POST)
    public void handleUserRepair(@ModelAttribute Repair repair, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            if (repairService.handleUserRepair(repair)) {
                out.print("<script type=\"text/javascript\">alert('处理成功!');window.location.href='repairhandle'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('处理失败，请重试!');window.location.href='repairhandle'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
