package com.lll.dao;

import com.lll.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * 员工 DAO
 */
public interface EmployeesDAO extends JpaRepository<Employees,String>
{
    /**
     * 根据员工姓名 查询相关员工
     * @return
     */
    List<Employees> queryByEmpName(String empName);

    /**
     * 根据员工姓名 查询相关员工 (不考虑重名)
     * @param empName
     * @return
     */
    Employees findByEmpName(String empName);

    /**
     * 根据部门名称 查询相关员工
     * @param depName
     * @return
     */
    List<Employees> findByDepName(String depName);

    /**
     * 根据员工性别 查询相关员工
     * @param empSex
     * @return
     */
    List<Employees> findByEmpSex(Integer empSex);
}
