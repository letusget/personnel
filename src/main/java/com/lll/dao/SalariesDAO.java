package com.lll.dao;

import com.lll.entity.Employees;
import com.lll.entity.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 工资表 DAO层
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
public interface SalariesDAO extends JpaRepository<Salaries,String>
{
    Salaries findByEmpName(String empName);
}
