package com.cw.fun.http.dto;

import lombok.Data;

@Data
public class HoroscopeHttpDTO {
    private String name; // 星座名称
    private String datetime; // 日期
    private int date; // 日期数字
    private int all; // 综合指数
    private String color; // 幸运色
    private int health; // 健康指数
    private int love; // 爱情指数
    private int money; // 财运指数
    private int number; // 幸运数字
    private String QFriend; // 速配星座
    private String summary; // 今日概述
    private int work; // 工作指数
    private int error_code; // 返回码
}

   
