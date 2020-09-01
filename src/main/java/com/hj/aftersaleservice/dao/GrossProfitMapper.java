package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.GrossProfit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrossProfitMapper {
    List<GrossProfit> listAllGrossProfit(@Param(value = "profit_word") String profit_word);
}
