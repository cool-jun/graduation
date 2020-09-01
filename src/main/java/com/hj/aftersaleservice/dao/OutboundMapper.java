package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.Outbound;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutboundMapper {
    int addOutboundInfo(Outbound outbound);

    List<Outbound> getAllOutboundList(@Param(value = "outbound_keyword") String outbound_keyword);
}
