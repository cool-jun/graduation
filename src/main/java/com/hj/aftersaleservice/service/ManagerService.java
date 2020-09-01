package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.Manager;

public interface ManagerService {
    Manager getManagerByNameAndPwd(String jobNumber, String password);
}
