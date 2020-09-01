package com.hj.aftersaleservice.service;

import com.hj.aftersaleservice.domain.UserLogin;

public interface UserLoginService {
    boolean addUserLogin(UserLogin userLogin);
    
    boolean modifyPwd(String password, Integer user_id);

    boolean modifyUser(UserLogin userLogin);

    UserLogin getUserByNameAndPwd(String username, String password);
}
