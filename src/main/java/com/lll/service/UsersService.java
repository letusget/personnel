package com.lll.service;

import com.lll.entity.Users;

/**
 * @author konvi
 * @version 1.0
 * @date 2021/11/5
 */
public interface UsersService
{
    /**
     * 新增用户
     * @param users
     * @return
     */
    Users save(Users users);

    /**
     * 按用户ID查询用户
     * @param userId
     * @return
     */
    Users findById(String userId);
}
