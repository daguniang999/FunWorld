package com.cw.fun.http.enums;

public enum HoroscopeDayType {
    TODAY("today", 1),
    TOMORROW("tomorrow", 2),
    WEEK("week", 3),
    MONTH("month", 4),
    YEAR("year", 5);

    private String name;

    private Integer code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    HoroscopeDayType(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static HoroscopeDayType getEnumByCode(Integer code) {
        for (HoroscopeDayType value : HoroscopeDayType.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        return null;
    }
}
