package com.lll.dao;

import com.lll.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentsDAO extends JpaRepository<Departments, String>
{
    /**
     *根据id查询
     */
    List<Departments> queryByDepId(String depId);
}
