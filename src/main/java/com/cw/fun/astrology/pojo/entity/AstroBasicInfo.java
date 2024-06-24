package com.cw.fun.astrology.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
@TableName("astro_basic_info")
public class AstroBasicInfo {
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @TableId(value = "info_id", type = IdType.AUTO)
    private Integer infoId;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 日期
     */
    @ApiModelProperty("日期")
    private String date;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private Integer type;

    /**
     * 优点
     */
    @ApiModelProperty("优点")
    private String strengths;

    /**
     * 缺点
     */
    @ApiModelProperty("缺点")
    private String weaknesses;

    /**
     * 喜欢
     */
    @ApiModelProperty("喜欢")
    private String likes;

    /**
     * 不喜欢
     */
    @ApiModelProperty("不喜欢")
    private String dislikes;

    /**
     * 故事
     */
    @ApiModelProperty("故事")
    private String story;
}