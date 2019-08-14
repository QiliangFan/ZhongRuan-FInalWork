package com.springboot.health.web.controller;

import com.springboot.health.domain.po.HealthBlog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(ModelMap modelMap){
        modelMap.put("user", new HealthBlog());
        return "test";
    }

    @RequestMapping("/index")
    public String toIndex(ModelMap modelMap)
    {
        return "index";
    }
    @RequestMapping("/blog")
    public String toBlog()
    {
        return "blog";
    }
    @RequestMapping("/datashow")
    public String toDatashow()
    {
        return "datashow";
    }
//    @RequestMapping("/nutrientintakedatashow")
//    public String toDatashow1()
//    {
//        return "nutrientintakedatashow";
//    }

    @RequestMapping("/datashowPopulation")
    public String toDatashowPopulation(){
        return "datashowPopulation";
    }

    @RequestMapping("/datashowExpectedLifeMap")
    public String toDatashowExpectedLifeMap(){
        return "datashowExpectedLifeMap";
    }

    @RequestMapping("/datashowMyPie")
    public String toDatashowMyPie(){
        return "datashowMyPie";
    }

    @RequestMapping("/datashowMedicalInstitution")
    public String toDataShowMedicalInstitution(){
        return "datashowMedicalInstitution";
    }

    @RequestMapping("/nutrientintakedatashow")
    public String toDatashow1()
    {
        return "nutrientintakedatashow";
    }
    @RequestMapping("/diseasecausesdatashow")
    public String toDatashow2()
    {
        return "diseasecausesdatashow";
    }
    @RequestMapping("/medicalexpendituredatashow")
    public String toMedicalExpenditure()
    {
        return "medicalexpendituredatashow";
    }
}
