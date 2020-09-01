package com.hj.aftersaleservice.service.impl;

import com.hj.aftersaleservice.dao.UserLoginMapper;
import com.hj.aftersaleservice.domain.UserLogin;
import com.hj.aftersaleservice.service.UserLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Resource
    private UserLoginMapper userLoginMapper;

    @Override
    public boolean addUserLogin(UserLogin userLogin) {
        boolean flag = false;
        if (userLoginMapper.addUserLogin(userLogin) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public UserLogin getUserByNameAndPwd(String username, String password) {
        return userLoginMapper.getUserByNameAndPwd(username, password);
    }

    @Override
    public boolean modifyPwd(String password, Integer user_id) {
        boolean flag = false;
        if (userLoginMapper.modifyPwd(password, user_id) > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean modifyUser(UserLogin userLogin) {
        boolean flag = false;
        if (userLoginMapper.modifyUser(userLogin) > 0) {
            flag = true;
        }
        return flag;
    }
}
