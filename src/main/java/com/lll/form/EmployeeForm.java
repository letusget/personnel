package com.lll.form;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

/**
 * 封装员工信息修改 新增 传递的数据
 */
@Data
public class EmployeeForm
{
    /**
     * 员工id号
     */
    private String empId;

    /**
     * 员工照片
     */
    private String empPhoto;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 员工性别
     * 1为男生，0为女生
     */
    private Integer empSex;

    /**
     * 员工邮箱
     */
    private String empEmail;

    /**
     * 员工手机号码
     */
    private String empPhone;

    /**
     * 员工部门编号
     */
    private String depId;

    /**
     * 员工部门名称
     */
    private String depName;

    /**
     * 员工身份证号码
     */
    private String empIdCard;

    /**
     * 员工入职时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private Date empEntry;

    /**
     *员工婚姻状况
     * 1 为已婚
     * 0 为未婚
     */
    private Integer empMarital;

    /**
     * 备注
     */
    private String empRemarks;
}
