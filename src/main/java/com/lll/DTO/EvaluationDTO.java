package com.lll.DTO;

import lombok.Data;

@Data
public class EvaluationDTO {
    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;

    /** 评价id */
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
