package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.Inbound;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InboundMapper {
    int addInboundInfo(Inbound inbound);

    Inbound getInboundById(@Param(value = "inbound_id") Integer inbound_id);

    int deleteInboundById(@Param(value = "inbound_id") Integer inbound_id);

    List<Inbound> getAllInboundList(@Param(value = "counterpart") String counterpart,
                                    @Param(value = "operator") String operator,
                                    @Param(value = "inbound_time") String inbound_time);

    int modifyInbound(Inbound inbound);
}
