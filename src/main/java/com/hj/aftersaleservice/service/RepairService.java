package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.Repair;

import java.util.List;

public interface RepairService {
    boolean addRepairByCustomer(Repair repair);

    List<Repair> getAllRepairList(String repairKeyword);

    List<Repair> getUserRepairList(String userRepairKeyword, String cTelephone);

    Repair getRepairById(Integer repair_id);

    boolean updateUserRemark(Integer repair_id, String cRemark);

    boolean handleUserRepair(Repair repair);
}
