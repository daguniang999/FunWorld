package com.cw.fun.horoscope.controller;

import com.cw.fun.common.ResponseInfo;
import com.cw.fun.horoscope.pojo.response.HoroscopeResponse;
import com.cw.fun.horoscope.service.HoroscopeService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "/horoscope", tags = "星座运势")
@RestController
@RequestMapping("/horoscope")
public class HoroscopeController {

    @Resource
    HoroscopeService horoscopeService;

    /**
     * 获取今日运势
     * @param type
     * @return
     */
    @GetMapping("/today")
    public ResponseInfo<HoroscopeResponse> getToday(@RequestParam("type") Integer type) {
        HoroscopeResponse horoscopeResponse = horoscopeService.getHoroscope(type);
        return ResponseInfo.successData(horoscopeResponse);
    }
}
