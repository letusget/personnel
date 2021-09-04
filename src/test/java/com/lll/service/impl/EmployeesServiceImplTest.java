package com.lll.service.impl;

import com.lll.entity.Employees;
import com.lll.service.EmployeesService;
import com.lll.utils.KeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesServiceImplTest {

    @Autowired
    private EmployeesService employeesService;

    /**
     * 新增员工
     */
    @Test
    public void save()
    {
        Employees employees=new Employees();
        employees.setEmpId(KeyUtil.genUniqueKey());
        employees.setEmpPhoto("https://tvax4.sinaimg.cn/large/006x3t5Xgy1gu4z6sowa6j60hr0ew74e02.jpg");
        employees.setEmpName("王小花");
        employees.setEmpSex(0);
        employees.setEmpEmail("klajdfajfklj@qq.com");
        employees.setEmpPhone("14758429512");
        employees.setDepId("1");
        employees.setDepName("底层架构组");
        employees.setEmpIdCard("147854135894158453158");
        employees.setEmpRemarks("yes!");

        Employees result= employeesService.save(employees);
        System.out.println(result);

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}