package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.FeedbackMapper;
import com.hj.aftersaleservice.domain.Feedback;
import com.hj.aftersaleservice.service.FeedbackService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public boolean addFeedbackByCustomer(Feedback feedback) {
        boolean flag = false;
        if (feedbackMapper.addFeedbackByCustomer(feedback) > 0) {
            flag = true;
        }
        return flag;
    }
}
