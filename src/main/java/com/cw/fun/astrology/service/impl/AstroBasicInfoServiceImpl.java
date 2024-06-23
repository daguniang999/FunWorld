package com.cw.fun.astrology.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cw.fun.astrology.enums.AstrologyType;
import com.cw.fun.astrology.mapper.AstroBasicInfoMapper;
import com.cw.fun.astrology.pojo.entity.AstroBasicInfo;
import com.cw.fun.astrology.service.AstroBasicInfoService;
import org.springframework.stereotype.Service;

@Service
public class AstroBasicInfoServiceImpl extends ServiceImpl<AstroBasicInfoMapper, AstroBasicInfo> implements AstroBasicInfoService {

    @Override
    public AstroBasicInfo getBasicInfo(Integer type, String date) {
        AstrologyType astroType = AstrologyType.getEnumByCode(type);
        if (astroType == null && StrUtil.isNotBlank(date)) {
            astroType = AstrologyType.getEnumByTime(date);
        }
        return getByType(astroType.getCode());
    }

    @Override
    public AstroBasicInfo getByType(Integer type) {
        return getOne(new LambdaQueryWrapper<AstroBasicInfo>()
                .eq(AstroBasicInfo::getType, type)
        );
    }
}