package com.hj.aftersaleservice.controller;

import com.hj.aftersaleservice.domain.Feedback;
import com.hj.aftersaleservice.service.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class FeedbackController {
    @Resource
    private FeedbackService feedbackService;

    @RequestMapping(value = "/toaddfeedback")
    public String toAddFeedback() {
        return "feedback/feedbacking";
    }

    @RequestMapping(value = "/feedbacking", method = RequestMethod.POST)
    public void addFeedbackByCustomer(@ModelAttribute Feedback feedback, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        try {
            PrintWriter out = response.getWriter();
            if ((feedbackService.addFeedbackByCustomer(feedback))) {
                out.print("<script type=\"text/javascript\">alert('投诉反馈成功!');window.location.href='toaddfeedback'</script>");
            } else {
                out.print("<script type=\"text/javascript\">alert('投诉反馈失败，请重试!');window.location.href='toaddfeedback'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
