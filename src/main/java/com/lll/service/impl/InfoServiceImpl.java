package com.lll.service.impl;

import com.lll.DTO.InformationDTO;
import com.lll.dao.InformationDAO;
import com.lll.entity.Information;
import com.lll.enums.ResultEnum;
import com.lll.exception.PersonnelException;
import com.lll.service.InfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 背景信息表 Service层实现类
 * @author konvi
 * @version 1.0
 * @date 2021/9/1
 */
@Service
@Transactional
public class InfoServiceImpl implements InfoService
{
    @Autowired
    private InformationDAO informationDAO;


    /**
     * 根据员工编号查询员工工资信息
     * @param infId
     * @return
     */
    @Override
    public Information findById(String infId)
    {
        return informationDAO.findById(infId).orElse(null);
    }

    /**
     * 分页查询所有员工工资信息
     * @param pageable
     * @return
     */
    @Override
    public Page<Information> findAll(Pageable pageable)
    {
        return informationDAO.findAll(pageable);
    }

    /**
     * 新增员工工资信息
     * @param information
     * @return
     */
    @Override
    public Information save(Information information)
    {
        return informationDAO.save(information);
    }

    /**
     * 根据员工编号删除员工工资信息
     * @param infId
     */
    @Override
    public void delete(String infId)
    {
        //根据员工ID 查询员工信息
        Information information = informationDAO.findById(infId).orElse(null);

        //如果员工不存在，就抛出异常：员工不存在
        if (information == null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_INFORMATION_NOT_EXIST);
        }

        else
        {
            informationDAO.delete(information);
        }
    }

    /**
     * 根据员工姓名查找员工工资信息
     * @param empName
     * @return
     */
    @Override
    public InformationDTO findByEmpName(String empName)
    {
        // 根据员工姓名查询 员工信息
        Information information = informationDAO.findByEmpName(empName);
        if (information == null)
        {
            throw new PersonnelException(ResultEnum.EMPLOYEE_INFORMATION_NOT_EXIST);
        }

        InformationDTO informationDTO = new InformationDTO();
        BeanUtils.copyProperties(information, informationDTO);
        return informationDTO;
    }
    @Override
    public  List<Information> findByInfEducation(String infEducation)
    {
        // 根据学历查询 员工信息
        List<Information> informationList= informationDAO.findByInfEducation(infEducation);
        if (informationList == null)
        {
            throw new PersonnelException(ResultEnum.DEPARTMENTS_NOT_EXIST);
        }

        InformationDTO informationDTO = new InformationDTO();
        BeanUtils.copyProperties(informationList, informationDTO);
        return informationList;
    }

    @Override
    public  List<Information> findByInfPolitical(Integer infPolitical)
    {
        // 根据政治面貌查询 员工信息
        List<Information> infPoliticalList= informationDAO.findByInfPolitical(infPolitical);
        if (infPoliticalList == null)
        {
            throw new PersonnelException(ResultEnum.DEPARTMENTS_NOT_EXIST);
        }

        InformationDTO informationDTO = new InformationDTO();
        BeanUtils.copyProperties(infPoliticalList, informationDTO);
        return infPoliticalList;
    }

    @Override
    public  List<Information> findByInfMarital(Integer infMarital)
    {
        // 根据婚姻状况查询 员工信息
        List<Information> infMaritalList= informationDAO.findByInfMarital(infMarital);
        if (infMaritalList == null)
        {
            throw new PersonnelException(ResultEnum.DEPARTMENTS_NOT_EXIST);
        }

        InformationDTO informationDTO = new InformationDTO();
        BeanUtils.copyProperties(infMaritalList, informationDTO);
        return infMaritalList;
    }
}
