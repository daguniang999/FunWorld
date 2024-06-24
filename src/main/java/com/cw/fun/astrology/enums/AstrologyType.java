package com.cw.fun.astrology.enums;

import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public enum AstrologyType {

	Aries("白羊座", "aries", 1, MonthDay.of(3, 21), MonthDay.of(4, 19)),
	Taurus("金牛座" , "taurus", 2, MonthDay.of(4, 20), MonthDay.of(5, 20)),
	Gemini("双子座" ,"gemini", 3, MonthDay.of(5, 21), MonthDay.of(6, 20)),
	Cancer("巨蟹座", "cancer", 4, MonthDay.of(6, 21), MonthDay.of(7, 22)),
	Leo("狮子座", "leo", 5, MonthDay.of(7, 23), MonthDay.of(8, 22)),
	Virgo("处女座", "virgo", 6, MonthDay.of(8, 23), MonthDay.of(9, 22)),
	Libra("天秤座", "libra", 7, MonthDay.of(9, 23), MonthDay.of(10, 22)),
	Scorpio("天蝎座", "scorpio", 8, MonthDay.of(10, 23), MonthDay.of(11, 21)),
	Sagittarius("射手座", "sagittarius", 9, MonthDay.of(11, 22), MonthDay.of(12, 21)),
	Capricorn("摩羯座", "capricorn", 10, MonthDay.of(12, 22), MonthDay.of(1, 19)),
	Aquarius("水瓶座", "aquarius", 11, MonthDay.of(1, 20), MonthDay.of(2, 18)),
	Pisces("双鱼座", "pisces", 12, MonthDay.of(2, 19), MonthDay.of(3, 20));

    private String name;

    private Integer code;

    private String en;

    private MonthDay startTime;

    private MonthDay endTime;

    private AstrologyType(String name, String en, Integer code, MonthDay startTime, MonthDay endTime) {
        this.name = name;
        this.code = code;
        this.en = en;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public static AstrologyType getEnumByCode(Integer code) {
        for (AstrologyType value : AstrologyType.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }

        return null;
    }

    public static AstrologyType getEnumByTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M-d");
        MonthDay monthDay = MonthDay.parse(time, formatter);
        for (AstrologyType value : AstrologyType.values()) {
            if (isBetween(monthDay, value.startTime, value.endTime)) {
                return value;
            }
        }
        return null;
    }
    private static boolean isBetween(MonthDay date, MonthDay start, MonthDay end) {
        return (date.equals(start) || date.equals(end) || (date.isAfter(start) && date.isBefore(end)));
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }
}
