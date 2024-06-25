package com.cw.fun.horoscope.service;

import com.cw.fun.astrology.enums.AstrologyType;
import com.cw.fun.horoscope.util.HoroscopeCacheUtil;
import com.cw.fun.horoscope.pojo.response.HoroscopeResponse;
import com.cw.fun.http.dto.HoroscopeHttpDTO;
import com.cw.fun.http.enums.HoroscopeDayType;
import org.springframework.stereotype.Service;

@Service
public class HoroscopeService {

    public HoroscopeResponse getHoroscope(Integer type) {
        HoroscopeHttpDTO horoscope = HoroscopeCacheUtil.getInstance().getHoroscope(type, HoroscopeDayType.TODAY);
        return HoroscopeResponse.create(horoscope);
    }
}
