package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.Outbound;

import java.util.List;

public interface OutboundService {
    boolean addOutboundInfo(Outbound outbound);

    List<Outbound> getAllOutboundList(String outbound_keyword);
}
