package com.lll.service.impl;

import com.lll.DTO.DepartmentsDAO;
import com.lll.entity.Departments;
import com.lll.enums.ResultEnum;
import com.lll.exception.PersonnelException;
import com.lll.service.DepartmentsService;
import com.lll.exception.PersonnelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsServiceImpl implements DepartmentsService
{
    @Autowired
    private DepartmentsDAO departmentsDAO;

    /**  根据ID查询 */
    @Override
    public Departments findById(String depId) {
        return departmentsDAO.findById(depId).orElse(null);
    }

    /**  查询所有 */
    @Override
    public List<Departments> findAll() {
        return departmentsDAO.findAll();
    }

    /**
     * 分页查询所有员工信息
     *
     */
    @Override
    public Page<Departments> findAll(Pageable pageable)
    {
        return departmentsDAO.findAll(pageable);
    }


    /**  新增 */
    @Override
    public Departments save(Departments departments)

    {
        return departmentsDAO.save(departments);
    }

    /**  修改 */
    public Departments update(Departments departments)
    {
        //根据员工ID 查询员工信息
        Departments department=departmentsDAO.findById(departments.getDepId()).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (department==null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);
        }

        //TODO 修改员工信息
        return departmentsDAO.save(department);
    }

    /**  删除 */
    @Override
    public void delete(String depId)
    {
        //根据员工ID 查询员工信息
        Departments departments=departmentsDAO.findById(depId).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (departments==null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);

        }
        else
        {
            departmentsDAO.delete(departments);
        }


    }
}

