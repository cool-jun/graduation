package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.StockCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockCheckMapper {
    int addStockCheckInfo(StockCheck stockCheck);

    int addCurrentStock(StockCheck stockCheck);

    int loseCurrentStock(StockCheck stockCheck);

    List<StockCheck> getAllStockCheckList(@Param(value = "keyword") String keyword);
}
