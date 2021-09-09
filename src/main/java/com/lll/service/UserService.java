package com.lll.service;


import com.lll.dao.UserDAO;
import com.lll.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserDAO userDAO;

    public boolean verifyUser(User user)
    {
        List<User> userList=userDAO.findByUsernameAndPassword
                (user.getUsername(),user.getPassword());


        return userList.size()>0;
    }

}

