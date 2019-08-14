package com.springboot.health.web.controller;

import com.springboot.health.biz.PatientNumService;
import com.springboot.health.domain.po.PatientNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/11 23:13
 */
@RestController
public class PatientNumController {

    @Autowired
    private PatientNumService patientNumService;

    @RequestMapping("/getpatientnum")
    public List<PatientNum> getpatientnum(){
        return patientNumService.findAll();
    }

}
