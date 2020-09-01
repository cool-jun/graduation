package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.Feedback;

public interface FeedbackMapper {
    int addFeedbackByCustomer(Feedback feedback);
}
