package com.lll.service;

import com.lll.DTO.InformationDTO;
import com.lll.entity.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/*
员工背景信息 Service
 */
public interface InfoService {
    /**
     * 根据员工编号查询员工背景信息
     * @param empId
     * @return
     */
    Information findById(String empId);

    /**
     * 分页查询所有员工工资信息
     * @param pageable
     * @return
     */
    Page<Information> findAll(Pageable pageable);

    /**
     * 新增员工工资信息
     * @param information
     * @return
     */
    Information save(Information information);

    /**
     * 根据员工编号删除员工工资信息
     * @param empId
     * @return
     */
    void delete(String empId);

    // 根据员工姓名查找员工工资信息
    InformationDTO findByEmpName(String empName);
}
