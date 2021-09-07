package com.lll.service.impl;


import com.lll.enums.ResultEnum;
import com.lll.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDAO userDAO;
    /**
     * 注册用户
     *
     * @param user
     * /
    @Override
    public User insertUser(User user)
    {
        return userDAO.save(user);
    }

    /**
     * 确定该用户是否已经被注册，
     * 根据用户名，查找用户信息
     *
     * @param username
     * /
    @Override
    public User selectByUser(String username)
    {
        //无法实现，这里 形参必须是username 才可以使用ajax，但是JPA 无法通过username来进行查找
        //User user= userDAO.findById(username);

        return null;
    }

    /**
     * 接受用户名 和密码 ，进行注册
     *
     * @param username
     * @param password
     * /
    @Override
    public User register(String username, String password)
    {
        User user=new User();
        user.setUserId(KeyUtil.genUniqueKey());
        user.setUserName(username);
        user.setUserPassword(password);

        return userDAO.save(user);
    }
}

*/