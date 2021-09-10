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
