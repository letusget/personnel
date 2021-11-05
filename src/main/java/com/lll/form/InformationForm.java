package com.lll.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lll.enums.InfMaritalEnum;
import com.lll.utils.EnumUtil;
import lombok.Data;

import javax.persistence.Id;

/**
 * 封装 背景表信息
 * @author konvi
 * @version 1.0
 * @date 2021/9/4
 */
@Data
public class InformationForm {
    /**
     * 信息ID
     */
    private String infId;


    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 学历
     */
    private String infEducation;

    /**
     * 政治面貌
     */
    private Integer infPolitical;

    /**
     * 籍贯
     */
    private String infPlace;

    /**
     * 婚姻状况
     */
    private Integer infMarital = InfMaritalEnum.UNMARRIED.getCode(); //默认未婚

    /**
     * 备注
     */
    private String infRemarks;

    /**
     * 获取婚姻状态的枚举类
     */
    @JsonIgnore
    public InfMaritalEnum getInfMaritalEnum() {
        return EnumUtil.getByCode(infMarital, InfMaritalEnum.class);
    }

    /**
     * 获取政治面貌的枚举类
     */
    @JsonIgnore
    public InfMaritalEnum getEmpMaritalEnum() {
        return EnumUtil.getByCode(infMarital, InfMaritalEnum.class);
    }
}
