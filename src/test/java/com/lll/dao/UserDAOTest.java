package com.lll.dao;

import com.lll.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDAOTest
{
    @Autowired
    private UserDAO userDAO;

    @Test
    public void findByUsernameAndPassword()
    {
        List<User> userList = userDAO.findByUsernameAndPassword("root","123456");
        System.out.println("target:");
        System.out.println(userList);
    }
}