package com.lll.dao;

import com.lll.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author konvi
 * @version 1.0
 * @date 2021/11/5
 */
public interface UsersDAO extends JpaRepository<Users, String>
{

}

