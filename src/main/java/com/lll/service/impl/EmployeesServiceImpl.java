package com.lll.service.impl;

import com.lll.dao.EvaluationDAO;
import com.lll.dao.EmployeesDAO;
import com.lll.dao.ISalariesDAO;
import com.lll.entity.Employees;
import com.lll.entity.Evaluation;
import com.lll.entity.Salaries;
import com.lll.enums.ResultEnum;
import com.lll.exception.PersonnelException;
import com.lll.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService
{
    @Autowired
    private EmployeesDAO employeesDAO;

    @Autowired
    private ISalariesDAO salariesDAO;

    @Autowired
    private EvaluationDAO evaluationDAO;


    /**
     * 根据员工ID 查询员工信息
     *
     * @param empId
     */
    @Override
    public Employees findByEmpId(String empId) {
        return employeesDAO.findById(empId).orElse(null);
    }

    /**
     * 查询所有员工信息  不分页
     */
    @Override
    public List<Employees> findUpAll(String empName) {
        return employeesDAO.queryByEmpName(empName);
    }

    /**
     * 分页查询所有员工信息
     *
     * @param pageable
     */
    @Override
    public Page<Employees> findAll(Pageable pageable)
    {
        return employeesDAO.findAll(pageable);
    }

    /**
     * 新增员工
     *
     * @param employees
     */
    @Override
    public Employees save(Employees employees)
    {
        //获取 EmpId
        String Id=employees.getEmpId();
        //新建工资和评价信息
        Salaries salaries=new Salaries();
        Evaluation evaluation=new Evaluation();
        //salaries(Id,employees.getEmpName(),8000,0,"无",0,"",0,8000,"");
        salaries.setEmpId(Id);
        salaries.setEmpName(employees.getEmpName());
        salaries.setSalBase(new BigDecimal(8000));
        salaries.setSalBonus(new BigDecimal(0));
        salaries.setSalBonusDescribes("无");
        salaries.setSalFine(new BigDecimal(0));
        salaries.setSalFineDescribes("无");
        salaries.setSalBenefits(new BigDecimal(1000));
        salaries.setSalFinal(new BigDecimal(9000));
        salaries.setSalRemarks("无");

        evaluation.setEmpId(Id);
        evaluation.setEvaAttendance(22);
        evaluation.setEvaLate(0);
        evaluation.setEvaLevel("B");
        evaluation.setEvaOvertime(0);
        evaluation.setEvaRemarks("无");

        //保存评价和工资表信息
        salariesDAO.save(salaries);
        evaluationDAO.save(evaluation);
        //新增员工 工资信息
        return employeesDAO.save(employees);
    }

    /**
     * 修改员工信息
     *
     * @param employees
     */
    @Override
    public Employees update(Employees employees)
    {
        //根据员工ID 查询员工信息
        Employees employee=employeesDAO.findById(employees.getEmpId()).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (employee==null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);
        }

        //TODO 修改员工信息
        return employeesDAO.save(employee);
    }

    /**
     * 删除员工信息
     *
     * @param empId
     */
    @Override
    public void delete(String empId)
    {
        //根据员工ID 查询员工信息
        Employees employee=employeesDAO.findById(empId).orElse(null);

        // 根据员工ID 查询工资信息
        Salaries salaries = salariesDAO.findById(empId).orElse(null);

        // 根据员工ID 查询评价信息
        Evaluation evaluation = evaluationDAO.findById(empId).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (employee == null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);
        }
        else
        {
            employeesDAO.delete(employee);
        }

        if (salaries != null)
        {
            salariesDAO.delete(salaries);
        }

        if (evaluation != null)
        {
            evaluationDAO.delete(evaluation);
        }

    }
}
