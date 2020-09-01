package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.GrossProfitMapper;
import com.hj.aftersaleservice.domain.GrossProfit;
import com.hj.aftersaleservice.service.GrossProfitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GrossProfitServiceImpl implements GrossProfitService {
    @Resource
    private GrossProfitMapper grossProfitMapper;

    @Override
    public List<GrossProfit> listAllGrossProfit(String profit_word) {
        return grossProfitMapper.listAllGrossProfit(profit_word);
    }
}
