package com.lll.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 对错误结果的枚举类
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultEnum
{
    EMPLOYEE_NOT_EXIST(100,"该员工不存在");

    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String message;

}