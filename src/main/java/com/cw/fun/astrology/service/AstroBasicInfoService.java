package com.cw.fun.astrology.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cw.fun.astrology.pojo.entity.AstroBasicInfo;

public interface AstroBasicInfoService extends IService<AstroBasicInfo> {
    AstroBasicInfo getBasicInfo(Integer type, String date);

    AstroBasicInfo getByType(Integer type);
}