package com.lll.service.impl;

import com.lll.dao.EvaluationDAO;
import com.lll.dao.EmployeesDAO;
import com.lll.dao.InformationDAO;
import com.lll.entity.Employees;
import com.lll.entity.Evaluation;
import com.lll.entity.Information;
import com.lll.DTO.EmployeesDTO;
import com.lll.enums.ResultEnum;
import com.lll.exception.PersonnelException;
import com.lll.service.EmployeesService;
import com.lll.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeesServiceImpl implements EmployeesService
{
    @Autowired
    private EmployeesDAO employeesDAO;

    @Autowired
    private InformationDAO informationDAO;

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
        //String Id=employees.getEmpId();
        //新建工资和评价信息
       /* Salaries salaries=new Salaries();
        EvaluationDTO evaluation=new EvaluationDTO();
        //salaries(Id,employees.getEmpName(),8000,0,"无",0,"",0,8000,"");
        salaries.setEmpId(Id);
        salaries.setEmpName(employees.getEmpName());
        salaries.setSalBase(new BigDecimal(800));
        salaries.setSalBonus(new BigDecimal(0));
        salaries.setSalBonusDescribes("无");
        salaries.setSalFine(new BigDecimal(0));
        salaries.setSalFineDescribes("无");
        salaries.setSalBenefits(new BigDecimal(100));
        salaries.setSalFinal(new BigDecimal(900));
        salaries.setSalRemarks("无");*/


        //TODO 评价信息的新增
        /*evaluation.setEmpId(Id);
        evaluation.setEvaAttendance(22);
        evaluation.setEvaLate(0);
        evaluation.setEvaLevel("B");
        evaluation.setEvaOvertime(0);
        evaluation.setEvaRemarks("无");

        //保存评价和工资表信息
        salariesDAO.save(salaries);
        evaluationDAO.save(evaluation);*/
        //新增员工 工资信息


        String Id=employees.getEmpId();
        String Name=employees.getEmpName();

        //System.out.println(Id);
        //System.out.println(Name);


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

        // 根据员工ID 查询背景信息
        Information information = informationDAO.findByEmpId(empId);

        // 根据员工ID 查询评价信息
        Evaluation evaluation=evaluationDAO.queryByEmpId(empId);

        //如果员工不存在，就抛出异常：员工不存在
        if (employee == null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);
        }
        else
        {
            employeesDAO.delete(employee);
        }

       /* if (salaries != null)
        {
            salariesDAO.delete(salaries);
        }*/
        if (information != null)
        {
            informationDAO.delete(information);
        }

        if (evaluation != null)
        {
            evaluationDAO.delete(evaluation);
        }

    }

    @Override
    public EmployeesDTO findByEmpName(String empName)
    {
        // 根据员工姓名查询 员工信息
        Employees employees = employeesDAO.findByEmpName(empName);
        if (employees == null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_NOT_EXIST);
        }

        EmployeesDTO  employeesDTO = new EmployeesDTO();
        BeanUtils.copyProperties(employees, employeesDTO);
        return employeesDTO;
    }

    @Override
    public List<Employees> findByDepName(String depName)
    {
        // 根据部门名称查询 员工信息
        List<Employees> employeesList= employeesDAO.findByDepName(depName);
        if (employeesList == null)
        {
            throw new PersonnelException(ResultEnum.DEPARTMENTS_NOT_EXIST);
        }

        EmployeesDTO  employeesDTO = new EmployeesDTO();
        BeanUtils.copyProperties(employeesList, employeesDTO);
        return employeesList;
    }

    @Override
    public List<Employees> findByEmpSex(Integer empSex)
    {
        // 根据性别查询 员工信息
        List<Employees> employeesSexList= employeesDAO.findByEmpSex(empSex);
        if (employeesSexList == null)
        {
            throw new PersonnelException(ResultEnum.DEPARTMENTS_NOT_EXIST);
        }

        EmployeesDTO  employeesDTO = new EmployeesDTO();
        BeanUtils.copyProperties(employeesSexList, employeesDTO);
        return employeesSexList;
    }


}
