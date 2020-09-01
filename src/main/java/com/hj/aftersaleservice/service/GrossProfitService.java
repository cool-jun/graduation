package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.GrossProfit;

import java.util.List;

public interface GrossProfitService {
    List<GrossProfit> listAllGrossProfit(String profit_word);
}
