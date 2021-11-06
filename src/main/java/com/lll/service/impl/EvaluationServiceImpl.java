package com.lll.service.impl;


import com.lll.DTO.EvaluationDTO;
import com.lll.DTO.InformationDTO;
import com.lll.dao.EmployeesDAO;
import com.lll.dao.EvaluationDAO;
import com.lll.entity.Evaluation;
import com.lll.entity.Information;
import com.lll.enums.ResultEnum;
import com.lll.exception.PersonnelException;
import com.lll.service.EvaluationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService
{
    @Autowired
    private EvaluationDAO evaluationDAO;


    /**  根据ID查询 */
    @Override
    public Evaluation findByEmpId(String evaId) {
        return evaluationDAO.findById(evaId).orElse(null);
    }

    /**
     * 根据员工id 查询评价信息
     */
    @Override
    public EvaluationDTO queryByEmpId(String empId)
    {
        Evaluation evaluation=evaluationDAO.queryByEmpId(empId);
        if (evaluation==null)
        {
            throw new PersonnelException(ResultEnum.EVALUATION_NOT_EXIT);
        }
        EvaluationDTO evaluationDTO=new EvaluationDTO();
        BeanUtils.copyProperties(evaluation,evaluationDTO);
        return evaluationDTO;

    }

    /**
     * 根据姓名查找员工信息
     */
    @Override
    public EvaluationDTO findByEmpName(String empName)
    {
        Evaluation evaluation=evaluationDAO.findByEmpName(empName);
        if (evaluation==null)
        {
            throw new PersonnelException(ResultEnum.EVALUATION_NOT_EXIT);
        }
        EvaluationDTO evaluationDTO=new EvaluationDTO();
        BeanUtils.copyProperties(evaluation,evaluationDTO);

        return evaluationDTO;
    }

    /**  查询所有 */
    @Override
    public List<Evaluation> findAll() {
        return evaluationDAO.findAll();
    }

    /**
     * 分页查询所有员工信息
     *
     */
    @Override
    public Page<Evaluation> findAll(Pageable pageable)
    {
        return evaluationDAO.findAll(pageable);
    }


    /**  新增 */
    @Override
    public Evaluation save(Evaluation evaluation)

    {
        return evaluationDAO.save(evaluation);
    }

    /**  修改 */
    @Override
    public Evaluation update(Evaluation evaluation)
    {
        //根据员工ID 查询员工信息
        Evaluation evaluation1=evaluationDAO.findById(evaluation.getEmpId()).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (evaluation1==null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);
        }

        //TODO 修改员工信息
        return evaluationDAO.save(evaluation1);
    }

    /**  删除 */
    @Override
    public void delete(String evaId)
    {
        //根据员工ID 查询员工信息
        Evaluation evaluation=evaluationDAO.findById(evaId).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (evaluation==null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);

        }
        else
        {
            evaluationDAO.delete(evaluation);
        }


    }
}

