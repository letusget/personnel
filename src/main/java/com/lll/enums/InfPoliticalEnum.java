package com.lll.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 政治面貌枚举
 * @author konvi
 * @version 1.0
 * @date 2021/11/2
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum InfPoliticalEnum implements CodeEnum<Integer>
{
    COMMUNIST(0,"共产党员"),
    LEAGUE_MEMBER(1,"共青团员"),
    THE_MASSES(2,"群众"),
    NON(3,"无党派人士"),
    Other_parties(4,"其他党派人士");

    private Integer code;

    private String message;
}

