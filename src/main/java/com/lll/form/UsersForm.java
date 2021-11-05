package com.lll.form;

import com.lll.enums.UserFlagEnum;
import lombok.Data;

/**
 * @author konvi
 * @version 1.0
 * @date 2021/11/5
 */
@Data
public class UsersForm
{
    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户标识,表明不同登录身份
     */
    private Integer userFlag= UserFlagEnum.Employee.getCode();

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户登录密码
     */
    private String password;

    /**
     * 用户备注
     */
    private String userRemarks;
}
