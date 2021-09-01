package com.lll.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 员工表对应的 JavaBean
 */
@Entity
@Data
@DynamicInsert
@Table(name="employees")
public class Employees implements Serializable
{
    private static final long serialVersionUID=1L;

    /**
     * 员工id号
     */
    @Id
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
