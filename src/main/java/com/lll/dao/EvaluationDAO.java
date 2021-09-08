package com.lll.dao;

import com.lll.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationDAO extends JpaRepository<Evaluation, String>
{
    /**
     *根据id查询
     */
    List<Evaluation> queryByEmpId(String empId);
}
