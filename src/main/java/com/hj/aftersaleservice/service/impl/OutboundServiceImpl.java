package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.OutboundMapper;
import com.hj.aftersaleservice.domain.Outbound;
import com.hj.aftersaleservice.service.OutboundService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OutboundServiceImpl implements OutboundService {
    @Resource
    private OutboundMapper outboundMapper;

    @Override
    public boolean addOutboundInfo(Outbound outbound) {
        boolean flag = false;
        if (outboundMapper.addOutboundInfo(outbound) > 0) {
            flag = true;
        }
        return flag;
    }


    @Override
    public List<Outbound> getAllOutboundList(String outbound_keyword) {
        return outboundMapper.getAllOutboundList(outbound_keyword);
    }
}
