package com.hj.aftersaleservice.dao;

import com.hj.aftersaleservice.domain.UserLogin;
import org.apache.ibatis.annotations.Param;

public interface UserLoginMapper {
    int addUserLogin(UserLogin userLogin);

    UserLogin getUserByNameAndPwd(@Param(value = "username") String username, @Param(value = "password") String password);
    
    int modifyPwd(@Param(value = "password") String password, @Param(value = "user_id") Integer user_id);

    int modifyUser(UserLogin userLogin);
}
