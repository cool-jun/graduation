package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.Manager;
import org.apache.ibatis.annotations.Param;

public interface ManagerMapper {
    Manager getManagerByNameAndPwd(@Param(value = "jobNumber") String jobNumber, @Param(value = "password") String password);
}
