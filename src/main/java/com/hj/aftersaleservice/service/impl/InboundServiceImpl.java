package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.InboundMapper;
import com.hj.aftersaleservice.domain.Inbound;
import com.hj.aftersaleservice.service.InboundService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InboundServiceImpl implements InboundService {
    @Resource
    private InboundMapper inboundMapper;

    @Override
    public List<Inbound> getAllInboundList(String counterpart, String operator, String inbound_time) {
        return inboundMapper.getAllInboundList(counterpart, operator, inbound_time);
    }

    @Override
    public boolean addInboundInfo(Inbound inbound) {
        boolean flag = false;
        if (inboundMapper.addInboundInfo(inbound) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean deleteInboundById(Integer inbound_id) {
        boolean flag = false;
        if (inboundMapper.deleteInboundById(inbound_id) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Inbound getInboundById(Integer inbound_id) {
        return inboundMapper.getInboundById(inbound_id);
    }

    @Override
    public boolean modifyInbound(Inbound inbound) {
        boolean flag = false;
        if (inboundMapper.modifyInbound(inbound) > 0) {
            flag = true;
        }
        return flag;
    }
}
