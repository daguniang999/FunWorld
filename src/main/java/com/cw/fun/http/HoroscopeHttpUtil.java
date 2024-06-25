package com.cw.fun.http;

import com.alibaba.fastjson2.JSONObject;
import com.cw.fun.astrology.enums.AstrologyType;
import com.cw.fun.http.dto.HoroscopeHttpDTO;
import com.cw.fun.http.enums.HoroscopeDayType;
import com.dtflys.forest.Forest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HoroscopeHttpUtil {

    private static final String APP_KEY = "f4ca9bc78cd2837ff196bc6d387a87e1";

    public static final String HOROSCOPE_URL = "http://web.juhe.cn/constellation/getAll";

    public static HoroscopeHttpDTO getHoroscopeData(AstrologyType type, HoroscopeDayType dayType) {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", APP_KEY);
        map.put("consName", type.getName());
        map.put("type", dayType.getName());
        String url = HOROSCOPE_URL;
        url += "?" + params(map);
        String data = Forest.get(url).execute(String.class);
        HoroscopeHttpDTO horoscopeHttpDTO = JSONObject.parseObject(data, HoroscopeHttpDTO.class);
        return horoscopeHttpDTO;
    }

    private static String params(Map<String, String> map) {
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));
    }
}
