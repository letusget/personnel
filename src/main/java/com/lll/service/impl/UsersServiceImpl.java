package com.lll.service.impl;

import com.lll.dao.EvaluationDAO;
import com.lll.dao.InformationDAO;
import com.lll.dao.UsersDAO;
import com.lll.entity.Evaluation;
import com.lll.entity.Information;
import com.lll.entity.Users;
import com.lll.service.UsersService;
import com.lll.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * @author konvi
 * @version 1.0
 * @date 2021/11/5
 */
@Service
@Transactional
public class UsersServiceImpl implements UsersService
{
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private EvaluationDAO evaluationDAO;
    @Autowired
    private InformationDAO informationDAO;

    @Override
    public Users save(Users users) {


        return usersDAO.save(users);
    }

    @Override
    public Users findById(String userId) {
        return usersDAO.findById(userId).orElse(null);
    }
}
