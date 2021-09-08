package com.lll.service;

import com.lll.entity.Departments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface DepartmentsService
{
    /**  根据ID查询 */
    Departments findById(String depId);

    /** 查询所有  */
    List<Departments> findAll();

    /**
     * 分页查询所有员工信息
     */
    Page<Departments> findAll(Pageable pageable);

    /**  新增  */
    Departments save(Departments  departments);

    /** 修改*/
    Departments update(Departments departments);

    /**
     * 删除员工信息
     */
    void delete(String empId);
    //EmployeesDTO delete(String empId);
}
