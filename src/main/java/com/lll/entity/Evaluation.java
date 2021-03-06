package com.lll.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "evaluation")
public class Evaluation implements Serializable
{
    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;

    /** 评价id */
    @Id
    private String evaId;

    /**
     * 员工id 外键
     */
    private String empId;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 员工旷工
     */
    private Integer evaAbsence;

    /** 出勤 */
    private Integer evaAttendance;

    /** 迟到 */
    private Integer evaLate;

    /**
     * 请假
     */
    private Integer evaVacate;

    /** 加班工时 */
    private Integer evaOvertime;

    /** 评级 */
    private String evaLevel;

    /** 备注 */
    private String evaRemarks;
}
