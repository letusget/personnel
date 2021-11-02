package com.lll.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 登录用户 标识符 枚举类
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserFlagEnum implements CodeEnum<Integer>
{
    Admin(0,"超级管理员"),
    Manager(1,"主管经理"),
    Employee(2,"公司职员");

    private Integer code;
    private String message;
}
