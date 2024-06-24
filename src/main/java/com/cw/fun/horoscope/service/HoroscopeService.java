package com.cw.fun.horoscope.service;

import com.cw.fun.astrology.enums.AstrologyType;
import com.cw.fun.horoscope.util.HoroscopeCacheUtil;
import com.cw.fun.horoscope.pojo.response.HoroscopeResponse;
import org.springframework.stereotype.Service;

@Service
public class HoroscopeService {

    public HoroscopeResponse getHoroscope(Integer type) {
        String horoscope = HoroscopeCacheUtil.getInstance().getHoroscope(type);
        AstrologyType astroType = AstrologyType.getEnumByCode(type);
        return HoroscopeResponse.create(astroType.getName(), horoscope);
    }
}
