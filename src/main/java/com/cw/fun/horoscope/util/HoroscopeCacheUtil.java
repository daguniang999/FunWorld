package com.cw.fun.horoscope.util;

import com.cw.fun.astrology.enums.AstrologyType;
import com.cw.fun.http.HoroscopeDTO;
import com.cw.fun.http.YouDaoUtil;
import com.dtflys.forest.Forest;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class HoroscopeCacheUtil {

    private static HoroscopeCacheUtil horoscopeCacheUtil;

    private Cache<Integer, String> horoscopeCache = CacheBuilder.newBuilder()
            .initialCapacity(12)
            .maximumSize(12)
            .build();

    public static HoroscopeCacheUtil getInstance() {
        if (horoscopeCacheUtil == null) {
            horoscopeCacheUtil = new HoroscopeCacheUtil();
        }
        return horoscopeCacheUtil;
    }

    public String getHoroscope(Integer type) {
        try {
            return horoscopeCache.get(type, new Callable<String>() {
                @Override
                public String call() throws Exception {
                    String url = "https://ohmanda.com/api/horoscope/";
                    AstrologyType astroType = AstrologyType.getEnumByCode(type);
                    url += astroType.getEn();
                    HoroscopeDTO horoscopeData = Forest.get(url).execute(HoroscopeDTO.class);
                    String translate = YouDaoUtil.getTranslate(horoscopeData.getHoroscope());
                    return translate;
                }
            });
        } catch (ExecutionException e) {
            return "";
        }
    }

    public void clean() {
        horoscopeCache.cleanUp();
    }
}