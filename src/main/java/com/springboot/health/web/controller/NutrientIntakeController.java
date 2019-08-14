package com.springboot.health.web.controller;


import com.springboot.health.biz.NutrientIntakeService;
import com.springboot.health.domain.po.NutrientIntake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
@RestController
public class NutrientIntakeController {
    @Autowired
    private NutrientIntakeService nutrientIntakeService;

    @RequestMapping("/getNutrientIntake1")
    public List<NutrientIntake> getNutrientIntake1()
    {
        return nutrientIntakeService.findByNameContainingAndYearAndType("(克)","2012","合计");
    }
    @RequestMapping("/getNutrientIntake2")
    public List<NutrientIntake> getNutrientIntake2()
    {
        return nutrientIntakeService.findByNameContainingAndYearAndType("(毫克)","2012","合计");
    }
    @RequestMapping("/getNutrientIntake3")
    public List<NutrientIntake> getNutrientIntake3()
    {
        return nutrientIntakeService.findByNameContaining("(卡)");
    }
}
