package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.ManagerMapper;
import com.hj.aftersaleservice.domain.Manager;
import com.hj.aftersaleservice.service.ManagerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerMapper managerMapper;

    @Override
    public Manager getManagerByNameAndPwd(String jobNumber, String password) {
        return managerMapper.getManagerByNameAndPwd(jobNumber, password);
    }
}
