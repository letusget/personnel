package com.lll.dao;


import com.lll.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户DAO接口
 */
@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Long>
//public interface UserDAO extends CrudRepository<User,Long>
{
    /**
     * 验证用户用户
     */
    List<User> findByUsernameAndPassword(String name, String password);

}

