package com.cw.fun.astrology.controller;

import com.cw.fun.astrology.pojo.entity.AstroBasicInfo;
import com.cw.fun.astrology.service.AstroBasicInfoService;
import com.cw.fun.common.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/astro/basic")
public class AstroBasicInfoController {

    @Autowired
    private AstroBasicInfoService astroBasicInfoService;

    @GetMapping("/all")
    public ResponseInfo<List<AstroBasicInfo>> getAll() {
        return ResponseInfo.successData(astroBasicInfoService.list());
    }

    @GetMapping
    public ResponseInfo<AstroBasicInfo> getById(@RequestParam(value = "type",required = false) Integer type, @RequestParam(value = "date", required = false) String date) {
        return ResponseInfo.successData(astroBasicInfoService.getBasicInfo(type, date));
    }


    @PostMapping
    public ResponseInfo<Boolean> save(@RequestBody AstroBasicInfo astroBasicInfo) {
        return ResponseInfo.successData(astroBasicInfoService.save(astroBasicInfo));
    }

    @PutMapping
    public ResponseInfo<Boolean> update(@RequestBody AstroBasicInfo astroBasicInfo) {
        return ResponseInfo.successData(astroBasicInfoService.updateById(astroBasicInfo));
    }

    @DeleteMapping("/{id}")
    public ResponseInfo<Boolean> delete(@PathVariable Integer id) {
        return ResponseInfo.successData(astroBasicInfoService.removeById(id));
    }
}