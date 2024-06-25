package com.cw.fun.horoscope.util;

import com.cw.fun.astrology.enums.AstrologyType;
import com.cw.fun.horoscope.pojo.response.HoroscopeResponse;
import com.cw.fun.http.HoroscopeHttpUtil;
import com.cw.fun.http.dto.HoroscopeDTO;
import com.cw.fun.http.YouDaoUtil;
import com.cw.fun.http.dto.HoroscopeHttpDTO;
import com.cw.fun.http.enums.HoroscopeDayType;
import com.dtflys.forest.Forest;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class HoroscopeCacheUtil {

    private static HoroscopeCacheUtil horoscopeCacheUtil;

    private Cache<Integer, HoroscopeHttpDTO> horoscopeCache = CacheBuilder.newBuilder()
            .initialCapacity(12)
            .maximumSize(12)
            .build();

    public static HoroscopeCacheUtil getInstance() {
        if (horoscopeCacheUtil == null) {
            horoscopeCacheUtil = new HoroscopeCacheUtil();
        }
        return horoscopeCacheUtil;
    }

    public HoroscopeHttpDTO getHoroscope(Integer type, HoroscopeDayType dayType) {
        try {
            return horoscopeCache.get(type, new Callable<HoroscopeHttpDTO>() {
                @Override
                public HoroscopeHttpDTO call() throws Exception {
                    return HoroscopeHttpUtil.getHoroscopeData(AstrologyType.getEnumByCode(type), dayType);
                }
            });
        } catch (ExecutionException e) {
            return new HoroscopeHttpDTO();
        }
    }

    public void clean() {
        horoscopeCache.cleanUp();
    }
}