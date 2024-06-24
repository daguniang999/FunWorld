package com.cw.fun.horoscope.pojo.response;

import com.cw.fun.http.HoroscopeDTO;
import lombok.Data;

@Data
public class HoroscopeResponse {

    private String name;

    private String today;

    public static HoroscopeResponse create(String name, String horoscope) {
        HoroscopeResponse horoscopeResponse = new HoroscopeResponse();
        horoscopeResponse.setToday(horoscope);
        horoscopeResponse.setName(name);
        return horoscopeResponse;
    }
}
