package com.lll.dao;
import com.lll.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

/*
员工表 DAO层
 */
public interface InfoDAO extends JpaRepository<Information,String>
{
    // 根据员工姓名 查找背景信息
    Information findByEmpName(String empName);
}
