package com.springboot.health.web.controller;

import com.springboot.health.biz.YoungDevelopmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/youngdevelopment")
public class YoungDevelopmentController {
    @Autowired
    private YoungDevelopmentService youngDevelopmentService;

    @GetMapping("/show")
    public HashMap<String,Object> show(String year,String gender){
        HashMap<String,Object> map = new HashMap<>();
        List<Float> city = youngDevelopmentService.getHeightData("城市",year,gender);
        List<Float> country = youngDevelopmentService.getHeightData("乡村",year,gender);

        map.put("city",city);
        map.put("country",country);

        return map;
    }

}
