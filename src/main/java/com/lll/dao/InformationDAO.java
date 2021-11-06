package com.lll.dao;
import com.lll.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
员工表 DAO层
 */
public interface InformationDAO extends JpaRepository<Information,String>
{
    // 根据员工姓名 查找背景信息
    Information findByEmpName(String empName);

    /**
     * 根据学历 查询相关员工
     * @param infEducation
     * @return
     */
    List<Information> findByInfEducation(String infEducation);

    /**
     * 根据员工政治面貌 查询相关员工
     * @param infPolitical
     * @return
     */
    List<Information> findByInfPolitical(Integer infPolitical);


    /**
     * 根据员工政治面貌 查询相关员工
     * @param infMarital
     * @return
     */
    List<Information> findByInfMarital(Integer infMarital);
}
