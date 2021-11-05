package com.lll.service;

import com.lll.entity.User;
import org.springframework.stereotype.Service;


public interface UserService
{
    //识别登录用户
    boolean verifyUser(User user);

    Integer getUserFlag(String userName);



}

