package com.lll.service.impl;

import com.lll.dao.UserDAO;
import com.lll.entity.User;
import com.lll.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService
{
    //对对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    // 通过 @Autowired的使用来消除 set ，get方法
    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean verifyUser(User user)
    {
        List<User> userList=userDAO.findByUsernameAndPassword
                (user.getUsername(),user.getPassword());


        return userList.size()>0;
    }
}
