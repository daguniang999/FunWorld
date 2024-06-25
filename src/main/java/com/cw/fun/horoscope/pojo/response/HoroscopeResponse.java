package com.cw.fun.horoscope.pojo.response;

import com.cw.fun.http.dto.HoroscopeHttpDTO;
import lombok.Data;

@Data
public class HoroscopeResponse {

    private String name;

    private String datetime; // 日期

    private int date; // 日期数字

    private int all; // 综合指数

    private String color; // 幸运色

    private int health; // 健康指数

    private int love; // 爱情指数

    private int money; // 财运指数

    private int number; // 幸运数字

    private String QFriend; // 速配星座

    private String today; // 今日概述

    private int work; // 工作指数

    private int error_code; // 返回码


    public static HoroscopeResponse create(HoroscopeHttpDTO horoscopeDTO) {
        HoroscopeResponse horoscopeResponse = new HoroscopeResponse();
        horoscopeResponse.setName(horoscopeDTO.getName());
        horoscopeResponse.setToday(horoscopeDTO.getSummary());
        horoscopeResponse.setDate(horoscopeDTO.getDate());
        horoscopeResponse.setColor(horoscopeDTO.getColor());
        horoscopeResponse.setHealth(horoscopeDTO.getHealth());
        horoscopeResponse.setLove(horoscopeDTO.getLove());
        horoscopeResponse.setNumber(horoscopeDTO.getNumber());
        horoscopeResponse.setQFriend(horoscopeDTO.getQFriend());
        horoscopeResponse.setDatetime(horoscopeDTO.getDatetime());
        horoscopeResponse.setMoney(horoscopeDTO.getMoney());
        horoscopeResponse.setWork(horoscopeDTO.getWork());
        return horoscopeResponse;
    }
}
