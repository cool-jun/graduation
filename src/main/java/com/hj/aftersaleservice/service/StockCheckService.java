package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.StockCheck;

import java.util.List;

public interface StockCheckService {
    boolean addStockCheckInfo(StockCheck stockCheck);

    boolean addCurrentStock(StockCheck stockCheck);

    boolean loseCurrentStock(StockCheck stockCheck);

    List<StockCheck> getAllStockCheckList(String keyword);
}
