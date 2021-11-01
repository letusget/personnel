/*
package com.lll.service.impl;

import com.lll.dao.SalariesDAO;
import com.lll.DTO.SalariesDTO;
import com.lll.entity.Salaries;
import com.lll.enums.ResultEnum;
import com.lll.exception.PersonnelException;
import com.lll.service.SalariesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

*/
/**
 * 工资表 Service层实现类
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 *//*

@Service
@Transactional
public class SalariesServiceImpl implements SalariesService
{
    @Autowired
    private SalariesDAO salariesDAO;

    */
/**
     * 根据员工编号查询员工工资信息
     * @param empId
     * @return
     *//*

    @Override
    public Salaries findById(String empId)
    {
        return salariesDAO.findById(empId).orElse(null);
    }

    */
/**
     * 分页查询所有员工工资信息
     * @param pageable
     * @return
     *//*

    @Override
    public Page<Salaries> findAll(Pageable pageable)
    {
        return salariesDAO.findAll(pageable);
    }

    */
/**
     * 新增员工工资信息
     * @param salaries
     * @return
     *//*

    @Override
    public Salaries save(Salaries salaries)
    {
        return salariesDAO.save(salaries);
    }

    */
/**
     * 根据员工编号删除员工工资信息
     * @param empId
     *//*

    @Override
    public void delete(String empId)
    {
        //根据员工ID 查询员工信息
        Salaries salaries = salariesDAO.findById(empId).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (salaries == null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_SALARIES_NOT_EXIST);
        }

        else
        {
            salariesDAO.delete(salaries);
        }
    }

    */
/*@Override
    public SalariesDTO findByEmpName(String empName)
    {
        // 根据员工姓名查询 员工信息
        Salaries salaries = salariesDAO.findByEmpName(empName);
        if (salaries == null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);
        }


        SalariesDTO  salariesDTO = new SalariesDTO();
        BeanUtils.copyProperties(salaries, salariesDTO);
        return salariesDTO;
    }*//*

}
*/
