package com.springboot.health.web.controller;

import com.springboot.health.biz.MedicalBedsOfAreaService;
import com.springboot.health.domain.po.MedicalBedsOfArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/12 18:37
 */
@RestController
public class MedicalBedsOfAreaController {

    @Autowired
    private MedicalBedsOfAreaService medicalBedsOfAreaService ;
    @RequestMapping("/getmedicalbedsofarea")
    public List<MedicalBedsOfArea> getmedicalbedsofarea(){
        return medicalBedsOfAreaService.findAll();
    }
}
