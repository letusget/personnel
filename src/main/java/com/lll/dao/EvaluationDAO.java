package com.lll.dao;

import com.lll.entity.Evaluation;
import com.lll.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationDAO extends JpaRepository<Evaluation, String>
{
    /**
     *根据id查询
     */
    List<Evaluation> queryByEmpId(String empId);

    /**
     * 根据姓名查询
     */
    Evaluation findByEmpName(String empName);
}
