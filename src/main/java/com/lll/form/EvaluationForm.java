package com.lll.form;
import java.util.Date;
import lombok.Data;
/**
* 封装员工信息修改 新增 传递的数据
*/
@Data
public class EvaluationForm {

    /** 员工id */
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

