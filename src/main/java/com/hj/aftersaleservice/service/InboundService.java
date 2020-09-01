package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.Inbound;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InboundService {
    /**
     * 根据条件查询所有的入库记录
     * @param counterpart
     * @param operator
     * @param inbound_time
     * @return
     */
    List<Inbound> getAllInboundList(String counterpart, String operator, String inbound_time);

    /**
     * 新增入库信息
     * @param inbound
     * @return
     */
    boolean addInboundInfo(Inbound inbound);

    /**
     * 根据id删除入库记录
     * @param inbound_id
     * @return
     */
    boolean deleteInboundById(@Param(value = "inbound_id") Integer inbound_id);

    /**
     * 根据id得到入库记录
     * @param inbound_id
     * @return
     */
    Inbound getInboundById(@Param(value = "inbound_id") Integer inbound_id);

    /**
     * 修改入库记录
     * @param inbound
     * @return
     */
    boolean modifyInbound(Inbound inbound);
}
