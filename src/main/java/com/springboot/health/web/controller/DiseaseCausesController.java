package com.springboot.health.web.controller;

import com.springboot.health.biz.DiseaseCausesService;
import com.springboot.health.domain.po.DiseaseCauses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
@RestController
public class DiseaseCausesController {
    @Autowired
    DiseaseCausesService diseaseCausesService;

    @RequestMapping("/getAllDiseaseCauses")
    List<DiseaseCauses> getAllDiseaseCauses()
    {
        return diseaseCausesService.findAll();
    }
    @RequestMapping("/getTotalDiseaseCauses")
    List<DiseaseCauses> getTotalDiseaseCauses()
    {
        return diseaseCausesService.findByType("合计");
    }
    @RequestMapping("/getMaleDiseaseCauses")
    List<DiseaseCauses> getMaleDiseaseCauses()
    {
        return diseaseCausesService.findByType("男");
    }
    @RequestMapping("/getFemaleDiseaseCauses")
    List<DiseaseCauses> getFemalDiseaseCauses()
    {
        return diseaseCausesService.findByType("女");
    }
}
