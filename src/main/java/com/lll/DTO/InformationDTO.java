package com.lll.DTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lll.enums.InfMaritalEnum;
import com.lll.enums.InfPoliticalEnum;
import com.lll.utils.EnumUtil;
import lombok.Data;

import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 背景信息传输对象
 * @author konvi
 * @version 1.0
 * @date 2021/9/3
 */
@Data
public class InformationDTO {
    /**
     * 序列化版本号
     */
    private static final long serialVersionUID = 1L;

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
     * 入职时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp  //这样入职时间就不会为空了
    private Date infEntry;

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
    private Integer infMarital= InfMaritalEnum.UNMARRIED.getCode(); //默认未婚

    /**
     * 备注
     */
    private String infRemarks;

    /**
     * 获取婚姻状态的枚举类
     */
    @JsonIgnore
    public InfMaritalEnum getInfMaritalEnum()
    {
        return EnumUtil.getByCode(infMarital,InfMaritalEnum.class);
    }

    /**
     * 获取政治面貌的枚举类
     */
    @JsonIgnore
    public InfPoliticalEnum getInfPoliticalEnum()
    {
        return EnumUtil.getByCode(infPolitical,InfPoliticalEnum.class);
    }
}
