package com.cw.fun.astrology.controller;

import com.cw.fun.astrology.pojo.entity.AstroBasicInfo;
import com.cw.fun.astrology.service.AstroBasicInfoService;
import com.cw.fun.common.ResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "/astro/basic", tags = "星座基础信息")
@RestController
@RequestMapping("/astro/basic")
public class AstroBasicInfoController {

    @Autowired
    private AstroBasicInfoService astroBasicInfoService;

    /**
     * 获取所有星座基础信息
     * @return
     */
    @ApiOperation(value = "获取所有星座基础信息", notes = "获取所有星座基础信息", httpMethod = "GET")
    @GetMapping("/all")
    public ResponseInfo<List<AstroBasicInfo>> getAll() {
        return ResponseInfo.successData(astroBasicInfoService.list());
    }

    /**
     * 获取星座基础信息
     * @param type 类型
     * @param date 日期 M-d
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "type", value = "类型"),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "date", value = "日期 M-d")
    })
    @ApiOperation(value = "获取星座基础信息", notes = "获取星座基础信息", httpMethod = "GET")
    @GetMapping
    public ResponseInfo<AstroBasicInfo> getById(@RequestParam(value = "type",required = false) Integer type,
                                                @RequestParam(value = "date", required = false) String date) {
        return ResponseInfo.successData(astroBasicInfoService.getBasicInfo(type, date));
    }

    /**
     * 添加星座基础信息
     * @param astroBasicInfo 星座信息
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "AstroBasicInfo", name = "astroBasicInfo", value = "星座信息", required = true)
    })
    @ApiOperation(value = "添加星座基础信息", notes = "添加星座基础信息", httpMethod = "POST")
    @PostMapping
    public ResponseInfo<Boolean> save(@RequestBody AstroBasicInfo astroBasicInfo) {
        return ResponseInfo.successData(astroBasicInfoService.save(astroBasicInfo));
    }

    /**
     * 修改星座基础信息
     * @param astroBasicInfo 星座信息
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body", dataType = "AstroBasicInfo", name = "astroBasicInfo", value = "星座信息", required = true)
    })
    @ApiOperation(value = "修改星座基础信息", notes = "修改星座基础信息", httpMethod = "PUT")
    @PutMapping
    public ResponseInfo<Boolean> update(@RequestBody AstroBasicInfo astroBasicInfo) {
        return ResponseInfo.successData(astroBasicInfoService.updateById(astroBasicInfo));
    }

    /**
     * 删除星座基础信息
     * @param id 星座ID
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "int", name = "id", value = "星座ID", required = true)
    })
    @ApiOperation(value = "删除星座基础信息", notes = "删除星座基础信息", httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseInfo<Boolean> delete(@PathVariable Integer id) {
        return ResponseInfo.successData(astroBasicInfoService.removeById(id));
    }
}