package com.lll.service;

import com.lll.DTO.EvaluationDTO;
import com.lll.entity.Evaluation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EvaluationService
{
    /**  根据ID查询 */
    Evaluation findById(String evaId);

    /**
     * 根据姓名查询员工信息
     * */
    EvaluationDTO findByEmpName(String empName);

    /** 查询所有  */
    List<Evaluation> findAll();

    /**
     * 分页查询所有员工信息
     */
    Page<Evaluation> findAll(Pageable pageable);

    /**  新增  */
    Evaluation save(Evaluation  evaluation);

    /** 修改*/
    Evaluation update(Evaluation evaluation);

    /**  删除  */
    void delete(String evaId);
}
