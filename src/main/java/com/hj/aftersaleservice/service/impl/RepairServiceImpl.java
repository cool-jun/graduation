package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.RepairMapper;
import com.hj.aftersaleservice.domain.Repair;
import com.hj.aftersaleservice.service.RepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    @Resource
    private RepairMapper repairMapper;

    @Override
    public boolean addRepairByCustomer(Repair repair) {
        boolean flag = false;
        if (repairMapper.addRepairByCustomer(repair) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Repair> getAllRepairList(String repairKeyword) {
        return repairMapper.getAllRepairList(repairKeyword);
    }

    @Override
    public List<Repair> getUserRepairList(String userRepairKeyword, String cTelephone) {
        return repairMapper.getUserRepairList(userRepairKeyword, cTelephone);
    }

    @Override
    public Repair getRepairById(Integer repair_id) {
        return repairMapper.getRepairById(repair_id);
    }

    @Override
    public boolean updateUserRemark(Integer repair_id, String cRemark) {
        boolean flag = false;
        if (repairMapper.updateUserRemark(repair_id, cRemark) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean handleUserRepair(Repair repair) {
        boolean flag = false;
        if (repairMapper.handleUserRepair(repair) > 0) {
            flag = true;
        }
        return flag;
    }
}
