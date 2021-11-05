package com.lll.entity;

import com.lll.enums.UserFlagEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author konvi
 * @version 1.0
 * @date 2021/11/5
 */
@Entity
@Data
@Table(name = "users")
public class Users implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @Id
    @Column(name = "id")
    private String userId;

    /**
     * 用户标识,表明不同登录身份
     */
    @Column(name = "user_flag")
    private Integer userFlag= UserFlagEnum.Employee.getCode();

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户登录密码
     */
    @Column(name = "user_password")
    private String password;

    /**
     * 用户备注
     */
    private String userRemarks;
}
