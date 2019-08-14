package com.springboot.health.web.controller;

import com.springboot.health.biz.MedicalBedsOfYearService;
import com.springboot.health.domain.po.MedicalBedsOfYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/12 17:23
 */
@RestController
public class MedicalBedsOfYearController {

    @Autowired
    private MedicalBedsOfYearService medicalBedsOfYearService;

    @RequestMapping("/getmedicalbedsofyear")
    public List<MedicalBedsOfYear> getmedicalbedsofyear(){

        return medicalBedsOfYearService.findAll();
    }
}
