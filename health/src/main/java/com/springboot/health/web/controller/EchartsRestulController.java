package com.springboot.health.web.controller;

import com.springboot.health.biz.ExpectedLifeService;
import com.springboot.health.biz.MedicalInstitutionsService;
import com.springboot.health.biz.PopulationratioService;
import com.springboot.health.domain.po.ExpectedLife;
import com.springboot.health.domain.po.MedicalInstitutions;
import com.springboot.health.domain.po.Populationratio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EchartsRestulController {
    @Autowired
    ExpectedLifeService expectedLifeService;
    @Autowired
    PopulationratioService populationratioService;
    @Autowired
    MedicalInstitutionsService medicalInstitutionsService;

    @RequestMapping("/expectedLifeMap")
    public String expectedLifeMap(){
        List<ExpectedLife> expectedLives = expectedLifeService.findAllByYearAndType(2010, "合计");
        StringBuilder sb =new StringBuilder();
        sb.append("{\"data\":[");
        for(ExpectedLife e:expectedLives){
            sb.append("{");
            sb.append("\"name\":").append("\""+e.getCity()+"\"").append(",");
            sb.append("\"value\":").append("\""+e.getExpectedlife()+"\"");
            sb.append("}").append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("]}");
        String json = sb.toString();
        return json;
    }

    @RequestMapping("/getpopuratio")
    public List<Populationratio> getpopuratio(){
        List<Populationratio> populationratios=populationratioService.findAll();
        return populationratios;
    }

    @RequestMapping("/getMedicalInstitutions")
    public List<MedicalInstitutions> getMedicalInstitutions(){
        List<MedicalInstitutions> medicalInstitutions=medicalInstitutionsService.findALl();
        System.out.println(medicalInstitutions);
        return medicalInstitutions;
    }
}

