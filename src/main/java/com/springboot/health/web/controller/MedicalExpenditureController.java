package com.springboot.health.web.controller;

import com.springboot.health.biz.MedicalExpenditureService;
import com.springboot.health.domain.po.MedicalExpenditure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
@RestController
public class MedicalExpenditureController {
    @Autowired
    private MedicalExpenditureService medicalExpenditureService;
    @RequestMapping("/getMedicalExpenditure1")
    List<MedicalExpenditure> getMedicalExpenditure1()
    {
        return medicalExpenditureService.findByTypeAndByOrderBySubtype("地区");
    }
    @RequestMapping("/getMedicalExpenditure2")
    List<MedicalExpenditure> getMedicalExpenditure2()
    {
        return medicalExpenditureService.findByTypeAndSubtype("年份","2017");

    }
    @RequestMapping("/getMedicalExpenditure3")
    List<MedicalExpenditure> getMedicalExpenditure3()
    {
        return medicalExpenditureService.findByTypeAndByOrderBySubtype("年份");

    }
}
