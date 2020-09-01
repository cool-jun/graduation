package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.StockCheckMapper;
import com.hj.aftersaleservice.domain.StockCheck;
import com.hj.aftersaleservice.service.StockCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockCheckServiceImpl implements StockCheckService {
    @Resource
    private StockCheckMapper stockCheckMapper;

    @Override
    public boolean addStockCheckInfo(StockCheck stockCheck) {
        boolean flag = false;
        if (stockCheckMapper.addStockCheckInfo(stockCheck) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean addCurrentStock(StockCheck stockCheck) {
        boolean flag = false;
        if (stockCheckMapper.addCurrentStock(stockCheck) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean loseCurrentStock(StockCheck stockCheck) {
        boolean flag = false;
        if (stockCheckMapper.loseCurrentStock(stockCheck) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<StockCheck> getAllStockCheckList(String keyword) {
        return stockCheckMapper.getAllStockCheckList(keyword);
    }
}
