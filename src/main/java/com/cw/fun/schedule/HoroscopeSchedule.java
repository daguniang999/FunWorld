package com.cw.fun.schedule;

import com.cw.fun.horoscope.util.HoroscopeCacheUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HoroscopeSchedule {

    @Scheduled(cron = "0 0 0 * * ?")
    public void cleanHoroscope() {
        HoroscopeCacheUtil.getInstance().clean();
    }
}