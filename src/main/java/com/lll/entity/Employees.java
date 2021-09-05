package com.lll.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lll.enums.EmpMaritalEnum;
import com.lll.enums.EmpSexEnum;
import com.lll.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 员工表对应的 JavaBean
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
@Table(name="employees")
public class Employees implements Serializable
{
    private static final long serialVersionUID=1L;

    /**
     * 员工id号
     */
    @Id
    //用自定义主键策略 生成自定义主键ID
    //参考：https://www.cnblogs.com/DevMuYuer/p/10088425.html
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "emp-id")
    @GenericGenerator(name = "emp-id", strategy = "com.lll.utils.EmpIDGenerator")
    private String empId;

    /**
     * 员工照片
     */
    //这里需要标明这个地段，否则JPA 会自动添加数据库字段，出现问题
    @Column(name="emp_id_photo")
    private String empPhoto;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 员工性别
     * 1为男生，0为女生
     */
    //private Integer empSex;
    private Integer empSex= EmpSexEnum.MAN.getCode();   //默认为男生

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
    //这里需要标明这个地段，否则JPA 会自动添加数据库字段，出现问题
    @Column(name = "emp_id_card")
    private String empIdCard;

    /**
     * 员工入职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp  //这样入职时间就不会为空了
    private Date empEntry;

    /**
     *员工婚姻状况
     * 1 为已婚
     * 0 为未婚
     */
    //private Integer empMarital;
    private Integer empMarital= EmpMaritalEnum.UNMARRIED.getCode(); //默认未婚

    /**
     * 备注
     */
    private String empRemarks;

    /**
     * 获取性别  枚举常量类
     */
    @JsonIgnore
    public EmpSexEnum getEmpSexEnum()
    {
        return EnumUtil.getByCode(empSex,EmpSexEnum.class);
    }

    /**
     * 获取婚姻状态的枚举类
     */
    @JsonIgnore
    public EmpMaritalEnum getEmpMaritalEnum()
    {
        return EnumUtil.getByCode(empMarital,EmpMaritalEnum.class);
    }

}
