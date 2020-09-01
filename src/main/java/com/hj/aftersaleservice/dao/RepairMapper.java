package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.Repair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RepairMapper {
    int addRepairByCustomer(Repair repair);

    List<Repair> getAllRepairList(@Param(value = "repairKeyword") String repairKeyword);

    List<Repair> getUserRepairList(@Param(value = "userRepairKeyword") String userRepairKeyword,
                                   @Param(value = "cTelephone") String cTelephone);

    Repair getRepairById(@Param(value = "repair_id") Integer repair_id);

    int updateUserRemark(@Param(value = "repair_id") Integer repair_id, @Param(value = "cRemark") String cRemark);

    int handleUserRepair(Repair repair);
}
