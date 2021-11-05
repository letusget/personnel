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
        String Id=users.getUserId();
        String Name=users.getUserName();

        System.out.println(Id);
        System.out.println(Name);

        //TODO
        /**
        新增背景信息
         */
        Information information=new Information();
        information.setInfId(KeyUtil.genUniqueKey());
        information.setEmpId(Id);
        information.setEmpName(Name);
        information.setInfEducation("本科");
        information.setInfPolitical(new Integer(0));
        information.setInfPlace("江苏南京");
        information.setInfMarital(new Integer(0));
        information.setInfRemarks("无");

        /**
         * 新增评价信息
         */
        Evaluation evaluation=new Evaluation();
        evaluation.setEvaId(KeyUtil.genUniqueKey());
        evaluation.setEmpId(Id);
        evaluation.setEmpName(Name);
        evaluation.setEvaAbsence(new Integer(0));
        evaluation.setEvaAttendance(new Integer(22));
        evaluation.setEvaLate(new Integer(0));
        evaluation.setEvaVacate(new Integer(0));
        evaluation.setEvaOvertime(new Integer(0));
        evaluation.setEvaLevel("B");
        evaluation.setEvaRemarks("暂无");

        //保存信息
        informationDAO.save(information);
        evaluationDAO.save(evaluation);


        return usersDAO.save(users);
    }

    @Override
    public Users findById(String userId) {
        return usersDAO.findById(userId).orElse(null);
    }
}
