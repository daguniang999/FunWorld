package com.cw.fun.astrology.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("astro_basic_info")
public class AstroBasicInfo {
    @TableId(value = "info_id", type = IdType.AUTO)
    private Integer infoId;
    private String name;
    private Integer type;
    private String strengths;
    private String weaknesses;
    private String likes;
    private String dislikes;
}